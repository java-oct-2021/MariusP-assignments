package com.MariusPaulikas.DojoOverflow.Repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.DojoOverflow.Models.Tags;

@Repository
public interface TagRepository extends CrudRepository<Tags, Long> {
	
	List<Tags> findAll();
	
	boolean existsBySubject(String subject);
	
	Tags findBySubject(String subject);

}
