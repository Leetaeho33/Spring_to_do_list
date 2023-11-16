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

    @PostMapping("/posts/{cardId}")
    public CardResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto,
                                         @PathVariable Long cardId){
        return commentService.createComment(commentRequestDto, cardId);
    }

    @PutMapping("/updates/{commentId}/{cardId}")
    public CardResponseDto updateComment(@RequestBody CommentRequestDto commentRequestDto,
                                         @PathVariable Long commentId,
                                         @PathVariable Long cardId){
        return commentService.updateComment(commentRequestDto, commentId, cardId);
    }
    @DeleteMapping("/deletes/{commentId}/{cardId}")
    public CardResponseDto deleteComment(@PathVariable Long commentId,
                              @PathVariable Long cardId){
        return commentService.daleteComment(commentId, cardId);
    }
}
