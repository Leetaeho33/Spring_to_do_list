package com.example.to_do_list.entity;

import com.example.to_do_list.dto.UserRequestDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
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
        this.username = userRequestDto.getUsername();
        this.pwd = userRequestDto.getPwd();
    }
}
