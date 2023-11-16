package com.example.to_do_list.service;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.dto.UserResponseDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.entity.User;
import com.example.to_do_list.repository.CardRepository;
import com.example.to_do_list.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private User user;
    private Card card;

    // 할일 카드 작성
    public CardResponseDto createCard(CardRequestDto cardRequestDto, Long id) {
        user = searchUser(id);
        card = new Card(cardRequestDto,user);
        user.addCardList(card);
        cardRepository.save(card);
        return new CardResponseDto(card);
    }

    // 할일 카드 수정
    @Transactional
    public CardResponseDto updateCard(CardRequestDto cardRequestDto, Long id) {
        card = searchCard(id);
        card.updateCard(cardRequestDto);
        return new CardResponseDto(card);
    }

    // 검색 유저의 할일 카드 보여주기.
    // 유저로 응답해야 유저의 할일카드를 전체 보여줄 수 있음.
    public UserResponseDto getCardByUserId(Long id) {
        user = searchUser(id);
        return new UserResponseDto(user);
    }

    // 모든 할일 카드 출력
    // 할일 카드를 유저별로 보여주기 위해 UserResponse를 List에 담아 응답.
    public List<UserResponseDto> getAllCard() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        UserResponseDto userResponseDto;
        for (int i = 0; i < userList.size(); i++) {
            userResponseDto = new UserResponseDto(userList.get(i));
            userResponseDtoList.add(userResponseDto);
        }
        return userResponseDtoList;
    }

    public void deleteCard(long id) {
        card = searchCard(id);
        cardRepository.delete(card);
    }

    // 반복되는 메서드는 빼서 사용.
    private Card searchCard(Long id) {
        Optional<Card> cardSearched = cardRepository.findById(id);
        if (cardSearched.isPresent()) {
            card = cardSearched.get();
            return card;
        } else {
            throw new IllegalArgumentException("검색된 카드가 존재하지 않습니다.");
        }
    }

    private User searchUser(Long id) {
        Optional<User> userSearched = userRepository.findById(id);
        if (userSearched.isPresent()) {
            user = userSearched.get();
            return user;
        } else {
            throw new IllegalArgumentException("검색된 유저가 존재하지 않습니다.");
        }
    }
}
