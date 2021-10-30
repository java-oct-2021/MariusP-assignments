package com.MariusPaulikas.DojosAndNinjas.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MariusPaulikas.DojosAndNinjas.Models.Dojo;
import com.MariusPaulikas.DojosAndNinjas.Models.Ninja;
import com.MariusPaulikas.DojosAndNinjas.Services.DojoService;
import com.MariusPaulikas.DojosAndNinjas.Services.NinjaService;




@Controller
public class DojosAndNinjasController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
//	public DojosAndNinjasController(DojoService dojoService, NinjaService ninjaService) {
//		this.dojoService = dojoService;
//		this.ninjaService = ninjaService;
//		}
	
	@RequestMapping("/dojos/new")
	public String create(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@RequestMapping(value = "/dojos/new/create", method=RequestMethod.POST)
		public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newdojo.jsp";
		} else {
			Dojo location = dojoService.createDojo(dojo);
			return "redirect:/dojos/new/" + location.getId();
		}

	}
	
	
	@RequestMapping("/dojos/new/{id}")
		public String create(@PathVariable("id") long id, Dojo dojo, Model model) {
		List<Ninja>allNinjas = ninjaService.allNinjas();
		model.addAttribute("AllNinjas", allNinjas);
		Dojo location = dojoService.findDojo(id);
		model.addAttribute("location", location);
		System.out.println(location.getDojo());
		return "dojolocation.jsp";
	}
	
	
	
	@RequestMapping("/ninjas/new")
		public String Ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("Dojos",allDojos);
		return "newninja.jsp";
		
	}
	
	
	@RequestMapping(value = "/ninjas/new/create", method=RequestMethod.POST)
	public String CreateNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		ninjaService.createNinja(ninja);
		return "redirect:/dojos/new/" + ninja.getDojo().getId();
	

	}
	
}
