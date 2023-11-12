package com.example.to_do_list.controller;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.service.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @PostMapping("/create")
    public void createCard(CardRequestDto cardRequestDto){
//        CardService.createCard(cardRequestDto);
    }

    @PutMapping("/update")
    public void updateCard(CardRequestDto cardRequestDto){
//        CardService.updateCard(cardRequestDto);
    }

    @GetMapping("/get/all")
    public void getAllCard(){
//        CardService.getAllCard();
    }

    @GetMapping("/get/card")
    public void getCard(@PathVariable long id){
//        CardService.getCard(id);
    }

    @DeleteMapping("/delete")
    public void deleteCard(@PathVariable long id){
//        CardService.delete(id);
    }
}
