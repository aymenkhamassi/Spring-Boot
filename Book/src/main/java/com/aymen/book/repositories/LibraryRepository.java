package com.aymen.book.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aymen.book.models.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {
	
	List<Library> findAll();

}
