package com.aymen.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aymen.dojo.models.Dojo;
import com.aymen.dojo.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoServ;
	
	
	// DISPLAY ROUTE - FORM
		@GetMapping("/dojos/new")
		public String dojo(@ModelAttribute("dojo") Dojo dojo, Model model) {

			List<Dojo> allDaDojos = dojoServ.allDojos();
			model.addAttribute("dojosList",allDaDojos);
			return "dojos.jsp";
		}
		
		// ACTION ROUTE - Create Library
		@PostMapping("/dojos/new")
		public String createDojos(@Valid @ModelAttribute("dojos") Dojo dojo,
				BindingResult res,
				Model model) {
			if(res.hasErrors()) {
				List<Dojo> allDaDojos = dojoServ.allDojos();
				model.addAttribute("dojosList",allDaDojos);
				return "dojos.jsp";
			}else {
				// if there no errors
				// save
				dojoServ.createDojo(dojo);
				return "redirect:/dojos/new";
			}
		}
		
		// DISPLAY ROUTE - Show One Library
		@GetMapping("/dojos/{id}")
		public String showDojo(@PathVariable("id") Long dojoId, Model model) {

			Dojo oneDojo = dojoServ.findDojo(dojoId);
			model.addAttribute("dojo",oneDojo);

			return "showdojo.jsp";

		}


}
