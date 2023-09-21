package com.example.webtoeic.service.Impl;

import com.example.webtoeic.entity.BaiGrammar;
import com.example.webtoeic.repository.BaiGrammarRepository;
import com.example.webtoeic.service.BaiGrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BaiGrammarImpl implements BaiGrammarService {
    @Autowired
    BaiGrammarRepository baiGrammarRepository;

    @Override
    public BaiGrammar save(BaiGrammar baiGrammar){
        baiGrammarRepository.save(baiGrammar);
        return baiGrammar;
    }

    @Override
    public BaiGrammar update(int id, BaiGrammar updatedBaiGrammar){
        Optional<BaiGrammar> optionalBaiGrammar = getBaiGrammar(id);
        if(optionalBaiGrammar.isPresent()){
            BaiGrammar existingBaiGrammar = optionalBaiGrammar.get();

            existingBaiGrammar.setTenBaiGrammar(updatedBaiGrammar.getTenBaiGrammar());
            existingBaiGrammar.setAnhBaiGrammar(updatedBaiGrammar.getAnhBaiGrammar());
            existingBaiGrammar.setContentHTML(updatedBaiGrammar.getContentHTML());

            return save(existingBaiGrammar);
        }
        return null;
    }

    @Override
    public Optional<BaiGrammar> getBaiGrammar(int id){
        return baiGrammarRepository.findByBaiGrammarId(id);
    }

    @Override
    public Page<BaiGrammar> getBaiGrammar(int page, int size){
        return baiGrammarRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<BaiGrammar>getAllBaiGrammar(){
        return baiGrammarRepository.findAll();
    }

    @Override
    public boolean delete(int id){
        baiGrammarRepository.deleteById(id);
        return false;
    }

    @Override
    public List<BaiGrammar> searchListBaiGrammar(String search){
        return baiGrammarRepository.searchGrammar(search);
    }

}

