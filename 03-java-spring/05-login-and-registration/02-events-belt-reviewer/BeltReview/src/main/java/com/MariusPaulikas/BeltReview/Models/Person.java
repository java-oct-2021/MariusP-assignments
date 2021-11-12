package com.MariusPaulikas.BeltReview.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;


@Entity
@Table(name="attendees")

public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	 @Email
	 @Size(min = 2, message = "Your email must be at least 2 characters in length and have a valid address.")
	 private String email;
	
	@NonNull
	@Size (min = 2, message = "Your first name must be at least 2 characters in length.")
	private String firstname;
	
	@NonNull
	@Size (min = 2, message = "Your last name must be at least 2 characters in length.")
	private String lastname;
	
	@NonNull
	@Size (min = 2, message = "Your location must be at least 2 characters in length.")
	private String city;
	
	@NonNull
	@Size (min = 2, message = "The state location must be 2 characters in length.")
	private String state;
	
	@NonNull
	@Size (min = 2, message = "Your password must be at least 2 characters in length.")
	private String password;
	
	@Transient
	private String confirmpassword;

	@OneToMany(mappedBy="person", fetch = FetchType.LAZY)
	private List<Event> createdevent;
	

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "persons_events",
    	joinColumns = @JoinColumn(name = "person_id"),
    	inverseJoinColumns = @JoinColumn(name = "event_id")
    	)
	private List<Event> events;
	
	
	
	
	public Person () {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}

	
	public List<Event> getCreatedevent() {
		return createdevent;
	}


	public void setCreatedevent(List<Event> createdevent) {
		this.createdevent = createdevent;
	}



	
	
	
	
}
