package com.MariusPaulikas.DojosAndNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.DojosAndNinjas.Models.Ninja;
import com.MariusPaulikas.DojosAndNinjas.Repositories.NinjaRepository;

@Service
public class NinjaService {

		private final NinjaRepository ninjarepository;
		
		public NinjaService (NinjaRepository ninjarepository) {
			this.ninjarepository = ninjarepository;
		}
		
		public List<Ninja> allNinjas() {
			return ninjarepository.findAll();
		}
		
		
		public Ninja createNinja (Ninja n) {
			return ninjarepository.save(n);
		}
		
		
		public Ninja findNinja(Long id) {
			Optional<Ninja> optionalNinja = ninjarepository.findById(id);
			if(optionalNinja.isPresent()) {
				return optionalNinja.get();
			} else {
				return null;
			}
			
			
		}
		
		
}
