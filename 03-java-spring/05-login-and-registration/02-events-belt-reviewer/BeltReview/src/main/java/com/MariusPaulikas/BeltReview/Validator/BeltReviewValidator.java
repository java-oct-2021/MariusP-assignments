package com.MariusPaulikas.BeltReview.Validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.MariusPaulikas.BeltReview.Models.Person;
import com.MariusPaulikas.BeltReview.Repositories.PersonRepository;

@Component
public class BeltReviewValidator implements Validator {
	
	
@Autowired 
private PersonRepository personrepository;

public boolean supports(Class<?> clazz) {
    return Person.class.equals(clazz);
}



// 2
@Override
public void validate(Object target, Errors errors) {
    Person person = (Person) target;
    
    if (!person.getConfirmpassword().equals(person.getPassword())) {
        // 3
        errors.rejectValue("confirmpassword", "Match", "Your Password and Password Confirmation must match.");
    } 
    
    if(personrepository.existsByEmail(person.getEmail())) {
    	errors.rejectValue("email", "emailerror", "This email already exists.  Please enter a different email.");
    }
}


}
