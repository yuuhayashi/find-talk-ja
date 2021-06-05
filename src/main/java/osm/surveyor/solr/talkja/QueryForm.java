package osm.surveyor.solr.talkja;

import javax.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class QueryForm {
	
	@NotBlank
	private String query;
}
