package com.MariusPaulikas.DojosAndNinjas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.DojosAndNinjas.Models.Ninja;

@Repository
	public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
//	List<Ninja> findByDescriptionContaining(String search);

}
