package com.example.demo.constants;

public interface UrlsPaths {
	

	final String APPLICATION_BASE_VERSION="/api/v1";
	
	final String MOVIES_CLASS_URL=APPLICATION_BASE_VERSION+"/moviesClass";
	
	/*to get the List of the first top 10 movies who has the longest duration*/
	final String GET_THE_TOP_TEN_MOVIES_WITH_LONGEST_DURATION="/getTheTopTenMoviesLongestDuratiuon";
	/*Addition of New Movie*/
	final String ADDITION_OF_NEW_MOVIE="/addMovies";
	/*list to get the movies whose average rating is greater then six*/
	final String GET_THE_MOVIES_WHOSE_AVERAGE_RATING_MORE_THEN_SIX="/moviesRatingMoreThenSix";
	/*update the movies as per the genere wise*/
	final String UPDATE_THE_MOVIES_RUN_TIME_AS_PER_THE_GENERE_WISE="/runTimeUpdationAsPerGenere";
	/**/
	final String GET_SUB_TOTAL_OF_VOTES_AS_PER_GENER="/getSumOfVotesAsPerGener";
	

}
