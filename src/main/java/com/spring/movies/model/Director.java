package com.spring.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="Director")//DB
public class Director {
	
	@Id
	@GeneratedValue
	@Column(name="did")//DB
	private int did;
	private String dname;
	private String dgender;
	private int success;
	
	
	@OneToOne(mappedBy = "director")
	private Movies movies1;
	
	public int getDid() {
		return did;
	}
	public String getDname() {
		return dname;
	}
	public String getDgender() {
		return dgender;
	}
	public int getSuccess() {
		return success;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setDgender(String dgender) {
		this.dgender = dgender;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	
	
	

	
}