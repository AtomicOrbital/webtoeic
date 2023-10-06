package com.example.webtoeic.repository;

import com.example.webtoeic.entity.CommentGrammar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentGrammarRepository extends JpaRepository<CommentGrammar, Integer> {

    List<CommentGrammar> findByBaiGrammar_BaiGrammarId(int baigrammarid);

}
