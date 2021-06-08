package com.spring.movies.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.movies.controller.MoviesController;
import com.spring.movies.model.Movies;
import com.spring.movies.repo.MoviesRepo;
import com.spring.movies.services.MoviesServices;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMoviesController {
	
/*	
	MoviesController moviesController = new MoviesController();
	
	@Test
	public void verify()
	{
		assertEquals(3, moviesController.add(1, 2));
	}
*/	
	
	
	@Autowired MoviesServices moviesServices;
	
	@MockBean MoviesRepo moviesRepo;
	
	List<Movies> list = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		
		
		  list.add(new Movies(2,"title1","drama",4.5f,"120m")); 
		  //list.add(new Movies(2,"title2","comedy",5f,"120m"));
		 
		//public Movies(int mid, String title, String genre, float rating, String duration)

	}
	
	@Test
	public void moviesTest() {

		//list.add(new Movies(1,"title1","drama",4.5f,"120m"));
		//list.add(new Movies(2,"title2","comedy",5f,"120m"));
		
		when(moviesRepo.findAll()).thenReturn(list);
		assertEquals(list, moviesServices.getAllMovies());				
	}
}
