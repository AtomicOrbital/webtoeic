package com.example.webtoeic.service;

import com.example.webtoeic.entity.BaiGrammar;
import com.example.webtoeic.repository.FileDataRepository;
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
        byte[] imageData;
        try {
            imageData = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String newFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // Đây là dòng mới
        String filePath = FOLDER_PATH + newFileName; // Sửa dòng này để sử dụng tên tệp mới

        try {
            Files.write(new File(filePath).toPath(), imageData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newFileName;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        String filePath = FOLDER_PATH + fileName;
        byte[] imageData = Files.readAllBytes(new File(filePath).toPath());
        return imageData;
    }
}

