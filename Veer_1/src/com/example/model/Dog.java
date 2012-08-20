package com.example.model;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements Serializable, HttpSessionBindingListener {

	private static final long serialVersionUID = 666L;
	private String breed ="Pudel";
	private static int count = 0;
	
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

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		count++;
		System.out.println("Dog "+breed+" has been created, id ="+count);		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Dog "+breed+" has been abaddoned, id ="+count);	
	}
}
