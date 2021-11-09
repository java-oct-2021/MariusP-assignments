package com.MariusPaulikas.DojoOverflow.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.DojoOverflow.Models.Answers;
import com.MariusPaulikas.DojoOverflow.Models.Tags;
import com.MariusPaulikas.DojoOverflow.Repositories.AnswerRepository;
import com.MariusPaulikas.DojoOverflow.Repositories.TagRepository;

@Service
public class TagService {

private final TagRepository tagrepository;
	
	public TagService (TagRepository tagrepository) {
		this.tagrepository = tagrepository;
	}

	public List<Tags> allTags()  {
		return tagrepository.findAll();
	
	}
	
	public Tags createTag (Tags t) {
		return tagrepository.save(t);
	}
	
	public Tags findTags(Long id) {
		Optional<Tags> optionalTags = tagrepository.findById(id);
		if(optionalTags.isPresent()) {
			return optionalTags.get();
		} else {
			return null;
		}
		
	}
	
	public boolean dupeTags(String subject) {
		return tagrepository.existsBySubject(subject);
	}
	
	
	public Tags findBySubject(String subject) {
		return tagrepository.findBySubject(subject);
	}
	
	
}
