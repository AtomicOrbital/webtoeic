package com.example.webtoeic.service;

import com.example.webtoeic.entity.User;
import com.example.webtoeic.repository.UserRepositoty;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepositoty userRepositoty;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Đoạn JWT_SECRET là bí mật, chỉ có phía server biết
    private final Key JWT_SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    // Thời gian có hiêu lực của jwt (10 ngày)
    private final long JWT_EXPIRATION = 864000000L;

    public String createSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretBytes = new byte[36]; //36*8=288 (>256 bits required for HS256)
        secureRandom.nextBytes(secretBytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(secretBytes);
    }
    public String login(String email, String password){
        User user = userRepositoty.findByEmail(email);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            // Thong tin dang nhap dung tao ra token
            return createToken(user);
        }
        throw new BadCredentialsException("Invalid email or password");
    }

    public User register(String email, String password){
        //Kiểm tra xem email tồn tại không
        User existingUser = userRepositoty.findByEmail(email);
//        if(existingUser.isPresent()){
//            throw new IllegalAccessException("Email already in use");
//        }

        // Ma hoa mat khau
        String encryptedPassword = passwordEncoder.encode(password);

        // Tao nguoi dung moi va luu vao co so du lieu
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(encryptedPassword);

        return userRepositoty.save(newUser);
    }

    private String createToken(User user) {
        // Thời gian hết hạn của Token
        Date expiryDate = new Date(System.currentTimeMillis() + JWT_EXPIRATION);
        //Tạo chuỗi json web token từ id của user
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("roles",mapRoles(user.getVaiTro()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public List<String> mapRoles(int vaiTro) {
        List<String> roles = new ArrayList<>();
        switch (vaiTro){
            case 1:
                roles.add("ROLE_USER");
                break;
            case 2:
                roles.add("ROLE_ADMIN");
                break;
        }
        return roles;
    }

    public String verifyToken(String token){
        try {
            // Giải mã token
            String email = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            // trả về email từ token
            return email;
        } catch (Exception e){
            // Nếu token không hợp lệ, hoặc hết hạn trả về null
            return null;
        }
    }
}
