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
	private String gid;
	

	@OneToOne(cascade = CascadeType.ALL)	
	public Director director;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
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

	public String getGid() {
		return gid;
	}

	public Director getDirector() {
		return director;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Movies [mid=" + mid + ", title=" + title + ", gid=" + gid + ", director=" + director + ", singer="
				+ singer + "]";
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
	
	
}