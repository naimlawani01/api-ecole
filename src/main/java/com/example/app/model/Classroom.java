package com.example.app.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Classroom {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer size;
	private String level;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="ecole_id", nullable=false)
	@ManyToOne()
	private Ecole ecole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Classroom(Long id, String name, Integer size, String level, Ecole ecole) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.level = level;
		this.ecole = ecole;
	}

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


	public Ecole getEcole() {
		return ecole;
	}
}

