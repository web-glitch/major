package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository repo;
	
	public List<Product> getAllProducts()
	{
		return repo.findAll();
	}
	
	public void addProduct(Product product)
	{
		repo.save(product);
	}
	
	public void deleteProduct(long id)
	{
		repo.deleteById(id);
	}
	
	public Optional<Product> getProductById(long id)
	{
		return repo.findById(id);
	}
	
	public List<Product> getAllProductsByCategoryId(int id)
	{
		return repo.findAllByCategory_Id(id);
	}
	
}
