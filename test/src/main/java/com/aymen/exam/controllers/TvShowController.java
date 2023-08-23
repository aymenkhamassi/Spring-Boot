package com.aymen.exam.controllers;

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

import com.aymen.exam.models.TvShow;
import com.aymen.exam.services.TvShowService;
import com.aymen.exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TvShowController {
	
	@Autowired
	private TvShowService showServ;
	
	@Autowired
	private UserService UserServ;
	
	
	@GetMapping("/shows")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		model.addAttribute("user", UserServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("showNames",showServ.allTvShows());
		return "home.jsp";
	}
	
	//get and post new
	@GetMapping("/shows/new")
	public String newShow(@ModelAttribute("showName") TvShow showName, Model model, HttpSession session) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		model.addAttribute("user", UserServ.getUser((Long) session.getAttribute("user_id")));
		return "create.jsp";
	}
	
	@PostMapping("/shows/new")
	public String addNewshow(@Valid @ModelAttribute("showName") TvShow showName, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		if(result.hasErrors()) {
			model.addAttribute("user", UserServ.getUser((Long) session.getAttribute("user_id")));
			return "create.jsp";
		}else {
			showServ.createTvShow(showName);
			return "redirect:/shows";
		}
	}
	
	@GetMapping("/shows/{id}")
	public String showOne(@PathVariable("id") Long showID,Model model,HttpSession session) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		TvShow thisShow = showServ.findTvShow(showID);
		model.addAttribute("thisShow", thisShow);
		return "one.jsp";
	}
	
	
	@GetMapping("/shows/{showID}/edit")
	public String updateForm(@ModelAttribute("show")TvShow show,@PathVariable("showID")Long showID,Model model,HttpSession session){
		if(session.getAttribute("user_id")== null) return "redirect:/";
		TvShow showToUpdate = showServ.findTvShow(showID);
		model.addAttribute("show", showToUpdate);
		return "edit.jsp";
	}
	
	@PutMapping("/shows/{id}/edit")
	public String processShow(@Valid @ModelAttribute("show") TvShow show, BindingResult result,HttpSession session,
			@PathVariable("id") Long showID) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			TvShow oldShow = showServ.findTvShow(showID);
			show.setUser(oldShow.getUser());
			showServ.updateTvShow(show);
			return "redirect:/shows";
		}
	}
	
	@DeleteMapping("/shows/{id}/delete")
	public String destroy(@PathVariable("id") Long showID,HttpSession session) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		showServ.deleteTvShow(showID);
		return "redirect:/shows";
	}


}
