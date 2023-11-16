package com.example.to_do_list.service;

import com.example.to_do_list.dto.CardRequestDto;
import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.dto.CommentRequestDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.entity.Comment;
import com.example.to_do_list.repository.CardRepository;
import com.example.to_do_list.repository.CommentRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CardRepository cardRepository;
    private Card card;
    Comment comment;

    public CardResponseDto createComment(CommentRequestDto commentRequestDto, Long id){
        card = findByIdCard(id);
        comment = new Comment(commentRequestDto, card);
        card.addComments(comment);
        commentRepository.save(comment);

        // Card 객체를 응답 시키는 이유는 댓글은 카드에 종속되어 있기 때문. 댓글만 보여주는건 맞지 않음
        return new CardResponseDto(card);
    }

    @Transactional
    public CardResponseDto updateComment(CommentRequestDto commentRequestDto,
                                         Long commentId, Long cardId) {
        card = findByIdCard(cardId);
        Comment commentUpdate = new Comment(commentRequestDto, card);
        comment = findByIdComment(commentId);
        comment.updateComment(commentUpdate);
        return new CardResponseDto(card);
    }
    @Transactional
    public CardResponseDto daleteComment(Long commentId, Long cardId) {
        card = findByIdCard(cardId);
        comment = findByIdComment(commentId);
        commentRepository.delete(comment);
        card.deleteComments(comment);
        return new CardResponseDto(card);
    }

    private Card findByIdCard(Long id) {
        Optional<Card> cardOptional = cardRepository.findById(id);

        if (cardOptional.isPresent()) {
           return cardOptional.get();
        }
        else {
            new NullPointerException("검색된 카드가 없습니다.");
            return new Card();
        }
    }

    private Comment findByIdComment(Long id){
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if(commentOptional.isPresent()){
            return commentOptional.get();
        }else{
            new NullPointerException("검색된 댓글이 없습니다.");
            return new Comment();
        }
    }
}
