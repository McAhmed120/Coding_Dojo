package com.ahmed.counter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class ViewController {
	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			}
			else {
				session.setAttribute("count",(int)session.getAttribute("count")+1 );
			}
		return "index.jsp";
	}
	@GetMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
}
