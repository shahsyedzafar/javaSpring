package com.caveofprogramminng.spring.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.caveofprogramminng.spring.web.validation.ValidEmail;

public class Offer {
	
	private int id;
	
	@NotNull
	@Size(min=5, max=100, message = "Please enter a size between 5 and 100")
	private String name;
	
	@NotNull
	@Pattern(regexp = ".*\\@.*\\..*", message = "Not a valid email")
	@ValidEmail
	private String email;
	
	@Size(min=5, max=255, message="Size must be between 4 and 255")
	private String value;
	
	
	
	public Offer(String name, String email, String value) {
		super();
		this.name = name;
		this.email = email;
		this.value = value;
	}
	
	public Offer(int id, String name, String email, String value) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.value = value;
	}
	
	public Offer() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", value = "  + value + "]";
	}
	
}
