package movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import movie.dao.IFavoriteMovieDao;
import movie.dto.FavoriteMovieLiteDto;
import movie.dto.Message;
import movie.dto.MovieDetail;
import movie.entity.FavoriteMovieEntity;

/**
 * implementa la interfaz IFavoriteMovieService
 * 
 * @author yuver
 *
 */
@Service
public class FavoriteMovieServiceImpl implements IFavoriteMovieService {
	@Autowired
	private IFavoriteMovieDao favoriteMovieDao;

	@Autowired
	private IMovieService movieService;

	@Value("${m.messaje}")
	private String message;

	@Override
	public ResponseEntity<?> saveFavoriteMovie(FavoriteMovieLiteDto dto) {
		ResponseEntity<MovieDetail> movieDetail = (ResponseEntity<MovieDetail>) movieService
				.getMovieById(dto.getIdMovie());
		FavoriteMovieEntity favoriteMovieEntity = new FavoriteMovieEntity();
		System.out.println(movieDetail.getStatusCode().value());

		if (movieDetail.getStatusCode().value() == 200) {
			try {
				favoriteMovieEntity.setIdMovie(movieDetail.getBody().getId());
				favoriteMovieEntity.setNameMovie(movieDetail.getBody().getTitle());
				favoriteMovieEntity.setOverview(movieDetail.getBody().getOverview());
				favoriteMovieEntity.setObservation(dto.getObservation());
				favoriteMovieDao.save(favoriteMovieEntity);

				return new ResponseEntity(new Message("La pelicula se guardo como favorita"), HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity(new Message(message), HttpStatus.NOT_FOUND);

			}
		} else {
			return new ResponseEntity(new Message(message), HttpStatus.NOT_FOUND);

		}
	}

	@Override
	public List<FavoriteMovieEntity> getListFavoriteMovies() {
		System.out.println(favoriteMovieDao.findAll().size());
		List<FavoriteMovieEntity> favoriteMovieEntity = favoriteMovieDao.findAll();
		return favoriteMovieEntity;
	}

	@Override
	public ResponseEntity<?> deleteMovieByIdMovie(Integer idMovie) {
		if (favoriteMovieDao.existsByIdMovie(idMovie)) {
			favoriteMovieDao.deleteFavoriteMovie(idMovie);
			return new ResponseEntity(new Message("Se elimino con exito"), HttpStatus.OK);

		} else {
			return new ResponseEntity(new Message(message), HttpStatus.NOT_FOUND);

		}
	}

	@Override
	public ResponseEntity<?> updateMovieByIdMovie(FavoriteMovieLiteDto dto) {
		if (favoriteMovieDao.existsByIdMovie(dto.getIdMovie())) {
			favoriteMovieDao.updateFavoriteMovie(dto.getObservation(), dto.getIdMovie());
			return new ResponseEntity(new Message("Se actualizo con exito"), HttpStatus.OK);

		} else {
			return new ResponseEntity(new Message(message), HttpStatus.NOT_FOUND);

		}

	}

}
