package com.MariusPaulikas.BeltReview.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MariusPaulikas.BeltReview.Models.Event;
import com.MariusPaulikas.BeltReview.Models.Person;
import com.MariusPaulikas.BeltReview.Services.EventService;
import com.MariusPaulikas.BeltReview.Services.PersonService;
import com.MariusPaulikas.BeltReview.Validator.BeltReviewValidator;


@Controller
public class BeltReviewController {
	
	
	@Autowired
	private EventService eventservice;
	
	@Autowired
	private final PersonService personservice;
	
	@Autowired
	private final BeltReviewValidator personvalidator;
	
	
	public BeltReviewController (PersonService personservice, BeltReviewValidator personvalidator) {
        this.personservice = personservice;
        this.personvalidator = personvalidator;
    }
	
	
	@RequestMapping("/home")
	public String HomePage(@ModelAttribute("user") Person person) {
		return "LoginRegistration.jsp";
	}
	
	
	@RequestMapping(value="/registration/submit", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") Person person, BindingResult result, HttpSession session) {
		 personvalidator.validate(person, result);
		 if(result.hasErrors()) {
			 return "LoginRegistration.jsp";
		 }
		 
		 else {
			 Person newperson = personservice.registerUser(person);
			 session.setAttribute("userId", newperson.getId());
			 return "redirect:/events";
			 
		 }
		 
	 }
	
	
	
	@RequestMapping (value="/login", method=RequestMethod.POST) 
	public String loginUser (@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectattributes) {
		 if(personservice.authenticateUser(email, password)) {
			Person client = personservice.findByEmail(email);
			session.setAttribute("userId", client.getId());
			System.out.println("user in session" + session.getAttribute("userId"));
			return "redirect:/events";
		 }
		 
		 else {
			 redirectattributes.addFlashAttribute("error", "Your email or password is not correct. Please try again.");
			 return "redirect:/home";
		 }
	    
	 }
	
	
	
	@RequestMapping("/events")
	public String Dashboard (@ModelAttribute("newevent") Event event, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/home";
		}
		
		Long l = (Long)session.getAttribute("userId");
		Person client = personservice.findUserById(l);
		model.addAttribute("person", client);
		
		
		List<Event> allevents = eventservice.allEvents();
		model.addAttribute("allevents", allevents);
		return "events.jsp";
		}

	
	
	@RequestMapping(value = "/event/create/{id}", method=RequestMethod.POST)
	public String CreateEvent (@Valid @ModelAttribute("newevent") Event event, BindingResult result, @PathVariable("id") Long id, 	HttpSession session, Model model) {
		
		if(result.hasErrors()) {
			Long l = (Long)session.getAttribute("userId");
			Person client = personservice.findUserById(l);
			model.addAttribute("person", client);
			
			
			List<Event> allevents = eventservice.allEvents();
			model.addAttribute("allevents", allevents);
			return "events.jsp";
			}
	
		
		else {
			personservice.findUserById(id);
//			event.setPerson(p);
			System.out.println(event.getEventname());
			eventservice.createEvent(event);
			return "redirect:/events";
			}
	
	}
	
}	
