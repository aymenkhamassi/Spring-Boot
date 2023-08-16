package com.aymen.car.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aymen.car.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	// FIND USER BY EMAIL
    Optional<User> findByEmail(String email);


}
