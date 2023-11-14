package com.example.to_do_list.service;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Transactional
    public CardResponseDto updateCard(CardRequestDto cardRequestDto,Long id){
        Optional<Card> updatedCard = cardRepository.findById(id);
        if(updatedCard.isPresent()){
            Card card = updatedCard.get();
            card.update(cardRequestDto);
            return new CardResponseDto(card);
        }else {
            throw new IllegalArgumentException("검색된 카드가 존재하지 않습니다.");
        }
    }

//    public List<CardResponseDto> getAllCard() {
//        List<Card> card = cardRepository.findAll();
//        for(Card c: card){
//            List<CardResponseDto> cardResponseDtos =
//        }
//        return null;
//    }

    public CardResponseDto getCard(Long id){
        Optional<Card> optionalCard = cardRepository.findById(id);
        Card card = new Card();
        return new CardResponseDto(optionalCard.orElseThrow(() ->
                    new IllegalArgumentException("검색한 카드는 존재하지 않습니다.")
        ));

    }

    public void getAllCard() {
    }
}
