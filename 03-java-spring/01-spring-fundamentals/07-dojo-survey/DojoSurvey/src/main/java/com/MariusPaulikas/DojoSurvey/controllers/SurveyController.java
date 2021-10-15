package com.MariusPaulikas.DojoSurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {

	@GetMapping("/")
	public String Home() {
		return "index.jsp";
	}
	
	@GetMapping("/result")
	public String Result(@RequestParam("fname") String fname, @RequestParam("location") String location, @RequestParam("language") String language, @RequestParam("comments") String comments, Model model) {
		model.addAttribute("fname", fname);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comments", comments);
		return "result.jsp";
	}
	
	@GetMapping("/submit")
	public String Submit() {
		return "index.jsp";
	}


}
