package com.spring.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.movies.model.Actor;

public interface ActorRepo  extends JpaRepository<Actor, Integer> {

}
