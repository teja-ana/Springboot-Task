package com.spring.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movies.model.Movies;
import com.spring.movies.model.Singer;
import com.spring.movies.repo.DirectorInterface;
import com.spring.movies.repo.MoviesInterface;
import com.spring.movies.services.MoviesServices;


@RestController
public class MoviesController {
	
	@Autowired
	private MoviesServices moviesServices;
	
	@Autowired
	private MoviesInterface moviesInterface;
	
	@Autowired
	private DirectorInterface directorInterface;
	

		//GET METHOD --create get all movies
		@GetMapping("/movies/get")
		public List<Movies> getAllMovies(){
			return moviesServices.getAllMovies();
		}

		//GET METHOD BY ID--get movie by id
		@GetMapping("/movies/get/{mid}")
		public Movies getMoviesById(@PathVariable(value = "mid") int mid) {
			return moviesServices.getMoviesById(mid);
		}
		
		
		//POST METHOD--create movie
		@PostMapping("/movies/post")
		public Movies createMovies(@RequestBody Movies movies) {
			return moviesServices.createMovies(movies);
			
		}
		
		//PuT METHOD-- update movies
			@PutMapping("/movies/put")
		public Movies updateMovies( @RequestBody Movies moviesDetails) {
			return moviesServices.updateMovies(moviesDetails);
		}
			
			
		//DELETE METHOD -- delete movies by id
		@DeleteMapping("/movies/delete/{mid}")
		public String deleteById(@PathVariable(value = "mid") int mid) {
			return moviesServices.deleteById(mid);
		}
		
		//director
		//GET METHOD --create get all movies
				@GetMapping("/director/get")
				public List<Movies> getAlldirectors(){
					return moviesServices.getAlldirectors();
				}
		
				
				
		//singer
		//POST METHOD--create movie
		@PostMapping("/singer/post")
				public Singer createSinger(@RequestBody Singer singer) {
					return moviesServices.createSinger(singer);
					
				}
		
		
		//GET METHOD --create get all singer
				@GetMapping("/singer/get")
				public List<Singer> getAllSinger(){
					return moviesServices.getAllSinger();
				}
				
				
				


}
