package com.aymen.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aymen.dojo.models.Dojo;
import com.aymen.dojo.models.Ninja;
import com.aymen.dojo.services.DojoService;
import com.aymen.dojo.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaServ;
	@Autowired
	private DojoService dojoServ;
	
	
	// DISPLAY ROUTE - FORM
		@GetMapping("/ninjas/new")
		public String create(@ModelAttribute("ninja") Ninja ninja,
							Model m) {
			// grab the dojo list
			List<Dojo> dojosList = dojoServ.allDojos();
			m.addAttribute("dojosList",dojosList);
			return "create.jsp";
		}

		// ACTION ROUTE - Process Form
		@PostMapping("/ninjas")
		public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,
								Model m) {

			if (result.hasErrors()) {
				List<Ninja> allTheNinjas = ninjaServ.allNinjas();
				m.addAttribute("ninjasList", allTheNinjas);
				return "create.jsp";
			} else {
				// save the ninja
			Ninja newNinja = ninjaServ.createNinja(ninja);

			return "redirect:/ninjas/new";
			}



}
}
