package com.aymen.club.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aymen.club.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	// Read All
			List<Book> findAll();

}
