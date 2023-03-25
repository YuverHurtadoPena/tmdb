package movie.service;

import org.springframework.http.ResponseEntity;

import movie.dto.MovieDetail;

/**
 * define las funcionalidades para interatuar con el api tmdb
 * 
 * @author yuver
 *
 */
public interface IMovieService {
	/**
	 * Busca en el api tmdb una pelicula a traves de id
	 * 
	 * @param movieId
	 * @return
	 */
	public ResponseEntity<?> getMovieById(Integer movieId);

	/**
	 * Obtiene o muestra las peliculas del api tmdb
	 * 
	 * @return
	 */
	public ResponseEntity<?> getMovies(int numberPage);

}
