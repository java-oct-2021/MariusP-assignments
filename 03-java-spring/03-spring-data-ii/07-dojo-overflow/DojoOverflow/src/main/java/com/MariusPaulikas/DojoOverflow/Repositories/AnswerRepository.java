package com.MariusPaulikas.DojoOverflow.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.DojoOverflow.Models.Answers;

@Repository
	public interface AnswerRepository extends CrudRepository<Answers, Long> {

	List<Answers> findAll();
}
