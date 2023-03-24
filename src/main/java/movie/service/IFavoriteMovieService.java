package movie.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import movie.dto.FavoriteMovieLiteDto;
import movie.entity.FavoriteMovieEntity;

/**
 * Interfaz que define las funcionalidades sobre la gestion de peliculas
 * fovoritas
 * 
 * @author yuver
 *
 */
public interface IFavoriteMovieService {
	/**
	 * Llama el motodo save de la IFavoriteMovieDao para guardar una pelicula como
	 * favorita y retorna un ResponseEntity
	 * 
	 * @param dto
	 * @return
	 */
	public ResponseEntity<?> saveFavoriteMovie(FavoriteMovieLiteDto dto);

	/**
	 * *Llama el motodo findAll de la IFavoriteMovieDao para mostrar las una
	 * peliculas como registradas como favorita y retorna un ResponseEntity
	 * 
	 * @return
	 */
	public List<FavoriteMovieEntity> getListFavoriteMovies();

	/**
	 * Llama el motodo deleteFavoriteMovie de la IFavoriteMovieDao para eliminar
	 * pelicula como favorita y retorna un ResponseEntity
	 * 
	 * @param idMovie
	 * @return
	 */
	public ResponseEntity<?> deleteMovieByIdMovie(Integer idMovie);

	/**
	 * Llama el motodo updateFavoriteMovie de la IFavoriteMovieDao para actualizar
	 * pelicula como favorita y retorna un ResponseEntity
	 * 
	 * @param dto
	 * @return
	 */
	public ResponseEntity<?> updateMovieByIdMovie(FavoriteMovieLiteDto dto);

}
