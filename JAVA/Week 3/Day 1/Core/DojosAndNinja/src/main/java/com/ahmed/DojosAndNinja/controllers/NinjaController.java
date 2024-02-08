package com.ahmed.DojosAndNinja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmed.DojosAndNinja.models.Dojo;
import com.ahmed.DojosAndNinja.models.Ninja;
import com.ahmed.DojosAndNinja.services.DojoService;
import com.ahmed.DojosAndNinja.services.NinjaService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/ninja")
public class NinjaController {
	@Autowired
	private NinjaService NinServ;
	@Autowired
	private DojoService DojoServ;
	
	@GetMapping("/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = DojoServ.allDojos();
		model.addAttribute("allDojos",allDojos);
		return "ninja.jsp";
	}
	@PostMapping("/processNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		Number id=ninja.getDojo().getId();
		if (result.hasErrors()) {
			return "ninja.jsp";
		}else {
			Ninja newNinja = NinServ.createNin(ninja);
			return "redirect:/dojo/"+id;
		}

	}
}