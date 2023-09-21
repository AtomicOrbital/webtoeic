package com.example.webtoeic.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bai_grammar")
@Builder
@Data
public class BaiGrammar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "baigrammarid", nullable = false)
    private Integer baiGrammarId;

    @Column(name = "tenbaigrammar")
    private String tenBaiGrammar;

    @Column(name = "anhbaigrammar")
    private String anhBaiGrammar;

    @Column(columnDefinition = "TEXT", name="content_HTML")
    private String contentHTML;

    @Column(columnDefinition = "TEXT", name="content_MarkDown")
    private String contentMarkDown;

    public BaiGrammar(){

    }

    public BaiGrammar(Integer baiGrammarId, String tenBaiGrammar, String anhBaiGrammar, String contentHTML, String contentMarkDown) {
        this.baiGrammarId = baiGrammarId;
        this.tenBaiGrammar = tenBaiGrammar;
        this.anhBaiGrammar = anhBaiGrammar;
        this.contentHTML = contentHTML;
        this.contentMarkDown = contentMarkDown;
    }

    public Integer getBaiGrammarId() {
        return baiGrammarId;
    }

    public void setBaiGrammarId(Integer baiGrammarId) {
        this.baiGrammarId = baiGrammarId;
    }

    public String getTenBaiGrammar() {
        return tenBaiGrammar;
    }

    public void setTenBaiGrammar(String tenBaiGrammar) {
        this.tenBaiGrammar = tenBaiGrammar;
    }

    public String getAnhBaiGrammar() {
        return anhBaiGrammar;
    }

    public void setAnhBaiGrammar(String anhBaiGrammar) {
        this.anhBaiGrammar = anhBaiGrammar;
    }

    public String getContentHTML() {
        return contentHTML;
    }

    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }

    public String getContentMarkDown() {
        return contentMarkDown;
    }

    public void setContentMarkDown(String contentMarkDown) {
        this.contentMarkDown = contentMarkDown;
    }
}
