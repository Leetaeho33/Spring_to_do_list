package com.example.to_do_list.entity;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CommentRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // 카드 하나에 여러 댓글을 달아야 하니까 N의 관계
    @ManyToOne
    @JoinColumn(name = "card_id")
    @JsonIgnore
    private Card card;

    // 카드에 여러 유저가 댓글을 달 수 있으니까 N의 관계
    // 카드 작성자와 댓글 작성자가 일치하지 않을 수 있기 때문에 Comment는 User와 N대 1 관계를 맺어야함.
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Comment (CommentRequestDto commentRequestDto, Card card){
        this.content = commentRequestDto.getContent();
        this.card = card;
    }

    public void updateComment(Comment comment){
        this.content = comment.getContent();
        this.getCreatedAt();
        this.getModifiedAt();
    }

}
