package com.spring.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.movies.model.*;


@Repository
public interface MoviesRepo extends JpaRepository<Movies, Integer>, MoviesRepoCustom {
	
	
	
	//@Query(value = "select * from movies", nativeQuery = true ) 
	//public List<Movies> disp();
	
	//custom query
	@Query("select mid,genre,title from Movies where mid between ?1 and ?2")
	public List<Object[]> getMovieById(@Param("mid1") int mid1,@Param("mid2") int mid2);
	
	
	public Movies findByTitle(String title);
	
}
