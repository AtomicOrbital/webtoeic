//package com.example.webtoeic.DTO;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//
//public class ByteArrayMultipartFile implements MultipartFile {
//    private final byte[] imgContent;
//    private final String name;
//    private final String originalFileName;
//    private final String contentType;
//
//    public ByteArrayMultipartFile(byte[] imgContent, String name, String contentType, String ext) {
//        this.imgContent = imgContent;
//        this.name = name;
//        this.originalFileName = name + "." + ext;
//        this.contentType = contentType;
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String getOriginalFilename() {
//        return originalFileName;
//    }
//
//    @Override
//    public String getContentType() {
//        return contentType;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return imgContent == null || imgContent.length == 0;
//    }
//
//    @Override
//    public long getSize() {
//        return imgContent.length;
//    }
//
//    @Override
//    public byte[] getBytes() throws IOException {
//        return imgContent;
//    }
//
//    @Override
//    public InputStream getInputStream() throws IOException {
//        return new ByteArrayInputStream(imgContent);
//    }
//
//    @Override
//    public void transferTo(File dest) throws IOException, IllegalStateException {
//        new FileOutputStream(dest).write(imgContent);
//    }
//}
