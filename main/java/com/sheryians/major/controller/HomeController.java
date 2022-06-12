package com.sheryians.major.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheryians.major.global.GlobalData;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;

@Controller
public class HomeController 
{
	@Autowired
	ProductService proService;
	@Autowired
	CategoryService catService;
	
	@GetMapping({"/","/home"})
	public String home(Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("categories",catService.getAllCategory());
		model.addAttribute("products",proService.getAllProducts());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shop(Model model,@PathVariable int id)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("categories",catService.getAllCategory());
		model.addAttribute("products",proService.getAllProductsByCategoryId(id));
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(@PathVariable int id,Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("product",proService.getProductById(id).get());
		return "viewProduct";
	}
	
	
	
}
