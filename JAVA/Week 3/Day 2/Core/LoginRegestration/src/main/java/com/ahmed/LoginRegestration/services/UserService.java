package com.ahmed.LoginRegestration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ahmed.LoginRegestration.models.LoginModel;
import com.ahmed.LoginRegestration.models.UserModel;
import com.ahmed.LoginRegestration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public UserModel register(UserModel newUser, BindingResult result) {
    	Optional<UserModel> potentialUser = userRepo.findByEmail(newUser.getEmail());
        // TO-DO: Additional validations!
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "emailError", "Email already taken!");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return userRepo.save(newUser);
    	}
    	
    }
    
    public UserModel login(LoginModel newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional<UserModel> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        // TO-DO: Additional validations!
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "emailError", "Email doesn't Exist!");
    	}else {
    		UserModel user = potentialUser.get();
    		// check the password
    		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		    result.rejectValue("password", "loginErrors", "Invalid Password!");
    		}
    		if(result.hasErrors()) {
    			return null;
    		}else {
    			return user;
    		}
    	}
        return null;
    }
    
    public UserModel findUserById(Long id) {
    	
    	Optional<UserModel> potientialUser = userRepo.findById(id);
    	if(potientialUser.isPresent()) {
    		return potientialUser.get();
    	}else {
    		return null;
    	}
    	
    }
}