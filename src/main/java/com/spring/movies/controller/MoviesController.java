package com.spring.movies.controller;

import java.util.List;
//import java.util.logging.Logger;

import org.apache.log4j.Logger;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movies.MovieAppApplication;
import com.spring.movies.exception.CustomExceptions;
import com.spring.movies.model.Movies;
import com.spring.movies.model.Singer;
import com.spring.movies.repo.DirectorRepo;
import com.spring.movies.repo.MoviesRepo;

import com.spring.movies.repo.MoviesRepoImpl;

import com.spring.movies.services.MoviesServices;


@RestController
public class MoviesController {
	
	
	private static Logger logger=Logger.getLogger(MovieAppApplication.class);
	
	
	@Autowired
	private MoviesServices moviesServices;
	
	@Autowired
	private MoviesRepo moviesRepo;
	
	@Autowired
	private DirectorRepo directorRepo;
	
	

		//GET METHOD --create get all movies
		@GetMapping("/movies/get")
		public List<Movies> getAllMovies(){
			logger.info("in GET ALL MOVIES");
			return moviesServices.getAllMovies();
		}

		//GET METHOD BY ID--get movie by id
		@GetMapping("/movies/get/{mid}")
		public Movies getMoviesById(@PathVariable(value = "mid") int mid) {
			logger.info("in GET ALL MOVIES BY ID");
			return moviesServices.getMoviesById(mid);
		}
		
		//POST METHOD--create movie
		@PostMapping("/movies/post")
		public List<Movies> createMovies(@RequestBody List<Movies> movies) {
			logger.info("in POST ALL MOVIES");
			return moviesServices.createMovies(movies);
			
		}
		
		//PuT METHOD-- update movies
		@PutMapping("/movies/put")
		public Movies updateMovies( @RequestBody Movies moviesDetails) {
			logger.info("in PUT ALL MOVIES");
			logger.debug("Update MOVIES");
			return moviesServices.updateMovies(moviesDetails);
		}
			
		//DELETE METHOD -- delete movies by id
		@DeleteMapping("/movies/delete/{mid}")
		public String deleteById(@PathVariable(value = "mid") int mid) {
			logger.info("in DELETE ALL MOVIES");
			return moviesServices.deleteById(mid);
		}
		
		
		
		//DIRECTOR
		//GET METHOD --create get all movies
		@GetMapping("/director/get")
		public List<Movies> getAlldirectors(){
			logger.info("in GET ALL DIRECTORS");
			return moviesServices.getAlldirectors();
		}
		
						
		//SINGER
		//GET METHOD --create get all singer
		@GetMapping("/singer/get")
		public List<Singer> getAllSinger(){
			logger.info("in GET ALL SINGERS");
			return moviesServices.getAllSinger();
		}
			
		//POST METHOD--create singer
		@PostMapping("/singer/post")
		public Singer createSinger(@RequestBody Singer singer) {
			logger.info("POST SINGERS");
			return moviesServices.createSinger(singer);					
		}
				
		
				
		
		//JDBC 
		@GetMapping("/movies/{title}")
		public List<Movies> getTitleContainsString(@PathVariable(value = "title") String title){
			return moviesRepo.getTitleContainsString(title); 
		}

		
		//CUSTOM QURIES
		
		//GETTING MOVIES ID AND GENRE BETWEEN RANGE OF ID'S	
		@GetMapping("/movies/mid")//(http://localhost:8081/movies/mid?mid1=2&mid2=5)
		@ResponseBody
		public List<Object[]> getMovieByIds(@RequestParam("mid1") int mid1,@RequestParam("mid2") int mid2)
		{
			return moviesRepo.getMovieById(mid1, mid2);
		}
		
	    @GetMapping("/director/success")
	    @ResponseBody
		public List<Object[]> getDirectorsBySucc(@RequestParam("succ1") int succ1,@RequestParam("succ2") int succ2)
		{
		return directorRepo.getDirectorBySuccess(succ1, succ2);
		}
	
		
		//Execption handling
		@GetMapping("/movies/title/{title}")
		public Movies findByTitle(@PathVariable(value="title") String title ) throws CustomExceptions{
			return moviesServices.findByTitle(title);
		}
		
		
		
		//TEST
		
		public int add(int a,int b) {
			return a+b;
		}
		
}
