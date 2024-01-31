package com.ahmed.Daikichi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/daikishi")
public class ApiController {
	
	@GetMapping("")
	public String home() {
		return "<h1>Welcome!</h1>";
	}
	@GetMapping("/today")
	public String today() {
		return "<h1>Today you will find luck in all your endeavors!</h1>";
	}
	@GetMapping("/tomorrow")
	public String tomorrow() {
		return "<h1>Tomorrow, an opportunity will arise, so be sure to be open to new ideas!</h1>";
	}
	
	
}