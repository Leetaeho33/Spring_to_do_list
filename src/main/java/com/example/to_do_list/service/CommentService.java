package com.example.to_do_list.service;

import com.example.to_do_list.dto.CardResponseDto;
import com.example.to_do_list.dto.CommentRequestDto;
import com.example.to_do_list.entity.Card;
import com.example.to_do_list.entity.Comment;
import com.example.to_do_list.entity.User;
import com.example.to_do_list.repository.CardRepository;
import com.example.to_do_list.repository.CommentRepository;
import com.example.to_do_list.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private Card card;
    private User user;

    Comment comment;

    public CardResponseDto createComment(CommentRequestDto commentRequestDto,
                                         Long cardId, Long userId){
        card = searchCard(cardId);
        user = searchUser(userId);
        comment = new Comment(commentRequestDto, card, user);
        card.addCommentList(comment);
        commentRepository.save(comment);

        // Card 객체를 응답 시키는 이유는 댓글은 카드에 종속되어 있기 때문. 댓글만 보여주는건 맞지 않음
        return new CardResponseDto(card);
    }

    @Transactional
    public CardResponseDto updateComment(CommentRequestDto commentRequestDto,
                                         Long commentId, Long cardId, Long userId) {
        card = searchCard(cardId);
        user = searchUser(userId);
        Comment commentUpdate = new Comment(commentRequestDto, card, user);
        comment = searchComment(commentId);
        comment.updateComment(commentUpdate);
        return new CardResponseDto(card);
    }
    @Transactional
    public CardResponseDto daleteComment(Long commentId, Long cardId, Long userId) {
        card = searchCard(cardId);
        user = searchUser(userId);
        comment = searchComment(commentId);
        commentRepository.delete(comment);
        card.deleteCommentList(comment);
        return new CardResponseDto(card);
    }

    private Card searchCard(Long id) {
        Optional<Card> cardOptional = cardRepository.findById(id);

        if (cardOptional.isPresent()) {
           return cardOptional.get();
        }
        else {
            new NullPointerException("검색된 카드가 없습니다.");
            return new Card();
        }
    }

    private Comment searchComment(Long id){
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if(commentOptional.isPresent()){
            return commentOptional.get();
        }else{
            new NullPointerException("검색된 댓글이 없습니다.");
            return new Comment();
        }
    }

    private User searchUser(Long id) {
        Optional<User> userSearched = userRepository.findById(id);
        if (userSearched.isPresent()) {
            user = userSearched.get();
            return user;
        } else {
            throw new IllegalArgumentException("검색된 유저가 존재하지 않습니다.");
        }
    }
}
