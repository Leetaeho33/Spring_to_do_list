package com.example.to_do_list.service;

import com.example.to_do_list.dto.UserRequestDto;
import com.example.to_do_list.entity.User;
import com.example.to_do_list.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public void signUp(UserRequestDto userRequestDto){
        User user = new User(userRequestDto);
        userRepository.save(user);
    }
    public void logIn(UserRequestDto userRequestDto){

    }
}
