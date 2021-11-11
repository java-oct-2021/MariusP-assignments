package com.MariusPaulikas.BeltReview.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name="events")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Size (min = 2, message = "The event name must be at least 2 characters in length.")
	private String eventname;
	
	@NonNull
	private Date eventdate;
	
	@NonNull
	@Size (min = 2, message = "Your location must be at least 2 characters in length.")
	private String eventcity;
	
	@NonNull
	@Size (min = 2, message = "The state location must be 2 characters in length.")
	private String eventstate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	

//	@ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//    	name = "persons_events",
//    	joinColumns = @JoinColumn(name = "event_id"),
//    	inverseJoinColumns = @JoinColumn(name = "person_id")
//    	)
//	private List<Person> persons;
//	
	
	public Event () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventcity() {
		return eventcity;
	}

	public void setEventcity(String eventcity) {
		this.eventcity = eventcity;
	}

	public String getEventstate() {
		return eventstate;
	}

	public void setEventstate(String eventstate) {
		this.eventstate = eventstate;
	}

//	public List<Person> getPeople() {
//		return persons;
//	}
//
//	public void setPeople(List<Person> persons) {
//		this.persons = persons;
//	}
	
	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

//	public List<Person> getPersons() {
//		return persons;
//	}
//
//	public void setPersons(List<Person> persons) {
//		this.persons = persons;
//	}

	public Date getEventdate() {
		return eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
