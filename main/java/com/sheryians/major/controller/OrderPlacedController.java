package com.sheryians.major.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OrderPlacedController {

	
	
	@RequestMapping("/ordePlaced")
	public String orderPlaced()
	{
		
		return "orderPlaced";
	}

}
