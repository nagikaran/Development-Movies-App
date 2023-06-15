package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movies {
	@Id
	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String runTimeMinutes;
	private String genres;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "tconst")
	private Ratings ratings;

	   
}
