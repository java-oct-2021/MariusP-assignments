package com.MariusPaulikas.BeltReview.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.MariusPaulikas.BeltReview.Models.Event;
import com.MariusPaulikas.BeltReview.Models.Person;
import com.MariusPaulikas.BeltReview.Repositories.PersonRepository;



@Service
public class PersonService {

	private final PersonRepository personrepository;
	
	public PersonService(PersonRepository personrepository) {
        this.personrepository = personrepository;
    }
	
	public List<Person> allPersons()  {
		return personrepository.findAll();
	
	}
	
	public Person createPerson(Person p) {
		return personrepository.save(p);
	}
	
	
	public Person findPersons(Long id) {
		Optional<Person> optionalPersons = personrepository.findById(id);
		if(optionalPersons.isPresent()) {
			return optionalPersons.get();
		} else {
			return null;
		}
		
	}
	
	
//	public Person AddEvent (Event e, Person p) {
//		List<Event> myevents = p.getEvents();
//		myevents.add(e);
//		return personrepository.save(p);
//		
//		
//	}
//	
	
	 // register user and hash their password
    public Person registerUser(Person person) {
        String hashed = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt());
        person.setPassword(hashed);
        return personrepository.save(person);
    }
    
    // find user by email
    public Person findByEmail(String email) {
        return personrepository.findByEmail(email);
    }
    
    // find user by id
    public Person findUserById(Long id) {
    	Optional<Person> p = personrepository.findById(id);
    	
    	if(p.isPresent()) {
            return p.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        Person person = personrepository.findByEmail(email);
        // if we can't find it by email, return false
        if(person == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, person.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
	
	
}
