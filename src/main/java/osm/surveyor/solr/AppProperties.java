package osm.surveyor.solr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
	
	@Value("${app.solrurl}")
	private String solrurl;
	
	public String getSolrurl() {
		return solrurl;
	}
}
