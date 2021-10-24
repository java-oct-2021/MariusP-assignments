package com.MariusPaulikas.Languages.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MariusPaulikas.Languages.Models.Language;
import com.MariusPaulikas.Languages.Services.LanguageService;


@Controller
public class LanguageControllers {

	private final LanguageService languageService;
	
	public LanguageControllers(LanguageService languageService) {
		this.languageService = languageService;
	}

	
	@RequestMapping("/languages")
		public String index(@ModelAttribute("test") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	

    @RequestMapping(value = "/languages/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("test") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/languages";
        } else {
            languageService.CreateLanguage(language);
            return "redirect:/languages";
        }
    }
	
    
    @RequestMapping("/dashboard")
    	public String dashboard() {
    	return "redirect:/languages";
    }
    
    
    @RequestMapping("/languages/{id}")
    public String OneLanguage(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "new.jsp";
    }
    
    
    @RequestMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") Long id, @ModelAttribute("EditLanguage") Language language, Model model) {
    	Language editLanguage = languageService.findLanguage(id);
    	model.addAttribute("edit", editLanguage);
    	return "edit.jsp";
    	
    }
    
    
    @PutMapping("languages/update/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("Edit Language") Language language, BindingResult result) {
    	if (result.hasErrors()) {
            return "redirect:/languages/edit/{id}";
        } else {
            languageService.UpdateLanguage(id, language.getName(), language.getCreator(), language.getVersion());
            return "redirect:/languages";
        }
    }
    
    
    @RequestMapping("/languages/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
    
}
