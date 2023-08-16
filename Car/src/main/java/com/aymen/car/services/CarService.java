package com.aymen.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aymen.car.models.Car;
import com.aymen.car.repositories.CarRepository;
@Service
public class CarService {

	// === CRUD ===

			@Autowired
			private CarRepository CarRepo;

			// READ ALL
			public List<Car> allCars(){
				return CarRepo.findAll();
			}

			// CREATE
			public Car createCar(Car c) {
				return CarRepo.save(c);
			}

			// READ ONE
			public Car findCar(Long id) {

				Optional<Car> maybeCar = CarRepo.findById(id);
				if(maybeCar.isPresent()) {
					return maybeCar.get();
				}else {
					return null;
				}
			}

			// UPDATE 
			public Car updateCar(Car c) {
				return CarRepo.save(c);
			}

			// DELETE
			public void deleteCar(Long id) {
				CarRepo.deleteById(id);
			}


	}