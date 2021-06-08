package com.spring.movies.repo;

import java.util.List;

import com.spring.movies.model.Movies;

public interface MoviesRepoCustom {
	public List<Movies> getTitleContainsString(String title);
}
