package com.example.to_do_list.controller;

import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.dto.CommentRequestDto;
import com.example.to_do_list.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/comment")
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{cardId}/{userId}")
    public CardResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto,
                                         @PathVariable Long cardId, @PathVariable Long userId){
        return commentService.createComment(commentRequestDto, cardId, userId);
    }

    @PutMapping("/updates/{commentId}/{cardId}/{userId}")
    public CardResponseDto updateComment(@RequestBody CommentRequestDto commentRequestDto,
                                         @PathVariable Long commentId,
                                         @PathVariable Long cardId, @PathVariable Long userId){
        return commentService.updateComment(commentRequestDto, commentId, cardId, userId);
    }
    @DeleteMapping("/deletes/{commentId}/{cardId}/{userId}")
    public CardResponseDto deleteComment(@PathVariable Long commentId,
                              @PathVariable Long cardId, @PathVariable Long userId){
        return commentService.daleteComment(commentId, cardId, userId);
    }
}
