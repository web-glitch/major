package com.sheryians.major.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name="product")
public class Product 
{
	@Column(name="id")
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne()
	@JoinColumn(name="category_id",referencedColumnName="category_id")
	private Category category;
	@Column(name="price")
	private double price;
	@Column(name="weight")
	private double weight;
	@Column(name="description")
	private String description;
	@Column(name="image_name")
	private String imageName;
	
	
	public Product()
	{
		
	}
	public Product(Long id, String name, Category category, double price, double weight, String description,
			String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.weight = weight;
		this.description = description;
		this.imageName = imageName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
