package com.example.demo.dto;

import com.example.demo.entity.Ratings;

import lombok.Data;

@Data
public class MoviesDto {
	
	private String tconst;
	private String titleType;
	private String primaryTitle;
	private String runTimeMinutes;
	private String genres;
	private Ratings ratings;


}
