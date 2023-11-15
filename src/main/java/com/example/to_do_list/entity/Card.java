package com.example.to_do_list.entity;

import com.example.to_do_list.dto.CardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
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

    @Column(name = "complete")
    private boolean complete = false;

    @OneToMany(mappedBy = "card")
    private List<Comment> comments = new ArrayList<>();


//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;


    public Card (CardRequestDto cardRequestDto){
        this.title = cardRequestDto.getTitle();
        this.content = cardRequestDto.getContent();
//        this.user = cardRequestDto.getUser();
    }

    public void update(CardRequestDto card){
        this.title = card.getTitle();
        this.content = card.getContent();
        this.complete = card.isComplete();
    }

    public void addComments(Comment comment){
        comments.add(comment);
    }

    public void deleteComments(Comment comment){
        comments.remove(comment);
    }

}
