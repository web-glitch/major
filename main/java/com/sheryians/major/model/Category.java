package com.sheryians.major.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name="category")
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="category_id")
	
	private int id;
	@Column(name="name")
	private String name;
	public Category()
	{
		
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
}
