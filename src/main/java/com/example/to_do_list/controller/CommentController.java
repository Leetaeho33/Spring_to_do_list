package com.example.to_do_list.controller;

import com.example.to_do_list.dto.CommentRequestDto;
import com.example.to_do_list.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/comment")
@RestController
public class CommentController {

    @PostMapping("/post")
    public void createComment(CommentRequestDto commentRequestDto){
//        CommentService.createComment(commentRequestDto);
    }

    @PutMapping("/update")
    public void updateComment(CommentRequestDto commentRequestDto,@PathVariable long id){
//        CommentService.updateComment(commentRequestDto,id);
    }
    @DeleteMapping("/delete")
    public void deleteComment(@PathVariable long id){
//        CommentService.dalete(id);
    }
}
