package com.aymen.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aymen.exam.models.TvShow;

public interface TvShowRepository extends CrudRepository<TvShow, Long> {
	
	// Read All
				List<TvShow> findAll();


}
