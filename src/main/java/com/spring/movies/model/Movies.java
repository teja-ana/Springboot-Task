package com.spring.movies.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Movies")//DB
public class Movies {
	
	@Id
	@GeneratedValue
	@Column(name="mid")//DB
	private int mid;
	private String title;
	private String genre;
	private float rating;
	private String duration;

	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="did",referencedColumnName = "did")
	public Director director;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sid",referencedColumnName = "sid")
	private Singer singer;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="MovieActor",joinColumns= @JoinColumn(name="mid") ,inverseJoinColumns= @JoinColumn(name="aid"))
	private List<Actor> actors;


	public int getMid() {
		return mid;
	}


	public String getTitle() {
		return title;
	}


	public String getGenre() {
		return genre;
	}


	public float getRating() {
		return rating;
	}


	public String getDuration() {
		return duration;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public void setRating(Float rating) {
		this.rating = rating;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	
	
	
	
	public void setDirector(Director director) {
		this.director = director;
	}
	public Director getDirector() {
		return director;
	}


	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	public Singer getSinger() {
		return singer;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public List<Actor> getActors() {
		return actors;
	}

	@Override
	public String toString() {
		return "Movies [mid=" + mid + ", title=" + title + ", genre=" + genre + ", rating=" + rating + ", duration="
				+ duration + ", director=" + director + ", singer=" + singer + ", actors=" + actors + "]";
	}


	public Movies(int mid, String title, String genre, float rating, String duration) {
		super();
		this.mid = mid;
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.duration = duration;
	}


	public Movies() {
		super();
	}


	
	
	
	
	

	
}