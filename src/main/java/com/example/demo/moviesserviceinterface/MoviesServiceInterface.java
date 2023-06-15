package com.example.demo.moviesserviceinterface;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.MoviesDto;

public interface MoviesServiceInterface {
	
public List<MoviesDto> getTopTenMoviesWithTheLongestDuration();

public MoviesDto addnewMovies(MoviesDto moviesDto);	

public List<MoviesDto> getTheMoviesRatingMoreThenSix();

public int updateRunTimeOfMoviesAsPerGenere();

public List<Map<String,String>> getTheSubToTalOfNumOfVotes();
	
	

}
