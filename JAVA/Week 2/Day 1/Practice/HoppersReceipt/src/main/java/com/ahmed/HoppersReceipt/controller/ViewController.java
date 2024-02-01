package com.ahmed.HoppersReceipt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class ViewController {
	@GetMapping("/")
	
    
    public String index(Model model) {
        
        String name = "Mr. Grace Hopper";
        String itemName = "Copper wire Pack";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);
        model.addAttribute("price", price);
    
        return "index.jsp";
    }
    
}
