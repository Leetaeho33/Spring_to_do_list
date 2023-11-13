package com.example.to_do_list.dto;

import com.example.to_do_list.entity.Card;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private Long id;
    private String content;
    private Card card;
    private LocalDateTime dateTime;
}
