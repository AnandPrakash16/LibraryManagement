package org.libmgmt.dao;

import javax.transaction.Transactional;

import org.libmgmt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BooksDao extends JpaRepository<Book, Integer>{


}
