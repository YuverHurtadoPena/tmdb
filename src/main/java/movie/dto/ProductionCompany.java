package movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionCompany {
	private Integer id;
	private String logo_path;
	private String name;
	private String origin_country;

}
