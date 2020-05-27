package org.libmgmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.libmgmt.constants.LibraryManagementConstants;
import org.libmgmt.entity.Book;
import org.libmgmt.entity.Library;
import org.libmgmt.service.LibraryManagementService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=LibraryManagementApplication.class)
class LibraryManagementApplicationTests {

	
	LibraryManagementService service = new LibraryManagementService();

	
	@Test
	void contextLoads() {
	}

	@Test
	public void getAllBookTest() {
		List<Book> list = new ArrayList<>();
		Book b = new Book(100, "Single Book", "ABC Publication", "NO", LibraryManagementConstants.CATEGORY_TYPE_HISTORY);
		Book bb = new Book(110, "Book 2", "Xyz Publication", "NO", LibraryManagementConstants.CATEGORY_TYPE_FOOD);
		Book b1 = new  Book(101, "BookName1", "Publisher1", "YES", LibraryManagementConstants.CATEGORY_TYPE_TRAVEL);
		Book b2 = new  Book(202, "BookName2", "Publisher2", "NO", LibraryManagementConstants.CATEGORY_TYPE_HISTORY);
		Book b3 = new  Book(303, "BookName3", "Publisher3", "YES", LibraryManagementConstants.CATEGORY_TYPE_FOOD);
		Book b4 = new  Book(404, "BookName4", "Publisher4", "YES", LibraryManagementConstants.CATEGORY_TYPE_SCIENCE);
		Book b5 = new  Book(505, "BookName5", "Publisher5", "YES", LibraryManagementConstants.CATEGORY_TYPE_TRAVEL);
		list.add(b);
		list.add(bb);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		when(service.getAllBook()).thenReturn(list);
		List<Book> list1 = service.getAllBook();
		assertEquals(list.get(0).getBookName(), list1.get(0).getBookName());
	}
	
	@Test
	public void getLibrariesTest() {
		
		List<Book> books = new ArrayList<Book>();
		Library lib = new Library("Library1","Stephen",books);
		Library lib1 = new Library("Library2","Jack",books);
		List<Library> libList = new ArrayList<Library>();
		libList.add(lib);
		libList.add(lib1);
		when(service.getLibraries()).thenReturn(libList);
		List<Library> libList2 = service.getLibraries();
		assertEquals(libList.size(), libList2.size());
		
	}
}
