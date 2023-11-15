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

    @PostMapping("/post")
    public CardResponseDto createComment(CommentRequestDto commentRequestDto,
                                         @PathVariable Long id){
        return commentService.createComment(commentRequestDto, id);
    }

    @PutMapping("/update")
    public CardResponseDto updateComment(CommentRequestDto commentRequestDto,
                                         @PathVariable Long commentId,
                                         @PathVariable Long cardId){
        return commentService.updateComment(commentRequestDto, commentId, cardId);
    }
    @DeleteMapping("/delete")
    public CardResponseDto deleteComment(@PathVariable Long commentId,
                              @PathVariable Long cardId){
        return commentService.daleteComment(commentId, cardId);
    }
}
