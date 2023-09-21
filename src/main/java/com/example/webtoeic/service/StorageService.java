package com.example.webtoeic.service;

import com.example.webtoeic.entity.BaiGrammar;
import com.example.webtoeic.repository.FileDataRepository;
import com.example.webtoeic.util.ImageUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class StorageService {
    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "/media/thanhdat/data1/JavaCyber/JavaSpring/webtoeic/Myfile/";

    public String uploadImageToFileSystem(MultipartFile file) {
        byte[] compressedData;
        try {
            compressedData = ImageUtils.compressImage(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String filePath = FOLDER_PATH + file.getOriginalFilename();

        // Save the COMPRESSED image data to the file system
        try {
            Files.write(new File(filePath).toPath(), compressedData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Save the file name to the database
        BaiGrammar fileData = fileDataRepository.save(BaiGrammar.builder()
                .anhBaiGrammar(file.getOriginalFilename())
                .build());
        if(fileData != null){
            return "File uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        String filePath = FOLDER_PATH + fileName;

        // Read the COMPRESSED image data from the file system
        byte[] compressedData = Files.readAllBytes(new File(filePath).toPath());

        // Decompress the data
        byte[] decompressedData;
        try {
            decompressedData = ImageUtils.decompressImage(compressedData);
        } catch (Exception e) {
            throw new RuntimeException("Error while decompressing image", e);
        }

        return decompressedData;
    }
}

