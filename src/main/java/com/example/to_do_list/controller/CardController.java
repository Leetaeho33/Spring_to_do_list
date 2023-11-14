package com.example.to_do_list.controller;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/card")
@RestController
public class CardController {
    private final CardService cardService;
    @PostMapping("/create")
    public CardResponseDto createCard(@RequestBody CardRequestDto cardRequestDto){
        return cardService.createCard(cardRequestDto);
    }

    @PutMapping("/updates/{id}")
    public CardResponseDto updateCard(@RequestBody CardRequestDto cardRequestDto,@PathVariable Long id){
        return cardService.updateCard(cardRequestDto, id);
    }

    @GetMapping("/gets")
    public List<CardResponseDto> getAllCard(){
       return cardService.getAllCard();
    }

    @GetMapping("/gets/{id}")
    public CardResponseDto getCard(@PathVariable long id){
        return cardService.getCard(id);
    }

    @DeleteMapping("/deletes/{id}")
    public void deleteCard(@PathVariable long id){
        cardService.deleteCard(id);
    }
}
