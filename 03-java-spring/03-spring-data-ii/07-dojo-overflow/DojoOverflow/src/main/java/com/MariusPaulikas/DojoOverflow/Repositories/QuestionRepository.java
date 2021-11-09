package com.MariusPaulikas.DojoOverflow.Repositories;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.DojoOverflow.Models.Questions;

@Repository
public interface QuestionRepository extends CrudRepository <Questions, Long>{
	
	List<Questions> findAll();

	Question save(Question q);

}
