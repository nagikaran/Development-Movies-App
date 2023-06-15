package com.example.demo.moviesserviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dto.MoviesDto;
import com.example.demo.entity.Movies;
import com.example.demo.moviesrepo.MoviesRepossitory;
import com.example.demo.moviesserviceinterface.MoviesServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class MoviesServiceImp implements MoviesServiceInterface {
	@Autowired
	MoviesRepossitory moviesRepository;
	
	

	@Override
	public List<MoviesDto> getTopTenMoviesWithTheLongestDuration() {
		List<Movies> findTop10MoviesAndMovieWithLongestDuration = moviesRepository.findTop10MoviesAndMovieWithLongestDuration();
		
		List<MoviesDto> collectionsOfTenMovies = findTop10MoviesAndMovieWithLongestDuration.stream().map((entity)->entityToMoviesClassDto(entity)).collect(Collectors.toList());
		
		
		// TODO Auto-generated method stub
		return  collectionsOfTenMovies;
	}
	
	@Override
	public MoviesDto addnewMovies(MoviesDto moviesDto) {
		// TODO Auto-generated method stub
		Movies dtoToMoviesClass = dtoToMoviesClass(moviesDto);
		Movies save = moviesRepository.save(dtoToMoviesClass);
		 MoviesDto entityToMoviesClassDto = entityToMoviesClassDto(save);
	
		
		return entityToMoviesClassDto;
	}
	/*Method to get the movies whose ratings is above 6*/
	
	public List<MoviesDto> getTheMoviesRatingMoreThenSix(){
		List<Movies> averageratingOfMoviesGreaterThanSix =moviesRepository.findByRatingsAverageratingGreaterThanOrderByRatingsAverageratingAsc(6.0);;
				
		for(Movies mSix:averageratingOfMoviesGreaterThanSix) {
			mSix.getRatings().getAveragerating();
		}
		List<MoviesDto> moviesWithAverageRatingMoreThenSix = averageratingOfMoviesGreaterThanSix.stream().map((entity)->entityToMoviesClassDto(entity)).collect(Collectors.toList());
		for(MoviesDto mSix:moviesWithAverageRatingMoreThenSix) {
			System.out.println(mSix.getRatings().getAveragerating());
		}
		return moviesWithAverageRatingMoreThenSix;
	}
	@Override
	@Transactional
	public int updateRunTimeOfMoviesAsPerGenere() {
		// TODO Auto-generated method stub
		 int updateRunTimeOfMoviesAsPerGenere = moviesRepository.updateRunTimeOfMoviesAsPerGenere();
		return updateRunTimeOfMoviesAsPerGenere;
	}
	
	/*
	 * public List<Map<String, Integer>> getTheSubToTalOfNumOfVotes() { //
	 * TODO Auto-generated method stub List<Map<String, Integer>>
	 * movieGenreSubtotals = moviesRepository.getMovieGenreSubtotals();
	 * List<Map<String, Integer>> generSubTotal = new ArrayList<>();
	 * 
	 * for (Map<String, Integer> moviesData : movieGenreSubtotals) { String genre =
	 * String.valueOf(moviesData.get("genres")); Integer totalVotes =
	 * moviesData.get("total_votes");
	 * 
	 * Map<String, Object> genreSubtotal = new HashMap<>();
	 * genreSubtotal.put("genres", genre); genreSubtotal.put("total_votes",
	 * totalVotes);
	 * 
	 * generSubTotal.add(genreSubtotal); }
	 * 
	 * return generSubTotal; }
	 */
	@Override 
	public List<Map<String, String>> getTheSubToTalOfNumOfVotes() {
	    List<Map<String, String>> movieGenreSubtotals = moviesRepository.getMovieGenreSubtotals();
	    List<Map<String, String>> generSubTotal = new ArrayList<>();

	    for (Map<String, String> moviesData : movieGenreSubtotals) {
	        String genre = moviesData.get("genres");
	        String totalVotes = String.valueOf(moviesData.get("total_votes"));

	        Map<String, String> genreSubtotal = new HashMap<>();
	        genreSubtotal.put("genres", genre);
	        genreSubtotal.put("total_votes", totalVotes);

	        generSubTotal.add(genreSubtotal);
	    }

	    return generSubTotal;
	}
	
	/*create the methods to create the dto to the entity and the entity to the dto*/
	private Movies dtoToMoviesClass(MoviesDto dto) {
		ModelMapper mm = new ModelMapper();
		return mm.map(dto, Movies.class);
	}

	private MoviesDto entityToMoviesClassDto(Movies entity) {
		ModelMapper mm = new ModelMapper();
		return mm.map(entity, MoviesDto.class);
	}

	
	


}
