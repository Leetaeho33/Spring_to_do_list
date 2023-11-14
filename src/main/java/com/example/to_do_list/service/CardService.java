package com.example.to_do_list.service;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    // @Transactional은 사기다.
    @Transactional
    public CardResponseDto updateCard(CardRequestDto cardRequestDto,Long id){
            Card card = searchCard(id);
            card.update(cardRequestDto);
            return new CardResponseDto(card);
    }

    public CardResponseDto getCard(Long id){
        Card card = searchCard(id);
        return new CardResponseDto(card);
    }

    public List<CardResponseDto> getAllCard() {
        List<CardResponseDto> cardResponseDtoList = new ArrayList<>();
        List<Card> cardList = cardRepository.findAll();
        for(Card card: cardList){
            CardResponseDto cardResponseDto = new CardResponseDto(card);
            cardResponseDtoList.add(cardResponseDto);
        }
        return cardResponseDtoList;
    }

    public void deleteCard(long id) {
        Card card = searchCard(id);
        cardRepository.delete(card);
    }

    // 반복되는 메서드는 빼서 사용.
    private Card searchCard (Long id){
        Optional<Card> getCard = cardRepository.findById(id);
        if(getCard.isPresent()){
            Card card = getCard.get();
            return card;
        }else {
            throw new IllegalArgumentException("검색된 카드가 존재하지 않습니다.");
        }
    }

}
