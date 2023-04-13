package com.example.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Classroom {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer size;
	private String level;
	


	public Classroom(String name, Integer size, String level) {
	    this.name = name;
	    this.size = size;
	    this.level = level;
	}

	public Classroom() {

	}


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Integer getSize() {
		return size;
	}




	public void setSize(Integer size) {
		this.size = size;
	}




	public String getLevel() {
		return level;
	}




	public void setLevel(String level) {
		this.level = level;
	}
	
}

