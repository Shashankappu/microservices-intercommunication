package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		UserRating ratings = restTemplate.getForObject( "http://localhost:8083/ratingsdata/users/"+userId,UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {
			//For Each MovieId, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			//put them all together
			return new CatalogItem(movie.getName(), "kannadaMovie", rating.getRating());
		}).collect(Collectors.toList());

	}
}



//WEBCLIENT 
/*
 * Movie movie = webClientBuilder.build() .get()
 * .uri("http://localhost:8082/movies/" + rating.getMovieId()) .retrieve()
 * .bodyToMono(Movie.class) .block();
 */
