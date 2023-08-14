package com.aymen.book.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aymen.book.models.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
	
	// Read All
		List<Book> findAll();

}
