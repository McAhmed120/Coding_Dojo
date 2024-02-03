package com.ahmed.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.SaveTravels.models.Expense;
import com.ahmed.SaveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository ExpRepo;
	
	public List<Expense> allExpenses(){
		return ExpRepo.findAll();
	}
	
	// CREATE
	public Expense createExp(Expense e) {
		return ExpRepo.save(e);
	}
	
	
	// READ ONE
	public Expense findExpById(Long id) {
		Optional<Expense> maybeExp = ExpRepo.findById(id);
		if(maybeExp.isPresent()) {
			return maybeExp.get();
		}else {
			return null;
		}
	}
	
	// UPDATE
	public Expense updateExp(Expense e) {
		return ExpRepo.save(e);
	}
	
	// DELETE
	public void deleteExp(Long id) {
		ExpRepo.deleteById(id);
	}

}