package com.example.to_do_list.repository;

import com.example.to_do_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByOrderByUsername();

    Optional<User> findByUsername(String subject);
}
