package movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import movie.dto.FavoriteMovieLiteDto;
import movie.entity.FavoriteMovieEntity;
import movie.service.IFavoriteMovieService;
import movie.service.IMovieService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class Controller {
	@Autowired
	private IMovieService movieService;
	
	@Autowired
	private IFavoriteMovieService favoriteMovieService;

	@Operation(summary="Busca una pelicula en el api tmbd a traves del id")
	@GetMapping("getMovieById/{movieId}")
	public ResponseEntity<?> getMovieById(@PathVariable("movieId") Integer movieId) {
		return movieService.getMovieById(movieId);
	}

	@Operation(summary="muestra las pelicula en el api tmbd ")
	@GetMapping("getMovies")
	public ResponseEntity<?> getMovies() {
		return movieService.getMovies();
	}
	
	
	@Operation(summary="Agrega una pelicula como favorita ")
	@PostMapping("postFavoriteMovie")
	public ResponseEntity<?> postFavoriteMovie(@RequestBody FavoriteMovieLiteDto dto) {
		return favoriteMovieService.saveFavoriteMovie(dto);
	}
	
	@Operation(summary="muestra las pelicula registradas como favoritas ")
	@GetMapping("getListFavoriteMovies")
	public List<FavoriteMovieEntity> getListFavoriteMovies() {
		return favoriteMovieService.getListFavoriteMovies();
	}
	
	@Operation(summary="Borra una pelicula registrada como favorita ")
	@DeleteMapping("deleteMovieByMovieId/{movieId}")
	public ResponseEntity<?> deleteMovieByMovieId(@PathVariable("movieId") Integer movieId) {
		return favoriteMovieService.deleteMovieByIdMovie(movieId);
	}
	
	@Operation(summary="Actualiza una pelicula ")
	@PutMapping("putFavoriteMovie")
	public ResponseEntity<?> putFavoriteMovie(@RequestBody FavoriteMovieLiteDto dto) {
		return favoriteMovieService.updateMovieByIdMovie(dto);
	}

}
