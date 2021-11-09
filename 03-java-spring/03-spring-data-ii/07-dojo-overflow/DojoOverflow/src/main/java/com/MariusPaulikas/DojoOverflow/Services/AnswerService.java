package com.MariusPaulikas.DojoOverflow.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.DojoOverflow.Models.Answers;
import com.MariusPaulikas.DojoOverflow.Models.Questions;
import com.MariusPaulikas.DojoOverflow.Repositories.AnswerRepository;



@Service
public class AnswerService {
	
	private final AnswerRepository answerrepository;
	
	public AnswerService (AnswerRepository answerrepository) {
		this.answerrepository = answerrepository;
	}

	public List<Answers> allAnswers()  {
		return answerrepository.findAll();
	
	}
	
	public Answers createAnswer (Answers a) {
		return answerrepository.save(a);
	}
	
	
	
	public Answers findAnswers(Long id) {
		Optional<Answers> optionalAnswer = answerrepository.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
		
	}
	
	
	
}
