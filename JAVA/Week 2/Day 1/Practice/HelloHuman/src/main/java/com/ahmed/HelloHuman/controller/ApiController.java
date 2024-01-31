package com.ahmed.HelloHuman.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("")
public class ApiController {
	@GetMapping("")
	public String homename(@RequestParam(value="name",required =false) String name) {
		if(name==null) {
			return "Hello Human";
		}
		return "Hello "+name;
	}
	

}