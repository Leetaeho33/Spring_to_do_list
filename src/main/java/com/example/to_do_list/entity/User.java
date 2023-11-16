package com.example.to_do_list.entity;

import com.example.to_do_list.dto.UserRequestDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "role")
    private UserRoleEnum roleEnum;

    // 회원별 카드 리스트 존재.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Card> cardList =new ArrayList<>();

    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.pwd = userRequestDto.getPwd();
    }

    public User(User user){
        this.username = user.getUsername();
        this.pwd = user.getPwd();
    }

    public void addCardList(Card card) {
        cardList.add(card);
    }

}
