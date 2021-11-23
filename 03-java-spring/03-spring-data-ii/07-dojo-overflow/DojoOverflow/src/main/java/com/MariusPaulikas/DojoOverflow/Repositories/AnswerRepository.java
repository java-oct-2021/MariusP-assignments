package com.MariusPaulikas.DojoOverflow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.DojoOverflow.Models.Answers;

@Repository
	public interface AnswerRepository extends CrudRepository<Answers, Long> {

	List<Answers> findAll();
	
	@Query("SELECT a FROM Answers a WHERE id = ?1")
    List<Answers> getAnswersWhereId(Long id);
	
}
