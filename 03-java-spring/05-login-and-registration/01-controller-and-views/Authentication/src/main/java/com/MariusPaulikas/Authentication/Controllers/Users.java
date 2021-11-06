package com.MariusPaulikas.Authentication.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MariusPaulikas.Authentication.Models.User;
import com.MariusPaulikas.Authentication.Services.UserService;
import com.MariusPaulikas.Authentication.Validator.UserValidator;



@Controller
public class Users {
	private final UserService userService;
    
    // NEW
    private final UserValidator userValidator;
    
    // NEW
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
        

 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }

 
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 
 @RequestMapping(value="/registration/submit", method=RequestMethod.POST)
 
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 userValidator.validate(user, result);
	 if(result.hasErrors()) {
		 return "registrationPage.jsp";
	 }
	 
	 else {
		 User person = userService.registerUser(user);
		 session.setAttribute("person", person.getId());
		 return "redirect:/login";
		 
	 }
	 

 }
	 
@RequestMapping (value="/login", method=RequestMethod.POST) 
public String loginUser (@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	 if(userService.authenticateUser(email, password)) {
		User client = userService.findByEmail(email);
		session.setAttribute("client", client.getId());
		return "redirect:/home";
	 }
	 
	 else {
		 model.addAttribute("error", "Your email or password is not correct. Please try again.");
		 return "loginPage.jsp";
	 }
    
 }
 
 

@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
	Long l = (Long)session.getAttribute("client");
	User client = userService.findUserById(l);
	model.addAttribute("user", client);
	return "homePage.jsp";
}


	 
 
@RequestMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/login";
}


}

