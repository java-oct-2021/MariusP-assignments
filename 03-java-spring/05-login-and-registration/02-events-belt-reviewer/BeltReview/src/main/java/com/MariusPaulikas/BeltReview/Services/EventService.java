package com.MariusPaulikas.BeltReview.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.BeltReview.Models.Event;
import com.MariusPaulikas.BeltReview.Models.Person;
import com.MariusPaulikas.BeltReview.Repositories.EventRepository;


@Service
public class EventService {
	
	private final EventRepository eventrepository;
	
	public EventService(EventRepository eventrepository) {
        this.eventrepository = eventrepository;
    }

	public List<Event> allEvents()  {
		return eventrepository.findAll();
	
	}
	
	public Event createEvent(Event e) {
		System.out.println("come on now don't give me a hard time");
		return eventrepository.save(e);
	}
	
	public void deleteEvent (Long id) {
		eventrepository.deleteById(id);
	}
	
	public Event getOneEvent (Long id) {
		return eventrepository.findById(id).orElse(null);
	}
	
//	public List<Event> stateEvent (String state) {
//		return eventrepository.findByEventstate(state).orElse(null);
//	}
//	
	
	public Event updateEvent (Long id, String name, Date date, String city, String state) {
		Event event = getOneEvent(id);
		event.setEventname(name);
		event.setEventdate(date);
		event.setEventcity(city);
		event.setEventstate(state);
		return eventrepository.save(event);
	}
	
	
	public Event findEvents(Long id) {
		Optional<Event> optionalEvents = eventrepository.findById(id);
		if(optionalEvents.isPresent()) {
			return optionalEvents.get();
		} else {
			return null;
		}
		
	}
	
//	
//	public Event AddPerson (Person p, Event e) {
//		List<Person> mypersons = e.getPeople();
//		mypersons.add(p);
//		return eventrepository.save(e);
//		
//		
//	}
//	
	
	
	
}
