package com.MariusPaulikas.DojoOverflow.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.DojoOverflow.Models.Answers;
import com.MariusPaulikas.DojoOverflow.Models.Questions;
import com.MariusPaulikas.DojoOverflow.Models.Tags;
import com.MariusPaulikas.DojoOverflow.Repositories.QuestionRepository;


@Service
public class QuestionService {

private final QuestionRepository questionrepository;
	
	public QuestionService (QuestionRepository questionrepository) {
		this.questionrepository = questionrepository;
	}

	public List<Questions> allQuestions()  {
		return questionrepository.findAll();
	
	}
	
	public Questions createQuestion (Questions q) {
		return questionrepository.save(q);
	}
	
	public Questions findQuestions(Long id) {
		Optional<Questions> optionalQuestions = questionrepository.findById(id);
		if(optionalQuestions.isPresent()) {
			return optionalQuestions.get();
		} else {
			return null;
		}
		
	}
	
	
	public Questions AddAnswer(Answers a, Questions q) {
		List<Answers> myanswers = q.getAnswers();
		myanswers.add(a);
		return questionrepository.save(q);
		
		
	}
	
	
	public Questions AddTag(Tags t, Questions q) {
		List<Tags> mytags = q.getTags();
		mytags.add(t);
		return questionrepository.save(q);
	}
	
	
	
}
