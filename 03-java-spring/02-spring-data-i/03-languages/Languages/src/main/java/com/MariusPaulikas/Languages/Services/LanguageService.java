package com.MariusPaulikas.Languages.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.Languages.Models.Language;
import com.MariusPaulikas.Languages.Repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	public Language CreateLanguage (Language l) {
		return languageRepository.save(l);
	}
	
	
	public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	
	
	public Language UpdateLanguage(Long id, String name, String creator, String version) {
		Language language = findLanguage(id);
		language.setName(name);
		language.setCreator(creator);
		language.setVersion(version);
		return languageRepository.save(language);
	}
	
	
	public void deleteLanguage(Long id) {
	    	languageRepository.deleteById(id);
	    }

	
}
