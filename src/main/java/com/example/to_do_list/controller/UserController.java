package com.example.to_do_list.controller;

import com.example.to_do_list.dto.UserRequestDto;
import com.example.to_do_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public void signUp(@RequestBody UserRequestDto userRequestDto){
        userService.signUp(userRequestDto);
    }

    // 로그인을 POST 메서드로 사용하는 이유는 유저 정보를 바디에 숨겨서 통신해야해서
    @PostMapping("/login")
    public void logIn(UserRequestDto userRequestDto){
//        userService.logIn(userRequestDto);
    }



}
