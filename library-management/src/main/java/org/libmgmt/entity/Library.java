package org.libmgmt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.libmgmt.entity.Book;

@Entity
@Table(name = "Library")
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String libraryName;
	private String libraryOwner;

	@OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_fk", referencedColumnName = "id")
	private List<Book> books = new ArrayList<Book>();

	public Library() {

	}

	public Library(String libraryName, String libraryOwner, List<Book> books) {
		this.libraryName = libraryName;
		this.libraryOwner = libraryOwner;
		this.books = books;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the libraryName
	 */
	public String getLibraryName() {
		return libraryName;
	}

	/**
	 * @param libraryName the libraryName to set
	 */
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	/**
	 * @return the libraryOwner
	 */
	public String getLibraryOwner() {
		return libraryOwner;
	}

	/**
	 * @param libraryOwner the libraryOwner to set
	 */
	public void setLibraryOwner(String libraryOwner) {
		this.libraryOwner = libraryOwner;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
