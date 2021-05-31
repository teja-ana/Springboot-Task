package com.spring.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.movies.model.Movies;
import com.spring.movies.model.Singer;
import com.spring.movies.repo.DirectorInterface;
import com.spring.movies.repo.MoviesInterface;
import com.spring.movies.repo.SingerInterface;


@Component
public class MoviesServices {
	
	@Autowired
	private MoviesInterface moviesInterface;
	
	@Autowired
	private DirectorInterface directorInterface;
	
	
	@Autowired
	private SingerInterface singerInterface;
	

		//GET METHOD -- get all movies 
		public List<Movies> getAllMovies(){
			return moviesInterface.findAll();
		}
		
		
		//GET METHOD BY ID--get movie by id
		public Movies getMoviesById(@PathVariable(value = "mid") int mid) {
			Movies movies = moviesInterface.findById(mid).orElse(new Movies());
			return movies;
		}
		
		
		//POST METHOD--create movie
		public List<Movies>  createMovies(@RequestBody List<Movies> movies) {
			return moviesInterface.saveAll(movies);
			
		}
		
			
		//PuT METHOD-- update movies
		public Movies updateMovies(
				 @RequestBody Movies moviesDetails) {
			Movies movies = moviesInterface.save(moviesDetails);
			return movies;
		}
		
		
		//DELETE METHOD -- delete movies by id
		public String deleteById(@PathVariable(value = "mid") int mid) {
			Movies movies =moviesInterface.findById(mid).orElse(null);
			moviesInterface.delete(movies);
			return "deleted sucess";
			
		}

		// director
		//GET METHOD -- get all director
		public List<Movies> getAlldirectors() {
			
			return moviesInterface.findAll();
		}
		
		
		//singer
		//POST METHOD--create movie
		public Singer createSinger(@RequestBody Singer singer) {
			System.out.println(singer.toString());
			return singerInterface.save(singer);
			
		}
		
		
		public List<Singer> getAllSinger(){	
			return singerInterface.findAll();
		}
		
		
		
}
