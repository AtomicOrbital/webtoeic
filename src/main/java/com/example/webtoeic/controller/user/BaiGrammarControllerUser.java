package com.example.webtoeic.controller.user;

import com.example.webtoeic.entity.BaiGrammar;
import com.example.webtoeic.service.BaiGrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grammar")
public class BaiGrammarControllerUser {
    @Autowired
    private BaiGrammarService baiGrammarService;

    //Lấy danh sách tất cả cái bài grammar
    @GetMapping("/all")
    public ResponseEntity<List<BaiGrammar>> getAllBaiGrammar(){
        return new ResponseEntity<>(baiGrammarService.getAllBaiGrammar(), HttpStatus.OK);
    }

    // Lấy danh sách các bài grammar với phân trang
    @GetMapping
    public ResponseEntity<Page<BaiGrammar>> getBaiGrammarPaginated(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(baiGrammarService.getBaiGrammar(page, size), HttpStatus.OK);
    }

    // Tìm kiếm bài grammar theo từ khóa
    @GetMapping("/search")
    public ResponseEntity<List<BaiGrammar>> searchBaiGrammar(@RequestParam String search){
        return new ResponseEntity<>(baiGrammarService.searchListBaiGrammar(search),HttpStatus.OK);
    }

    // Lấy chi tiết môt bài grammar dựa trên ID
    @GetMapping("/{id}")
    public ResponseEntity<BaiGrammar> getBaiGrammarId(@PathVariable int id){
        Optional<BaiGrammar> baiGrammar = baiGrammarService.getBaiGrammar(id);
        if(baiGrammar.isPresent()) {
          return new ResponseEntity<>(baiGrammar.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
