package com.example.to_do_list.repository;

import com.example.to_do_list.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CardRepository extends JpaRepository<Card, Long> {
    @Override
    Optional<Card> findById(Long aLong);
}
