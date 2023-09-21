package com.example.webtoeic.controller.admin;

import com.example.webtoeic.entity.BaiGrammar;
import com.example.webtoeic.service.BaiGrammarService;
import com.example.webtoeic.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/admin/grammar")
@CrossOrigin("*")
public class BaiGrammarControllerAdmin {
    @Autowired
    private BaiGrammarService baiGrammarService;

    @Autowired
    private StorageService storageService;


    @PostMapping("/create")
    public ResponseEntity<BaiGrammar> createBaiGrammar(
            @RequestParam("file") MultipartFile file,
            @RequestParam("tenBaiGrammar") String tenBaiGrammar,
            @RequestParam("contentHTML") String contentHTML,
            @RequestParam("contentMarkDown") String contentMarkDown
    ) {
        // Lưu file vào một thư mục cụ thể
        String fileName = storageService.uploadImageToFileSystem(file);

        // Tạo một đối tượng BaiGrammar mới và set các thuộc tính cho nó
        BaiGrammar baiGrammar = new BaiGrammar();
        baiGrammar.setAnhBaiGrammar(fileName); // Set tên đã lưu
        baiGrammar.setTenBaiGrammar(tenBaiGrammar);
        baiGrammar.setContentHTML(contentHTML);
        baiGrammar.setContentMarkDown(contentMarkDown);

        // Lưu BaiGrammar vào cơ sở dư liệu
        BaiGrammar created = baiGrammarService.save(baiGrammar);

        if(created != null){
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaiGrammar> updateBaiGrammar(
            @PathVariable int id,
            @RequestParam("file") MultipartFile file,
            @RequestParam("tenBaiGrammar") String tenBaiGrammar,
            @RequestParam("contentHTML") String contentHTML,
            @RequestParam("contentMarkDown") String contentMarkDown
    ) {
        Optional<BaiGrammar> existingBaiGrammar = baiGrammarService.getBaiGrammar(id);
        if(existingBaiGrammar == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Lưu file vào một thư mục cụ thể
        String fileName = storageService.uploadImageToFileSystem(file);

        // Tạo một đối tượng BaiGrammar mới và set các thuộc tính cho nó
        BaiGrammar baiGrammar = new BaiGrammar();
        baiGrammar.setAnhBaiGrammar(fileName);
        baiGrammar.setTenBaiGrammar(tenBaiGrammar);
        baiGrammar.setContentHTML(contentHTML);
        baiGrammar.setContentMarkDown(contentMarkDown);

        // Lưu BaiGrammar vào cơ sở dư liệu
        BaiGrammar updated = baiGrammarService.update(id,baiGrammar);

        if(updated != null){
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBaiGrammar(@PathVariable int id) {
        return new ResponseEntity<>(baiGrammarService.delete(id), HttpStatus.NO_CONTENT);
    }
}
