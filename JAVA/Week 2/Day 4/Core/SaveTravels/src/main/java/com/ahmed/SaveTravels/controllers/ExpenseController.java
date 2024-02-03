package com.ahmed.SaveTravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmed.SaveTravels.models.Expense;
import com.ahmed.SaveTravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	private ExpenseService ExpServ;

	//
	@GetMapping("")
	public String home(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allExpenses = ExpServ.allExpenses();
		model.addAttribute("allExpenses",allExpenses);
		return "home.jsp";
	}
	
		@PostMapping("/processExpense")
		public String createExp(@Valid @ModelAttribute("expense") Expense expense,
				BindingResult result,
				Model model) {
			if (result.hasErrors()) {
				
				List<Expense> allExpenses = ExpServ.allExpenses();
				model.addAttribute("allExpenses",allExpenses);
				return "home.jsp";
			}else {
				Expense newExp = ExpServ.createExp(expense);
				return "redirect:/expenses";
			}
			
		}
		
		@DeleteMapping("/{id}")
		public String deleteBook(@PathVariable("id") Long id) {
			
			ExpServ.deleteExp(id);
			
			return "redirect:/expenses";
		}
		@GetMapping("/edit/{id}")
		public String getMethodName(Model model, @PathVariable("id") Long id) {
		
			Expense selectedExp = ExpServ.findExpById(id);
			model.addAttribute("expense",selectedExp);
			return "edit.jsp";
		}
		
		@PutMapping("/update/{id}")
		public String editExp(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
			
			if(result.hasErrors()) {
				return "edit.jsp";
			}else {
				
				ExpServ.updateExp(expense);
			
				return "redirect:/expenses";
			}
		}
		@GetMapping("/{id}")
		public String getOne(Model model, @PathVariable("id") Long id) {
			
			Expense selectedExp = ExpServ.findExpById(id);
			model.addAttribute("expense",selectedExp);
			return "show.jsp";
		}
}