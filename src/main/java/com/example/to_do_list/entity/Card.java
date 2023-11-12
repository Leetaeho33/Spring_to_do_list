package com.example.to_do_list.entity;

import com.example.to_do_list.dto.CardRequestDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = true)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "date", nullable = false)
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Card (CardRequestDto cardRequestDto){
        this.title = cardRequestDto.getTitle();
        this.content = cardRequestDto.getContent();
        this.user = cardRequestDto.getUser();
        this.dateTime = dateTime.now();
    }

}
