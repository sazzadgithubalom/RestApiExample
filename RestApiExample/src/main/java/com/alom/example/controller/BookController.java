package com.alom.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alom.example.model.Book;
import com.alom.example.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Book added successfully!";
	}

	@GetMapping("/findAllBooks")
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/findBook/{Id}")
	public Book findBook(@PathVariable Integer Id) {
		Book book = new Book();
		Optional<Book> o = bookRepository.findById(Id);
		if (!o.isEmpty()) {
			book = o.get();
		}
		return book;
	}
	@DeleteMapping("/deleteBook")
	public String deleteBook(@RequestParam Integer id) {
		String msg = "Not found any book";
		Book book = findBook(id);
		if(book.getId() !=null) {
			bookRepository.delete(book);
			msg = "Book Deleted";
		}
		return msg;
	}

}
