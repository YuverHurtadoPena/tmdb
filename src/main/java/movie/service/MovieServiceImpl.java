package movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import movie.dao.ImovieDao;
import movie.dto.Message;
import movie.dto.MovieDetail;
import movie.dto.Result;

/**
 * implementa la interfaz IMovieService
 * 
 * @author yuver
 *
 */
@Service
public class MovieServiceImpl implements IMovieService {

	@Value("${m.messaje}")
	private String message;

	@Autowired
	private ImovieDao movieDao;

	@Override
	public ResponseEntity<?> getMovieById(Integer movieId) {

		ResponseEntity<MovieDetail> movieDetail = movieDao.getMovieById(movieId);

		if (movieDetail != null) {
			return new ResponseEntity(movieDetail.getBody(), HttpStatus.OK);
		} else {
			return new ResponseEntity(new Message(message), HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<?> getMovies() {
		ResponseEntity<Result> result = movieDao.getMovies();

		if (result != null) {
			return new ResponseEntity(result.getBody(), HttpStatus.OK);

		} else {
			return new ResponseEntity(new Message("Sin peliculas"), HttpStatus.NOT_FOUND);

		}

	}

}
