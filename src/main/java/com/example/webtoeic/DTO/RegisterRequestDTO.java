package com.example.webtoeic.DTO;

public class RegisterRequestDTO {
   private String diaChi;
   private String email;
   private String hoTen;
   private String password;
   private String soDienThoai;

   public RegisterRequestDTO(){

   }

    public RegisterRequestDTO(String diaChi, String email, String hoTen, String password, String soDienThoai) {
        this.diaChi = diaChi;
        this.email = email;
        this.hoTen = hoTen;
        this.password = password;
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
