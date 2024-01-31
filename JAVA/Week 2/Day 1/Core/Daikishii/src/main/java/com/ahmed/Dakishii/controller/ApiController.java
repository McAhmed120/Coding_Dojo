package com.ahmed.Dakishii.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/daikishi")
public class ApiController {
	
	@GetMapping("")
	public String home() {
		return "<h1>Welcome</h1>!";
	}
	@GetMapping("/today")
	public String today() {
		return "<h1>Today you will find luck in all your endeavors!</h1>";
	}
	@GetMapping("/tomorrow")
	public String tomorrow() {
		return "<h1>Tomorrow, an opportunity will arise, so be sure to be open to new ideas!<h1>";
	}
	@GetMapping("/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "<h1>Congratulations! You will soon travel to </h1> "+city+"!";
	}
	@GetMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") int num) {
		if(num%2==0) {return "You will take a grand journey in the near future,but weary of tempting offers";}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
	}
	
	
}