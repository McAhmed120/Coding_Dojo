package com.ahmed.BurgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmed.BurgerTracker.models.Burger;
import com.ahmed.BurgerTracker.repositories.BurgerRepository;

@Service

public class BurgerService {
	
	private final BurgerRepository burgerRepo;
	
	public BurgerService(BurgerRepository burgerRepo) {
		this.burgerRepo=burgerRepo;
	}
	
	public List<Burger> allBurgers() {
        return burgerRepo.findAll();
    }
    // creates a book
    public Burger createBurger(Burger b) {
        return burgerRepo.save(b);
    }
    
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepo.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    public Burger updateBurger(Burger b) {
        return burgerRepo.save(b);
    }
    public void deleteBurger(Long id) {
        burgerRepo.deleteById(id);
    }
    
}