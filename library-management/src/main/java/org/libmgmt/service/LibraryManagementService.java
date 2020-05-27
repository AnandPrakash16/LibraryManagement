package org.libmgmt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.libmgmt.constants.LibraryManagementConstants;
import org.libmgmt.dao.BooksDao;
import org.libmgmt.dao.LibraryDao;
import org.libmgmt.entity.Book;
import org.libmgmt.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryManagementService {

	@Autowired
	BooksDao bookDao;

	@Autowired
	LibraryDao libraryDao;

	/**
	 * Method to load initial data
	 */
	@PostConstruct
	public void loadInitialData() {
		Book b = new Book(100, "Single Book", "ABC Publication", "NO", LibraryManagementConstants.CATEGORY_TYPE_HISTORY);
		Book bb = new Book(110, "Book 2", "Xyz Publication", "NO", LibraryManagementConstants.CATEGORY_TYPE_FOOD);
		
		Book b1 = new  Book(101, "BookName1", "Publisher1", "YES", LibraryManagementConstants.CATEGORY_TYPE_TRAVEL);
		Book b2 = new  Book(202, "BookName2", "Publisher2", "NO", LibraryManagementConstants.CATEGORY_TYPE_HISTORY);
		Book b3 = new  Book(303, "BookName3", "Publisher3", "YES", LibraryManagementConstants.CATEGORY_TYPE_FOOD);
		Book b4 = new  Book(404, "BookName4", "Publisher4", "YES", LibraryManagementConstants.CATEGORY_TYPE_SCIENCE);
		Book b5 = new  Book(505, "BookName5", "Publisher5", "YES", LibraryManagementConstants.CATEGORY_TYPE_TRAVEL);
		
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		
		Library lib = new Library("Library1","Stephen",books);
		libraryDao.save(lib);
		
		books.clear();
		
		books.add(b);
		books.add(bb);
		Library lib1 = new Library("Library2","Jack",books);
		libraryDao.save(lib1);
	}

	/**
	 * Method to get all books 
	 * @return
	 */
	public List<Book> getAllBook(){
		return bookDao.findAll();
	}
	
	/**
	 * MEthod to add a book into database
	 * @param book
	 */
	public void addBook(Book book) {
		bookDao.save(book);
	}
	
	/**
	 * Method to find a book
	 * @param id
	 * @return
	 */
	public Optional<Book> findBookById(int id) {
		return bookDao.findById(id);
	}

	/**
	 * Method to get All the libraries
	 * @return
	 */
	public List<Library> getLibraries(){
		return libraryDao.findAll();
	}
	
	/**
	 * Method to get books by library
	 * @param id
	 * @return
	 */
	public List<Book> getBooksByLibrary(int id){
		 Optional<Library> lib = libraryDao.findById(id);
		 List<Book> books = lib.get().getBooks();
		 return books;
	}
}
