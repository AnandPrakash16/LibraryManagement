package org.libmgmt.controller;

import java.util.List;
import java.util.Optional;

import org.libmgmt.entity.Book;
import org.libmgmt.entity.Library;
import org.libmgmt.service.LibraryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibrarayManagementController {

	@Autowired
	LibraryManagementService service;

	/**
	 * Service to retreive all books
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/books")
	public List<Book> getallBooks() {
		return service.getAllBook();
	}
	
	/**
	 * Service to add a book into database
	 * @param book
	 * @return
	 */
	@CrossOrigin
	@PostMapping("/book")
	public String storeBook(@RequestBody Book book) {
		String res = null;
		try {
			service.addBook(book);
			res = "SUCESS";
		} catch (Exception ex) {
			res = "FAILURE";
		}
		return res;
	}

	/**
	 * Service to find a bok by book id
	 * @param bookId
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/books/{bookId}")
	public Book findBookById(@PathVariable Integer bookId) {
		Optional<Book> book = service.findBookById(bookId);
		return book.get();
	}

	/**
	 * Service for getting all libraries
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/library")
	public List<Library> getLibrary() {
		return service.getLibraries();
	}

	/**
	 * Service for getting all the books by a library
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/library/{id}")
	public List<Book> getBooksbyLibrary(@PathVariable Integer id) {
		return service.getBooksByLibrary(id);
	}
}
