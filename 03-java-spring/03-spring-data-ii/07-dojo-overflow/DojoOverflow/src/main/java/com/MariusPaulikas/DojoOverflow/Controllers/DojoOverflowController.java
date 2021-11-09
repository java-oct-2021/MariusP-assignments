package com.MariusPaulikas.DojoOverflow.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.Tag;
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

import com.MariusPaulikas.DojoOverflow.Models.Answers;
import com.MariusPaulikas.DojoOverflow.Models.Questions;
import com.MariusPaulikas.DojoOverflow.Models.Tags;
import com.MariusPaulikas.DojoOverflow.Services.AnswerService;
import com.MariusPaulikas.DojoOverflow.Services.QuestionService;
import com.MariusPaulikas.DojoOverflow.Services.TagService;


@Controller
public class DojoOverflowController {

	@Autowired
	private AnswerService answerservice;
	
	@Autowired
	private QuestionService questionservice;
	
	@Autowired
	private TagService tagservice;
	
	
	@RequestMapping("/questions/new")
	public String Home(@ModelAttribute("newquestion") Questions question, Tags tag) {
		return "questionsnew.jsp";
	}
	
	@RequestMapping(value = "/questions/new/submit", method=RequestMethod.POST) 
	public String NewQuestion(@Valid @ModelAttribute("newquestion") Questions question, BindingResult result) {
		if(result.hasErrors()) {
			 return "questionsnew.jsp";
		}
			
		ArrayList<Tags> Supertags = new ArrayList<Tags> ();
		String[] separators = question.getTag().split(",");
		for(int i = 0; i < separators.length; i++) {
			
			if(tagservice.dupeTags(separators[i])) {
				Tags x = tagservice.findBySubject(separators[i]);
				Supertags.add(x);
			}
			
			else {
				Tags newtag = new Tags(separators[i]);
				this.tagservice.createTag(newtag);
				Supertags.add(newtag);
			}
			
		}
		question.setTags(Supertags);
		questionservice.createQuestion(question);
		return "redirect:/questions";
	
	}
	
	
	@RequestMapping("questions/newquestion")
	public String NewQuestionRedirect() {
		return "redirect:/questions/new";
	}
	
	
	
	@RequestMapping("/questions")
	public String QuestionList(@ModelAttribute("newanswer") Questions question, Model model) {
		List<Questions> allquestions = questionservice.allQuestions();
		model.addAttribute("questions", allquestions);
		return "questions.jsp";
	}
	
	
	@RequestMapping("/questions/{id}")
	public String QuestionId(@ModelAttribute("submitanswer") Answers answer, @PathVariable("id")Long id, Questions question, Model model) {
		Questions q = questionservice.findQuestions(id);
		model.addAttribute("question", q);
		return "questionid.jsp";
	}
	
	
	@RequestMapping(value = "/answers/new/{id}", method=RequestMethod.POST)
	public String NewAnswer(@Valid @ModelAttribute("submitanswer") Answers answer, BindingResult result, @PathVariable("id")Long id, Model model ) {
		if(result.hasErrors()) {
			Questions q = questionservice.findQuestions(id);
			model.addAttribute("question", q);
			return "questionid.jsp";
	
		}
		else {
		Questions q = questionservice.findQuestions(id);
		answer.setQuestion(q);
		answerservice.createAnswer(answer);
		return "redirect:/questions/" + id;
		}
	}
	
}
