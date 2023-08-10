package com.aymen.crud.controllers;

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

import com.aymen.crud.models.Book;
import com.aymen.crud.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;

	// DISPLAY ROUTE - READ ALL
	@GetMapping("/books")
	public String home(Model m) {
		List<Book> allTheBooks = bookServ.allBooks();
		m.addAttribute("booksList", allTheBooks);
		return "home.jsp";
	}

	// DISPLAY ROUTE - FORM
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book,
						Model m) {
		List<Book> allTheBooks = bookServ.allBooks();
		m.addAttribute("booksList", allTheBooks);
		return "create.jsp";
	}

	// ACTION ROUTE - Process Form
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
							Model m) {

		if (result.hasErrors()) {
			List<Book> allTheBooks = bookServ.allBooks();
			m.addAttribute("booksList", allTheBooks);
			return "create.jsp";
		} else {
			// save the book
		Book newBook = bookServ.createBook(book);

		return "redirect:/books";
		}

	}

	// Display Route - Edit form

	@GetMapping("books/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model) {

		// find that book with provided id
		Book thisBook = bookServ.findBook(id);

		// pass thisBook to the jsp page 
		model.addAttribute("book",thisBook);

		return "edit.jsp";
	}

	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			// if there are no errors update book
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}

	// DELETE

	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}


}