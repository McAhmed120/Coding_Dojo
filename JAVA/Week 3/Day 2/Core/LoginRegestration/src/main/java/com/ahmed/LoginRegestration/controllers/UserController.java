package com.ahmed.LoginRegestration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmed.LoginRegestration.models.LoginModel;
import com.ahmed.LoginRegestration.models.UserModel;
import com.ahmed.LoginRegestration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
    
    // Add once service is implemented:
     @Autowired
     private UserService userServ;
    
     @GetMapping("/welcome")
     public String welcome(HttpSession session, Model model) {
    	 Long userId = (Long) session.getAttribute("user_id");
 		if(userId == null) {
 			return "redirect:/";
 		}
 		// grab the current logged-in user by id
 		UserModel currentUser = userServ.findUserById(userId);
 		model.addAttribute("user",currentUser);
         return "home.jsp";
     }
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new UserModel());
        model.addAttribute("newLogin", new LoginModel());
        return "index.jsp";
    }
    
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") UserModel newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	userServ.register(newUser, result);
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginModel());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/welcome";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginModel newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    	UserModel user=userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new UserModel());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/welcome";
    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
