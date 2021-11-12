package com.MariusPaulikas.BeltReview.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.BeltReview.Models.Discussion;


@Repository
public interface DiscussionRepository extends CrudRepository<Discussion, Long> {

	List<Discussion> findAll();
}
