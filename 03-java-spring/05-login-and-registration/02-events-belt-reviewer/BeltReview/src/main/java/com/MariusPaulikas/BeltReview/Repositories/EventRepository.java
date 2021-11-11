package com.MariusPaulikas.BeltReview.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.BeltReview.Models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	List<Event> findAll();
	
//	List<Event> findByEventstate (String eventstate);

}
