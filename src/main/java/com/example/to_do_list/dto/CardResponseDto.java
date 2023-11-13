package com.example.to_do_list.dto;

import com.example.to_do_list.entity.Card;
import com.example.to_do_list.entity.User;

import java.time.LocalDateTime;

public class CardResponseDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime dateTime;
    private String username;

    public CardResponseDto(Card card) {
        this.id = card.getId();
        this.title = card.getTitle();
        this.content = card.getContent();
        this.username = card.getUser().getUsername();
        this.dateTime = card.getDateTime();
    }
}
