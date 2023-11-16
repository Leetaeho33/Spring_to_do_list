package com.example.to_do_list.entity;

import com.example.to_do_list.dto.CardRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
public class Card extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

//    @Column(name = "complete")
//    private boolean complete = false;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Card (CardRequestDto cardRequestDto, User user){
        this.title = cardRequestDto.getTitle();
        this.content = cardRequestDto.getContent();
        this.user = user;
    }

    public void updateCard(CardRequestDto card){
        this.title = card.getTitle();
        this.content = card.getContent();
//        this.complete = card.isComplete();
    }

    public void addCommentList(Comment comment){
        commentList.add(comment);
//        comment.setCard(this);
    }

    public void deleteCommentList(Comment comment){
        commentList.remove(comment);
    }

}
