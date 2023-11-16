package com.example.to_do_list.service;

import com.example.to_do_list.dto.UserRequestDto;
import com.example.to_do_list.dto.UserResponseDto;
import com.example.to_do_list.entity.User;
import com.example.to_do_list.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private User user, loginUser;

    public UserResponseDto signUp(UserRequestDto userRequestDto){
        user = new User(userRequestDto);
        userRepository.save(user);
        return new UserResponseDto(user);
    }

    public UserResponseDto logIn(UserRequestDto userRequestDto) {
        user = new User(userRequestDto);
        Optional<User> findedUser = userRepository.findByUsername(user.getUsername());
        if(findedUser.isPresent()){
            loginUser = new User(findedUser.get());
        }else {
            loginUser = new User();
        }
        if(user.getUsername().equals(findedUser)){
            if(user.getPwd().equals(loginUser.getPwd())){
                return new UserResponseDto(loginUser);
            }
        }
        return new UserResponseDto(loginUser);
    }

}
