package com.example.to_do_list.repository;

import com.example.to_do_list.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRepository extends JpaRepository<Card, Long> {

}
