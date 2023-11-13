package com.example.to_do_list.entity;

import com.example.to_do_list.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "date", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Comment (CommentRequestDto commentRequestDto){
        this.content = commentRequestDto.getContent();
        this.card = commentRequestDto.getCard();
        this.dateTime = dateTime.now();

    }


}
