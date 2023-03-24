package movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import movie.entity.FavoriteMovieEntity;

/**
 * Contiene tiene todas las funcionalidas que vn a interactuar con la tabla
 * favoritas
 * 
 * @author yuver
 *
 */
@Repository
@Transactional
public interface IFavoriteMovieDao extends JpaRepository<FavoriteMovieEntity, Integer> {

	/**
	 * Retorna true si existe la pelicula, de lo contrario devuelve false
	 * 
	 * @param idMovie
	 * @return boolean
	 */
	public boolean existsByIdMovie(Integer idMovie);

	/**
	 * Elimina una pelicula a traves del id_movie
	 * 
	 * @param idMovie
	 */
	@Modifying
	@Query(value = "DELETE FROM favoritas where id_movie=?1", nativeQuery = true)
	public void deleteFavoriteMovie(Integer idMovie);

	/**
	 * actualiza el campo observation a traves del id_movie
	 * 
	 * @param observation
	 * @param idMovie
	 */
	@Modifying
	@Query(value = "UPDATE favoritas set observation=?1 where id_movie=?2", nativeQuery = true)
	public void updateFavoriteMovie(String observation, Integer idMovie);

}
