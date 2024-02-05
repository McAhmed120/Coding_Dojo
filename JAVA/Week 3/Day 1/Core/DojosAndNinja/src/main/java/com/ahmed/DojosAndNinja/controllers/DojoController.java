package com.ahmed.DojosAndNinja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmed.DojosAndNinja.models.Dojo;
import com.ahmed.DojosAndNinja.services.DojoService;
import com.ahmed.DojosAndNinja.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	@Autowired
	private NinjaService NinServ;
	@Autowired
	private DojoService DojoServ;
	
	@GetMapping("/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
		
		return "dojo.jsp";
	}
	@PostMapping("/processDojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			return "dojo.jsp";
		}else {
			Dojo newDojo = DojoServ.createDojo(dojo);
			return "redirect:/ninja/new";
		}
	}
	@GetMapping("/{id}")
	public String ninjaByDojo(@PathVariable Long id,Model model) {
		Dojo saved = DojoServ.findDojoById(id);
		model.addAttribute("dojo", saved);
		return "show.jsp";
	}
		
}