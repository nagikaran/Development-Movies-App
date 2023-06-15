package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ratings")
public class Ratings {
	@Id
	private String tconst;
	private Double averagerating;
	private Integer numVotes;
	
	 

}
