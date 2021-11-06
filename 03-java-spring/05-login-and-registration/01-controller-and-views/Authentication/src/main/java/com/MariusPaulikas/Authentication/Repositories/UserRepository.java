package com.MariusPaulikas.Authentication.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Authentication.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
    User findByEmail(String email);
    boolean existsByEmail(String email);
}