package com.aymen.crud.travel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aymen.crud.travel.models.Travel;

@Repository
public interface TravelRepo extends CrudRepository<Travel, Long> {
	List<Travel>findAll();

}
