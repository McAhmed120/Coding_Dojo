package com.ahmed.BookClub.controllers;

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

import com.ahmed.BookClub.models.Book;
import com.ahmed.BookClub.models.User;
import com.ahmed.BookClub.services.BookService;
import com.ahmed.BookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	 @Autowired
     private UserService userServ;
     @Autowired
     private BookService bookServ;
     
     @GetMapping("/books")
     public String welcome(Model m,HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
 		if(userId == null) {
 			return "redirect:/";
 		}
 		User user = userServ.findUserById(userId);
 		List<Book> allBooks = bookServ.allBooks();
		m.addAttribute("allBooks",allBooks);
		m.addAttribute("user",user);
         return "home.jsp";
     }
     
     @GetMapping("/books/new")
     public String addbook(@ModelAttribute("book") Book book,HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
  		if(userId == null) {
  			return "redirect:/";
  		}
    	 return "NewBook.jsp";
     }
     @PostMapping("/processBook")
 	public String createBook(@Valid @ModelAttribute("book") Book book,BindingResult result,Model model,HttpSession s) {
    	 Long userId = (Long) s.getAttribute("user_id");
	  		if(userId == null) {
	  			return "redirect:/";
	  		}
    	 if (result.hasErrors()) {
 			return "NewBook.jsp";
 		}else {
			// grab the user by their id
			User user = userServ.findUserById(userId);
			book.setUser(user);
 			Book newBook = bookServ.createBook(book);
 			return "redirect:/books";
 		}}
     @GetMapping("/books/{id}")
     public String onebook(Model model, @PathVariable("id") Long id,HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
  		if(userId == null) {
  			return "redirect:/";
  		}
    	 User user = userServ.findUserById(userId);
 		model.addAttribute("user",user);
    	 Book selectedBook=bookServ.findBook(id);
    	 model.addAttribute("book",selectedBook);
    	 return "OneBook.jsp";
     }
     @DeleteMapping("/delete/{id}")
 		public String deleteBook(@PathVariable("id") Long id,HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
  		if(userId == null) {
  			return "redirect:/";
  		}
 		bookServ.deleteBook(id);
 		return "redirect:/books";
 	}
     @GetMapping("/books/{id}/edit")
		public String getMethodName(Model model, @PathVariable("id") Long id,HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
  		if(userId == null) {
  			return "redirect:/";
  		}
		
			Book selected = bookServ.findBook(id);
			model.addAttribute("book",selected);
			return "EditBook.jsp";
		}
		
		@PutMapping("/editBook/{id}")
		public String editExp(@Valid @ModelAttribute("book") Book book, BindingResult result,HttpSession s) {
			Long userId = (Long) s.getAttribute("user_id");
		  		if(userId == null) {
		  			return "redirect:/";
		  		}
				
			if(result.hasErrors()) {
				return "EditBook.jsp";
			}else {
				
				// grab the user by their id
				User user = userServ.findUserById(userId);
				book.setUser(user);
				bookServ.createBook(book);
			
				return "redirect:/books";
			}
		}
}