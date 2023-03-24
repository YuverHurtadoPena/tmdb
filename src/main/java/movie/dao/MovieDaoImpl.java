package movie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import movie.config.RestTempleteConfig;
import movie.dto.MovieDetail;
import movie.dto.Result;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
/**
 * implementa la interfaz  ImovieDao
 * @author yuver
 *
 */
@Service
public class MovieDaoImpl implements ImovieDao {
	@Value("${tmdb.base.url}")
	private String urlBase;

	@Value("${tmdb.api.key}")
	private String apiKey;


	private final String MOVIE = "movie";
	private final String typeQueryDiscover = "discover/";

	@Autowired
	private RestTempleteConfig restTemplete;

	@Override
	public ResponseEntity<MovieDetail> getMovieById(Integer movieId) {
		String url = urlBase + MOVIE + "/" + movieId.toString() + "=" + apiKey;
		ResponseEntity<MovieDetail> responseEntity;
		try {

			responseEntity = restTemplete.restTemplate().getForEntity(url, MovieDetail.class);
			return responseEntity;

		} catch (HttpClientErrorException e) {
			return null;

		}

	}

	@Override
	public ResponseEntity<Result> getMovies() {
		String url = urlBase + typeQueryDiscover + MOVIE + apiKey;
		ResponseEntity<Result> responseEntity;
		try {

			responseEntity = restTemplete.restTemplate().getForEntity(url, Result.class);
			return responseEntity;

		} catch (HttpClientErrorException e) {
			return null;

		}
	}

}
