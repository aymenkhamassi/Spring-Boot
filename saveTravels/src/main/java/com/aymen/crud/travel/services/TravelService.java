package com.aymen.crud.travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aymen.crud.travel.models.Travel;
import com.aymen.crud.travel.repositories.TravelRepo;

@Service
public class TravelService {
	// === CRUD ===

			@Autowired
			private TravelRepo travelRepo;

			// READ ALL
			public List<Travel> allTravels(){
				return travelRepo.findAll();
			}

			// CREATE
			public Travel createTravel(Travel t) {
				return travelRepo.save(t);
			}

			// READ ONE
			public Travel findTravel(Long id) {

				Optional<Travel> maybeTravel = travelRepo.findById(id);
				if(maybeTravel.isPresent()) {
					return maybeTravel.get();
				}else {
					return null;
				}
			}

			// UPDATE 
			public Travel updateTravel(Travel t) {
				return travelRepo.save(t);
			}

			// DELETE
			public void deleteTravel(Long id) {
				travelRepo.deleteById(id);
			}


}
