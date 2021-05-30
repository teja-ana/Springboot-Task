package com.spring.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.movies.model.*;


@Repository
public interface MoviesInterface extends JpaRepository<Movies, Integer> {
	
	
	//custom query
	@Query(value = "select * from movies", nativeQuery = true ) 
	 public List<Movies> disp();
}
