package movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoriteMovieDto {
	private String nameMovie;
	private String observation;
	private Integer idMovie;
	private String Overview;

}
