package com.example.demo.ratingsrepositoryinterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ratings;

@Repository
public interface RatingsRepositoryInterface extends JpaRepository<Ratings, String> {
	
	

}
