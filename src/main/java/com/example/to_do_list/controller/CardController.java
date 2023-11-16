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
    @PostMapping("/creates/{id}")
    public CardResponseDto createCard(@RequestBody CardRequestDto cardRequestDto, @PathVariable Long id){
        return cardService.createCard(cardRequestDto, id);
    }

    @PutMapping("/updates/{id}")
    public CardResponseDto updateCard(@RequestBody CardRequestDto cardRequestDto,@PathVariable Long id){
        return cardService.updateCard(cardRequestDto, id);
    }

    @GetMapping("/gets")
    public List<UserResponseDto> getAllCard(){
       return cardService.getAllCard();
    }

    @GetMapping("/gets/{id}")
    public UserResponseDto getCard(@PathVariable long id){
        return cardService.getCardByUserId(id);
    }

    @DeleteMapping("/deletes/{id}")
    public void deleteCard(@PathVariable long id){
        cardService.deleteCard(id);
    }
}
