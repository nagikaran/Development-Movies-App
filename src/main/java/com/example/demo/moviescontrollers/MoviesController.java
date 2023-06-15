package com.example.demo.moviescontrollers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constants.ErrorMessagesForMovies;
import com.example.demo.constants.SuccessMessagesForMovies;

import com.example.demo.constants.UrlsPaths;
import com.example.demo.dto.MoviesDto;
import com.example.demo.moviesserviceinterface.MoviesServiceInterface;


@Controller
@RequestMapping(value = UrlsPaths.MOVIES_CLASS_URL)
public class MoviesController {
	
	
	@Autowired
	MoviesServiceInterface moviesServiceInterface;
	
	
	/*Method to get the top 10 records with the highest duration*/
	@GetMapping(value = UrlsPaths.GET_THE_TOP_TEN_MOVIES_WITH_LONGEST_DURATION)
	public ResponseEntity<List<Map<String, String>>> getMoviesWithTheLongestDuration(){
		List<MoviesDto> topTenMoviesWithTheLongestDuration = moviesServiceInterface.getTopTenMoviesWithTheLongestDuration();
		List<Map<String, String>> moviesSpecificData = new ArrayList<>();
		for (MoviesDto moviesDTO : topTenMoviesWithTheLongestDuration) {
			Map<String, String> movieData = new HashMap<>();
			if (moviesDTO.getTconst() != null) {
				movieData.put("tconst", moviesDTO.getTconst());
			}
			if (moviesDTO.getPrimaryTitle() != null) {
				movieData.put("primaryTitle", moviesDTO.getPrimaryTitle());
			}
			if (moviesDTO.getRunTimeMinutes() != null) {
				movieData.put("runtimeMinutes", moviesDTO.getRunTimeMinutes());
			}
			if (moviesDTO.getGenres() != null) {
				movieData.put("genres", moviesDTO.getGenres());
			}
			moviesSpecificData.add(movieData);
		}
		return ResponseEntity.ok().body(moviesSpecificData);
	}
	
	
	/*method to save the data inside the database*/
	@PostMapping(value = UrlsPaths.ADDITION_OF_NEW_MOVIE)
	public ResponseEntity<String> saveTheMoviesInfo(@RequestBody MoviesDto moviesDto){
		MoviesDto addnewMovies = moviesServiceInterface.addnewMovies(moviesDto);
		return addnewMovies!=null?ResponseEntity.status(HttpStatus.CREATED).body(SuccessMessagesForMovies.MOVIES_ADDED_SUCCESSFULLY):ResponseEntity.status(HttpStatus.CREATED).body(ErrorMessagesForMovies.MOVIES_NOT_SAVED);
	}
	/*API to get the list of the movies whose average Rating is more then 6*/
	@GetMapping(value = UrlsPaths.GET_THE_MOVIES_WHOSE_AVERAGE_RATING_MORE_THEN_SIX)
	public ResponseEntity<List<MoviesDto>> getTheMoviesWhoseAverageRatingIsMoreThenSix(){
		List<MoviesDto> theMoviesRatingMoreThenSix = moviesServiceInterface.getTheMoviesRatingMoreThenSix();
		return ResponseEntity.ok().body(theMoviesRatingMoreThenSix);
		
	}
	
	/*Api to update the data */
	@PutMapping(value = UrlsPaths.UPDATE_THE_MOVIES_RUN_TIME_AS_PER_THE_GENERE_WISE)
	public ResponseEntity<String> updateRunTimeOfMoviesAsPerGenere(){
		 int updateRunTimeOfMoviesAsPerGenere = moviesServiceInterface.updateRunTimeOfMoviesAsPerGenere();
		return updateRunTimeOfMoviesAsPerGenere!=0?ResponseEntity.status(HttpStatus.CREATED).body(SuccessMessagesForMovies.MOVIES_ADDED_SUCCESSFULLY):ResponseEntity.status(HttpStatus.CREATED).body(ErrorMessagesForMovies.MOVIES_NOT_SAVED);
	}
	
	/*to get the list of all movies with subtotal of their numvotes*/
	@GetMapping(value = UrlsPaths.GET_SUB_TOTAL_OF_VOTES_AS_PER_GENER)
	public ResponseEntity<List<Map<String, String>>> getTheSubToTalOfNumOfVotes(){
		List<Map<String, String>> theSubToTalOfNumOfVotes = moviesServiceInterface.getTheSubToTalOfNumOfVotes();
		return ResponseEntity.ok().body(theSubToTalOfNumOfVotes);
	}

}
