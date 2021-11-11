package com.MariusPaulikas.BeltReview.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.BeltReview.Models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	List<Person> findAll();
	Person findByEmail(String email);
	boolean existsByEmail(String email);

}
