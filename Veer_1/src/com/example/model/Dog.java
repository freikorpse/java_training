package com.example.model;

import java.io.Serializable;

public class Dog implements Serializable {

	private static final long serialVersionUID = 666L;
	private String breed;
	
	public Dog(String breed){
		this.breed = breed;
	}
	
	public String bark(){
		return "Hau";
	}
	public String growl(){
		return "Rrrrrr....";
	}
	
	public String getBreed(){
		return breed;
	}
}
