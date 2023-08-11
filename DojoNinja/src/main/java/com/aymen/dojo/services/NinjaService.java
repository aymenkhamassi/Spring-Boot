package com.aymen.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aymen.dojo.models.Ninja;
import com.aymen.dojo.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	// === CRUD ===

		@Autowired
		private NinjaRepo NinjaRepo;

		// READ ALL
		public List<Ninja> allNinjas(){
			return NinjaRepo.findAll();
		}

		// CREATE
		public Ninja createNinja(Ninja n) {
			return NinjaRepo.save(n);
		}

		// READ ONE
		public Ninja findNinja(Long id) {

			Optional<Ninja> maybeNinja = NinjaRepo.findById(id);
			if(maybeNinja.isPresent()) {
				return maybeNinja.get();
			}else {
				return null;
			}
		}

		// UPDATE 
		public Ninja updateNinja(Ninja n) {
			return NinjaRepo.save(n);
		}

		// DELETE
		public void deleteNinja(Long id) {
			NinjaRepo.deleteById(id);
		}


}
