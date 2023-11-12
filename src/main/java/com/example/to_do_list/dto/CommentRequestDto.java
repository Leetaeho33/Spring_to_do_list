package com.example.to_do_list.dto;

import com.example.to_do_list.entity.Card;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String content;
    private Card card;
}
