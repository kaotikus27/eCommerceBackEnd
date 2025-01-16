package com.hercodecommerce.demo.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	
	//Set up one to many with states                                             
	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private List<State> states;
	

	public Country() {
		
	}


	public Country(int id, String code, String name, List<State> states) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.states = states;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<State> getStates() {
		return states;
	}


	public void setStates(List<State> states) {
		this.states = states;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name=" + name + ", states=" + states + "]";
	}

	
	
	
}
