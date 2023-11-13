package com.example.to_do_list.repository;

import com.example.to_do_list.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepository extends JpaRepository<Comment, Long> {
}
