package com.example.to_do_list.controller;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/card")
@RestController
public class CardController {
    CardService cardService;
    @PostMapping("/create")
    public void createCard(CardRequestDto cardRequestDto){
        cardService.createCard(cardRequestDto);
    }

    @PutMapping("/update")
    public void updateCard(CardRequestDto cardRequestDto){
//        cardService.updateCard(cardRequestDto);
    }

    @GetMapping("/get/all")
    public void getAllCard(){
//        cardService.getAllCard();
    }

    @GetMapping("/get/card")
    public void getCard(@PathVariable long id){
//        cardService.getCard(id);
    }

    @DeleteMapping("/delete")
    public void deleteCard(@PathVariable long id){
//        cardService.delete(id);
    }
}
