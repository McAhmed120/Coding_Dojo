package com.ahmed.NinjaGoldGame.controller;

import java.util.Random;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class Form{
	@GetMapping("/")
	public String index(HttpSession s) {		
	    	// If the count is not already in session
			if (s.getAttribute("count") == null) {
				s.setAttribute("count", 0);
			}
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(@RequestParam("typeE") String typeE,HttpSession s,
			RedirectAttributes flash) {
		Random rnd= new Random();
		int Vfarm=rnd.nextInt(10, 21);
		int Vcave=rnd.nextInt(5, 11);
		int Vhouse=rnd.nextInt(2, 6);
		int Vquest=rnd.nextInt(-50, 51);
		ArrayList<String> earns = (ArrayList<String>) s.getAttribute("earns");
		if (earns == null) {
	        earns = new ArrayList<>();
	    }
		ArrayList<String> losses = (ArrayList<String>) s.getAttribute("losses");		    
		    if (losses == null) {
		        losses = new ArrayList<>();
		    }
		Date date = new Date();
		if ("farm".equals(typeE) ) {
			s.setAttribute("count",(int)s.getAttribute("count")+Vfarm);
			String messageF="You entered a farm and earned "+Vfarm+" gold.("+date.toString()+")";
			earns.add(messageF);
		}
		if ("house".equals(typeE) ) {
			s.setAttribute("count",(int)s.getAttribute("count")+Vhouse);
			String messageF="You entered a house and earned "+Vhouse+" gold.("+date.toString()+")";
			earns.add(messageF);
		}
		if ("quest".equals(typeE) ) {
			s.setAttribute("count",(int)s.getAttribute("count")+Vquest);
			if (Vquest<0) {
				String messageF="You failed a quest and lost "+Vquest+" gold.Ouch("+date.toString()+")";
				losses.add(messageF);
			}
			if (Vquest>0) {
				String messageF="You completed a QUEST and earned "+Vquest+" gold.("+date.toString()+")";
				earns.add(messageF);
			}
		}
		if ("cave".equals(typeE) ) {
			s.setAttribute("count",(int)s.getAttribute("count")+Vcave);
			String messageF="You entered a cave and earned "+Vcave+" gold.("+date.toString()+")";
			earns.add(messageF);
		}
		s.setAttribute("earns",earns);
		s.setAttribute("losses",losses);
		if ("reset".equals(typeE) ) {
			s.invalidate();
		}
		return "redirect:/";
	}
	
}