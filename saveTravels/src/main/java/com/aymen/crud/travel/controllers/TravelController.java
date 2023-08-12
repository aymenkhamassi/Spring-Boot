package com.aymen.crud.travel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.aymen.crud.travel.models.Travel;
import com.aymen.crud.travel.services.TravelService;

import jakarta.validation.Valid;


@Controller
public class TravelController {
	
	@Autowired
	private TravelService travelServ;
	
	// DISPLAY ROUTE - READ ALL
		@GetMapping("/expenses")
		public String home(Model m) {
			List<Travel> allTheTravels = travelServ.allTravels();
			m.addAttribute("travelsList", allTheTravels);
			m.addAttribute("travel", new Travel());
			return "home.jsp";
		}
		@PostMapping("/expenses/create")
		public String createTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,
		                        Model m) {
		    if (result.hasErrors()) {
		        List<Travel> allTheTravels = travelServ.allTravels();
		        m.addAttribute("travelsList", allTheTravels);
		        return "home.jsp";
		    } else {
		        // Save the travel
		        Travel newTravel = travelServ.createTravel(travel);
		        return "redirect:/expenses";
		    }
		}
		
		// Display Route - Edit form

		@GetMapping("expenses/{id}/edit")
		public String editPage(@PathVariable("id") Long id, Model model) {

			
			Travel thisTravel = travelServ.findTravel(id);

			 
			model.addAttribute("travel",thisTravel);

			return "edit.jsp";
		}
		
		@PutMapping("/expenses/{id}/edit")
		public String updateBook(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				// if there are no errors update book
				travelServ.updateTravel(travel);
				return "redirect:/expenses";
			}
		}
		// DELETE

		@DeleteMapping("/expenses/{id}")
		public String delete(@PathVariable("id") Long id) {
			travelServ.deleteTravel(id);
			return "redirect:/expenses";
		}

		// DISPLAY ROUTE - Show One Expense
		@GetMapping("/travel/{id}")
		public String showTravel(@PathVariable("id") Long id, Model model) {

			Travel oneTravel = travelServ.findTravel(id);
			model.addAttribute("travel",oneTravel);

			return "show.jsp";

		}
}


