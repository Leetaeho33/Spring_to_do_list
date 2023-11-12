package com.example.to_do_list.entity;

import com.example.to_do_list.dto.UserRequestDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "pwd", nullable = false)
    private String pwd;

    public User(UserRequestDto userRequestDto) {
        this.username = username;
        this.pwd = pwd;
    }
}
