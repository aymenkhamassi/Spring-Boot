package com.aymen.club.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aymen.club.models.Book;
import com.aymen.club.services.BookService;
import com.aymen.club.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService UserServ;
	
	
	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("user_id")== null) return "redirect:/";
		model.addAttribute("user", UserServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("bookNames",bookServ.allBooks());
		return "home.jsp";
	}
	
	
	//get and post new
			@GetMapping("/books/new")
			public String newBook(@ModelAttribute("bookName") Book bookName, Model model, HttpSession session) {
				if(session.getAttribute("user_id")== null) return "redirect:/";
				model.addAttribute("user", UserServ.getUser((Long) session.getAttribute("user_id")));
				return "create.jsp";
			}
			
			@PostMapping("/books/new")
			public String addNewbook(@Valid @ModelAttribute("bookName") Book bookName, BindingResult result, Model model, HttpSession session) {
				if(session.getAttribute("user_id")== null) return "redirect:/";
				if(result.hasErrors()) {
					model.addAttribute("user", UserServ.getUser((Long) session.getAttribute("user_id")));
					return "create.jsp";
				}else {
					bookServ.createBook(bookName);
					return "redirect:/books";
				}
			}

		


}
