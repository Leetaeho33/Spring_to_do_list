package com.example.to_do_list.controller;

import com.example.to_do_list.dto.UserRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/signup")
    public void signup(UserRequestDto userRequestDto){
//        userService.signup(userRequestDto);
    }

    // 로그인을 POST 메서드로 사용하는 이유는 유저 정보를 바디에 숨겨서 통신해야해서
    @PostMapping("/login")
    public void login(UserRequestDto userRequestDto){
//        userService.login(userRequestDto);
    }



}
