package com.aymen.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aymen.exam.models.TvShow;
import com.aymen.exam.repositories.TvShowRepository;

@Service
public class TvShowService {
	
	// === CRUD ===

			@Autowired
			private TvShowRepository TvShowRepo;

			// READ ALL
			public List<TvShow> allTvShows(){
				return TvShowRepo.findAll();
			}

			// CREATE
			public TvShow createTvShow(TvShow t) {
				return TvShowRepo.save(t);
			}

			// READ ONE
			public TvShow findTvShow(Long id) {

				Optional<TvShow> maybeTvShow = TvShowRepo.findById(id);
				if(maybeTvShow.isPresent()) {
					return maybeTvShow.get();
				}else {
					return null;
				}
			}

			// UPDATE 
			public TvShow updateTvShow(TvShow t) {
				return TvShowRepo.save(t);
			}

			// DELETE
			public void deleteTvShow(Long id) {
				TvShowRepo.deleteById(id);
			}



}
