package com.example.webtoeic.DTO;

import java.time.LocalDateTime;

public class CommentGrammarDTO {
    private String cmtGrammarContent;
    private LocalDateTime time;
    private int userId;
    private int baiGrammarId;

    public String getCmtGrammarContent() {
        return cmtGrammarContent;
    }

    public void setCmtGrammarContent(String cmtGrammarContent) {
        this.cmtGrammarContent = cmtGrammarContent;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBaiGrammarId() {
        return baiGrammarId;
    }

    public void setBaiGrammarId(int baiGrammarId) {
        this.baiGrammarId = baiGrammarId;
    }
}
