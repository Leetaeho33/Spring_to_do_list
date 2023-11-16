package com.example.to_do_list.dto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.entity.Comment;
import com.example.to_do_list.entity.User;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import lombok.Getter;
import org.apache.tomcat.util.json.JSONFilter;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.cglib.core.Local;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        this.comments = card.getComments();
        }

    }

