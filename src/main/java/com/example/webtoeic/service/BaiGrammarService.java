package com.example.webtoeic.service;

import com.example.webtoeic.entity.BaiGrammar;
import com.example.webtoeic.payload.response.BaseResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaiGrammarService {
    BaseResponse update(int id, BaiGrammar updatedBaiGrammar);

    BaseResponse save(BaiGrammar baiGrammar);

    BaseResponse getBaiGrammar(int id);

    BaseResponse getBaiGrammar(int page, int limit);

    BaseResponse getAllBaiGrammar();

    BaseResponse delete(int id);

    BaseResponse searchListBaiGrammar(String search);
}
