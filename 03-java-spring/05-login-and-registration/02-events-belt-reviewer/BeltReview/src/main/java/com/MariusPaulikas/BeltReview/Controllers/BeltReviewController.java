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

import com.MariusPaulikas.BeltReview.Models.Discussion;
import com.MariusPaulikas.BeltReview.Models.Event;
import com.MariusPaulikas.BeltReview.Models.Person;
import com.MariusPaulikas.BeltReview.Services.DiscussionService;
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
	
	
	@Autowired
	private final DiscussionService discussionservice;
	
	
	public BeltReviewController (PersonService personservice, BeltReviewValidator personvalidator, DiscussionService discussionservice) {
        this.personservice = personservice;
        this.personvalidator = personvalidator;
        this.discussionservice = discussionservice;
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
		
		List<Person> allpersons = personservice.allPersons();
		model.addAttribute("allpersons", allpersons);
		
		return "events.jsp";
		}

	
	@RequestMapping("/event/{id}")
	public String EventDescription(@ModelAttribute("eventdescribe") Discussion discussion, @PathVariable("id") Long id, Model model) {
		Event ev = eventservice.findEvents(id);
		model.addAttribute("event", ev);
		
		List<Person> mypersons = ev.getPeople();
		model.addAttribute("mypersons", mypersons);
		
		List<Discussion>mydiscussions = ev.getDiscussions();
		model.addAttribute("mydiscussions", mydiscussions);
		
		return "eventsid.jsp";
	}
	
	
	
	@RequestMapping(value = "/event/create/{id}", method=RequestMethod.POST)
	public String CreateEvent (@Valid @ModelAttribute("newevent") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		
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
			eventservice.createEvent(event);
			return "redirect:/events";
			}
	
	}
	
	
	@RequestMapping("/event/delete/{id}")
	public String delete(@PathVariable("id") Long id){
		eventservice.deleteEvent(id);
        return "redirect:/events";
    }
	
	
	
	@RequestMapping("event/edit/{id}")
	public String EditEvent(@ModelAttribute("editevent") Event event, @PathVariable("id") Long id, Model model) {
		Event editingevent = eventservice.findEvents(id);
		model.addAttribute("event", editingevent);
		return "eventsedit.jsp";
	}
	
// xxxxxxxxxxxxxxxxx The below 3 are causing problems xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	 
	
	
	@RequestMapping(value = "/event/discussion/{id}", method=RequestMethod.POST)
	public String AddDiscussion(@PathVariable("id") Long id, @ModelAttribute("eventdescribe") Discussion discussion, HttpSession session) {
		Event e = eventservice.findEvents(id);
		discussion.setEvent(e);
		discussionservice.createDiscussion(discussion);
		return "redirect:/event/{id}";
	}
	
	
	
// xxxxxxxxxxxxxxxxxxx The above 1 need to be fixed xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	
	@RequestMapping(value = "/event/edit/submit/{id}", method=RequestMethod.POST)
	public String SubmitEdit (@ModelAttribute("editevent") Event event, @PathVariable("id") Long id)  {
		eventservice.updateEvent(id, event.getEventname(), event.getEventdate(), event.getEventcity(), event.getEventstate());
		return "redirect:/events";
	}
	
	@RequestMapping("/event/join/{id}")
	public String JoinEvent (@PathVariable("id") Long id, HttpSession session) {
		Long userid = (Long)session.getAttribute("userId");
		Person p = personservice.findUserById(userid);
		eventservice.AddPerson(p, eventservice.findEvents(id));
		return "redirect:/events";
		
	}
	
	@RequestMapping("/event/cancel/{id}")
	public String CancelEvent (@PathVariable("id") Long id, HttpSession session) {
		Long userid = (Long)session.getAttribute("userId");
		Person p = personservice.findUserById(userid);
		eventservice.SubtractPerson(p, eventservice.findEvents(id));
		return "redirect:/events";
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	
	
	
	
}	
