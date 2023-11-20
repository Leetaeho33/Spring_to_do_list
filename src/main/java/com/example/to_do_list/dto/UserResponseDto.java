package com.example.to_do_list.dto;

import com.example.to_do_list.entity.Card;
import com.example.to_do_list.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserResponseDto {
    String username;
    List<Card> cardList = new ArrayList<>();

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.cardList = user.getCardList();
    }
}
