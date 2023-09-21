package com.example.webtoeic.service;

import com.example.webtoeic.entity.BaiGrammar;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BaiGrammarService {
    public BaiGrammar update(int id, BaiGrammar updatedBaiGrammar);

    public BaiGrammar save(BaiGrammar baiGrammar);

    public Optional<BaiGrammar> getBaiGrammar(int id);

    public Page<BaiGrammar> getBaiGrammar(int page, int limit);

    public List<BaiGrammar> getAllBaiGrammar();

    public boolean delete(int id);

    public List<BaiGrammar> searchListBaiGrammar(String search);
}
