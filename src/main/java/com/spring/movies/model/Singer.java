package com.spring.movies.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
@Entity
public class Singer{
	
	
	@Id
	@GeneratedValue
	private int sid;
	private String sname;
	private String sgender;
	private String song;
	
	
	@OneToMany(mappedBy = "singer",cascade = CascadeType.ALL)
    private List<Movies> movie2=new ArrayList<>();
	
	
	@PrePersist
	public void addChild() {
		this.movie2.forEach(movies->{movies.setSinger(this);  });
	}


	public int getSid() {
		return sid;
	}


	public String getSname() {
		return sname;
	}


	public String getSgender() {
		return sgender;
	}


	public String getSong() {
		return song;
	}


	public List<Movies> getMovie2() {
		return movie2;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public void setSgender(String sgender) {
		this.sgender = sgender;
	}


	public void setSong(String song) {
		this.song = song;
	}


	public void setMovie2(List<Movies> movie2) {
		this.movie2 = movie2;
	}


	@Override
	public String toString() {
		return "Singer [sid=" + sid + ", sname=" + sname + ", sgender=" + sgender + ", song=" + song + ", movie2="
				+ movie2 + "]";
	}

	
	

}
