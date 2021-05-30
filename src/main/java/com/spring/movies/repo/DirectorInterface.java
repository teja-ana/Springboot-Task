package com.spring.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.movies.model.Director;
@Repository
public interface DirectorInterface extends JpaRepository<Director, Integer> {

}
