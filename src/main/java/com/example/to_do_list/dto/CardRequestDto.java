package com.example.to_do_list.dto;


import com.example.to_do_list.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardRequestDto {
    private String title;
    private String content;
//    private boolean complete;
//    private User user;

}