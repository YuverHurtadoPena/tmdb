package movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import movie.dao.ImovieDao;
import movie.dto.Message;
import movie.dto.MovieDetail;
import movie.dto.MovieDetailFree;
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
	public ResponseEntity<?> getMovies(int numberPage) {
		int limitInit = (numberPage - 1) * 10;
		int limitEnd = numberPage * 10;
		ResponseEntity<Result> result = movieDao.getMovies();
		List<MovieDetailFree> lista = new ArrayList<>();

		if (result != null) {
			System.out.println(21 % limitEnd);

			if (result.getBody().getResults().size() / limitEnd > 0) {
				for (int i = limitInit; i < limitEnd; i++) {

					lista.add(result.getBody().getResults().get(i));
				}
			} else if (result.getBody().getResults().size() / limitEnd > 0
					&& result.getBody().getResults().size() % limitEnd > 0) {
				for (int i = limitInit; i < result.getBody().getResults().size(); i++) {

					lista.add(result.getBody().getResults().get(i));
				}

			}

			return new ResponseEntity(lista, HttpStatus.OK);

		} else {
			return new ResponseEntity(new Message("Sin peliculas"), HttpStatus.NOT_FOUND);

		}

	}

}
