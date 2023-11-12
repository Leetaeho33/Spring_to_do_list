package com.example.to_do_list.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
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

}
