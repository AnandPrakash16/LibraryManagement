package org.libmgmt.dao;

import org.libmgmt.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDao extends JpaRepository<Library, Integer>{

}
