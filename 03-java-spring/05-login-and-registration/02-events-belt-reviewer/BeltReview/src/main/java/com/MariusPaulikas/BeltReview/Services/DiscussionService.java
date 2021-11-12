package com.MariusPaulikas.BeltReview.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.BeltReview.Models.Discussion;
import com.MariusPaulikas.BeltReview.Models.Event;
import com.MariusPaulikas.BeltReview.Repositories.DiscussionRepository;


@Service
public class DiscussionService {

	private final DiscussionRepository discussionrepository;
	
	public DiscussionService(DiscussionRepository discussionrepository) {
        this.discussionrepository = discussionrepository;
    }
	
	
	public List<Discussion> allDiscussions()  {
		return discussionrepository.findAll();
	
	}
	
	
	public Discussion createDiscussion(Discussion d) {
		return discussionrepository.save(d);
	
	}
	
}
