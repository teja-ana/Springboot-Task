package com.spring.movies.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Actor {
	
	@Id
	@GeneratedValue
	private int aid;
	private String aname;
	private String agender;
	
	@ManyToMany(mappedBy = "actors")
	@JsonIgnore
	private List<Movies> movies3;

	public int getAid() {
		return aid;
	}

	public String getAname() {
		return aname;
	}

	public String getAgender() {
		return agender;
	}

	public List<Movies> getMovies3() {
		return movies3;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public void setAgender(String agender) {
		this.agender = agender;
	}

	public void setMovies3(List<Movies> movies3) {
		this.movies3 = movies3;
	}
	
	
	
	

}