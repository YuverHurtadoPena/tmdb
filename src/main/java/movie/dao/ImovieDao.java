package movie.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import movie.dto.MovieDetail;
import movie.dto.Result;

/**
 * Cotiene la definicion de todas las funcionalidades que van a interactuar con
 * el api de TMDB
 * 
 * @author yuver
 *
 */
public interface ImovieDao {

	/**
	 * Busca una pelicula por su id y la retorna
	 * 
	 * @param movieId
	 * @return
	 */
	public ResponseEntity<MovieDetail> getMovieById(Integer movieId);

	/**
	 * Retorna una lista con las peliculas
	 * 
	 * @return
	 */
	public ResponseEntity<Result> getMovies();

}
