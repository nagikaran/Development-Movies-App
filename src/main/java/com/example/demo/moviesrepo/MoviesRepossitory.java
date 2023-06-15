package com.example.demo.moviesrepo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Movies;

@Repository
public interface MoviesRepossitory extends JpaRepository<Movies, String> {
	

	@Query(value = "SELECT * FROM movies WHERE run_time_minutes = (SELECT MAX(run_time_minutes) FROM movies) " +
            "UNION " +
            "SELECT * FROM movies ORDER BY run_time_minutes DESC LIMIT 10", nativeQuery = true)
    List<Movies> findTop10MoviesAndMovieWithLongestDuration();
	
	
	List<Movies> findByRatingsAverageratingGreaterThanOrderByRatingsAverageratingAsc(Double averageRating);

	@Modifying
	@Query(value = "UPDATE movies SET run_time_minutes = CASE WHEN genres = 'Documentary' THEN run_time_minutes + 15 WHEN genres = 'Animation' THEN run_time_minutes + 30 ELSE run_time_minutes + 2 END", nativeQuery = true)
	int updateRunTimeOfMoviesAsPerGenere();
	
	
	/*Sub total of no of  votes as per gener*/
	
	@Query(value = "SELECT a.genres, SUM(b.num_votes) AS total_votes FROM movies AS a JOIN ratings AS b ON a.tconst = b.tconst GROUP BY a.genres;\r\n"
			+ "",nativeQuery = true)
    List<Map<String, String>> getMovieGenreSubtotals();
	


	    
}
