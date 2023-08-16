package com.aymen.car.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aymen.car.models.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
	
	// Read All
				List<Car> findAll();


}
