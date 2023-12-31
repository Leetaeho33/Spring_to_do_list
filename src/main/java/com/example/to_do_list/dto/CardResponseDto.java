package com.example.to_do_list.dto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardResponseDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private List<Comment> comments;
//    private String username;

    public CardResponseDto(Card card) {
        this.id = card.getId();
        this.title = card.getTitle();
        this.content = card.getContent();
        this.createdAt = card.getCreatedAt();
        this.modifiedAt = card.getModifiedAt();
        this.comments = card.getCommentList();
        }

    }

