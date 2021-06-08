package com.spring.movies.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.movies.MovieAppApplication;
import com.spring.movies.exception.CustomExceptions;
import com.spring.movies.model.Movies;
import com.spring.movies.model.Singer;
import com.spring.movies.repo.DirectorRepo;
import com.spring.movies.repo.MoviesRepo;
import com.spring.movies.repo.SingerRepo;


@Component
public class MoviesServices {
	
	
	private static Logger logger=Logger.getLogger(MovieAppApplication.class);
	
	
	@Autowired
	private MoviesRepo moviesRepo;
	
	@Autowired
	private DirectorRepo directorRepo;
	
	
	@Autowired
	private SingerRepo singerRepo;
	

		//GET METHOD -- get all movies 
		public List<Movies> getAllMovies(){
			return moviesRepo.findAll();
		}
		
		
		//GET METHOD BY ID--get movie by id
		public Movies getMoviesById(@PathVariable(value = "mid") int mid) {
			Movies movies = moviesRepo.findById(mid).orElse(new Movies());
			return movies;
		}
		
		
		//POST METHOD--create movie
		public List<Movies>  createMovies(@RequestBody List<Movies> movies) {
			return moviesRepo.saveAll(movies);
			
		}
		
			
		//PuT METHOD-- update movies
		public Movies updateMovies(
				 @RequestBody Movies moviesDetails) {
			Movies movies = moviesRepo.save(moviesDetails);
			return movies;
		}
		
		
		//DELETE METHOD -- delete movies by id
		public String deleteById(@PathVariable(value = "mid") int mid) {
			Movies movies =moviesRepo.findById(mid).orElse(null);
			moviesRepo.delete(movies);
			return "deleted sucess";
			
		}

		// director
		//GET METHOD -- get all director
		public List<Movies> getAlldirectors() {
			
			return moviesRepo.findAll();
		}
		
		
		//singer
		//POST METHOD--create movie
		public Singer createSinger(@RequestBody Singer singer) {
			System.out.println(singer.toString());
			return singerRepo.save(singer);
			
		}
		
		
		public List<Singer> getAllSinger(){	
			return singerRepo.findAll();
		}
		
		@Autowired
		CustomExceptions customExceptions;
		//Exception Handling
		public Movies findByTitle(String title ){
			Movies movies;
			movies=moviesRepo.findByTitle(title);
			if(movies!=null) {	
				return movies;
			}
			else {
				
				logger.error(customExceptions.printError("Movie-Title : "+ title +" Not Found"));
				//throw new CustomExceptions("Movie-Title : "+ title +" Not Found");
			}
			return null;
		}
		
}
