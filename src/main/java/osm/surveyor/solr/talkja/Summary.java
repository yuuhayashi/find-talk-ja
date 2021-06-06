package osm.surveyor.solr.talkja;

import java.util.List;

import lombok.Data;

@Data
public class Summary {
	private String path;
	private String dir;
	private String url;
	private String title;
	private String id;
	private String name;
	private String date;
	private List<String> contents;
}
