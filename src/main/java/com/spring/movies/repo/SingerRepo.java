package com.spring.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.movies.model.Singer;


@Repository
public interface SingerRepo extends JpaRepository<Singer, Integer> {
	
	
	
}
