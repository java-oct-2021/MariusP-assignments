package com.MariusPaulikas.Authentication.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.MariusPaulikas.Authentication.Models.User;
import com.MariusPaulikas.Authentication.Repositories.UserRepository;


@Component
public class UserValidator implements Validator {

	
@Autowired
private UserRepository userRepository;
	
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        } 
        
        if(userRepository.existsByEmail(user.getEmail())) {
        	errors.rejectValue("email", "emailerror");
        }
    }
    
    
}