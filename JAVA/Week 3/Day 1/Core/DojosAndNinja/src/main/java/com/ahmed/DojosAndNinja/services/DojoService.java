package com.ahmed.DojosAndNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.DojosAndNinja.models.Dojo;
import com.ahmed.DojosAndNinja.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	// CREATE
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	
	// READ ONE
	public Dojo findDojoById(Long id) {
		Optional<Dojo> maybeDojo = dojoRepo.findById(id);
		if(maybeDojo.isPresent()) {
			return maybeDojo.get();
		}else {
			return null;
		}
	}
}
