package com.aymen.book.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aymen.book.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	// FIND USER BY EMAIL
    Optional<User> findByEmail(String email);

}
