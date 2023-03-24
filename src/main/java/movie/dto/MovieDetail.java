package movie.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDetail {
	private boolean adult;
	private String backdrop_path;
	private Collection belongs_to_collection;
	private Integer budget;
	private List<Genres> genres;
	private String homepage;
	private Integer id;
	private String imdb_id;
	private String original_language;
	private String original_title;
	private String overview;
	private double popularity;
	private String poster_path;
	private List<ProductionCompany> production_companies;
	private List<Country> production_countries;
	private String release_date;
	private Integer revenue;
	private String runtime;
	private List<Language> spoken_languages;
	private String status;
	private String tagline;
	private String title;
	private boolean video;
	private double vote_average;
	private Integer vote_count;


}
