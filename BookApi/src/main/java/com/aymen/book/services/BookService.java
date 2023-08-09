package com.aymen.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aymen.book.models.Book;
import com.aymen.book.repositories.BookRepository;

@Service
public class BookService {
	
	 private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    public Book updateBook(Long id, String title, String description, String language, Integer pages) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        
	        if (optionalBook.isPresent()) {
	            Book book = optionalBook.get();
	            book.setTitle(title);
	            book.setDescription(description);
	            book.setLanguage(language);
	            book.setNumberOfPages(pages);
	            return bookRepository.save(book);
	        } else {
	            return null; // Handle the case where the book with the given ID is not found
	        }
	    }
	    public void deleteBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);

	        if (optionalBook.isPresent()) {
	            Book book = optionalBook.get();
	            bookRepository.delete(book);
	        } else {
	            // Handle the case where the book with the given ID is not found
	            // You can throw an exception, return a custom error response, or perform any appropriate action.
	        }
	    }

}
