package com.example.to_do_list.service;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardResponseDto createCard(CardRequestDto cardRequestDto) {

        Card reqCard = new Card(cardRequestDto);
        Card resCard = cardRepository.save(reqCard);

        return new CardResponseDto(resCard);
    }

    public CardResponseDto updatedCard(CardRequestDto cardRequestDto,Long id){

        Card card = new Card(cardRequestDto);
        Optional<Card> updatedCard = cardRepository.findById(id);
        if(updatedCard.isPresent()){
            return new CardResponseDto(updatedCard.get());
        }else {
            throw new IllegalArgumentException("검색된 회원이 존재하지 않습니다.");
        }
    }
}
