package com.MariusPaulikas.DojosAndNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.DojosAndNinjas.Models.Dojo;
import com.MariusPaulikas.DojosAndNinjas.Repositories.DojoRepository;


@Service
public class DojoService {
	
	private final DojoRepository dojorepository;

	public DojoService (DojoRepository dojorepository) {
		this.dojorepository = dojorepository;
	}
	
	public List<Dojo> allDojos() {
		return dojorepository.findAll();
	}
	
	
	public Dojo createDojo (Dojo d) {
		return dojorepository.save(d);
	}
	
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojorepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
		
	}
	
}
