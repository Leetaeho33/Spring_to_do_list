package com.example.to_do_list.controller;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.dto.UserResponseDto;
import com.example.to_do_list.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/card")
@RestController
public class CardController {
    private final CardService cardService;
    @PostMapping("/creates/{userId}")
    public CardResponseDto createCard(@RequestBody CardRequestDto cardRequestDto,
                                      @PathVariable Long userId){
        return cardService.createCard(cardRequestDto, userId);
    }

    @PutMapping("/updates/{cardId}/{userId}")
    public CardResponseDto updateCard(@RequestBody CardRequestDto cardRequestDto,
                                      @PathVariable Long cardId,
                                      @PathVariable Long userId){
        return cardService.updateCard(cardRequestDto, cardId, userId);
    }

    @GetMapping("/gets")
    public List<UserResponseDto> getAllCard(){
       return cardService.getAllCard();
    }

    @GetMapping("/gets/{userId}")
    public UserResponseDto getCard(@PathVariable Long userId){
        return cardService.getCardByUserId(userId);
    }

    @DeleteMapping("/deletes/{cardId}/{userId}")
    public void deleteCard(@PathVariable Long cardId, @PathVariable  Long userId){
        cardService.deleteCard(cardId, userId);
    }
}
