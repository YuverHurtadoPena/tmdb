package movie.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collection {
	private Integer id;
	private String name;
	private String poster_path;
	private String backdrop_path;

	
}
