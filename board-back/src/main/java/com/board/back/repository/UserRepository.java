package com.board.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.back.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
