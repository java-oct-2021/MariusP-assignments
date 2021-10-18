package com.MariusPaulikas.DisplayDate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;  
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
  

@Controller
public class DisplayController {

	@GetMapping("/")
	public String Home() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model model) { 
		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy");
	    model.addAttribute("formatter", formatter.format(new java.util.Date()));  
		return "Date.jsp";
	}


	@GetMapping("/time")
	public String time (Model model) { 
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
	    model.addAttribute("timer", formatter.format(new java.util.Date()));  
		return "Time.jsp";
	}
}