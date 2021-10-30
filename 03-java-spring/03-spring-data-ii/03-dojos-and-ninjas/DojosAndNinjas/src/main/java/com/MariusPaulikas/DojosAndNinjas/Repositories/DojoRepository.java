package com.MariusPaulikas.DojosAndNinjas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.DojosAndNinjas.Models.Dojo;

@Repository
	public interface DojoRepository extends CrudRepository<Dojo, Long> {
	
	List<Dojo> findAll();
//	List<Dojo> findByDojoContaining(String search);

}
