package com.MariusPaulikas.Languages.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Languages.Models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

		List<Language> findAll();
		
}
