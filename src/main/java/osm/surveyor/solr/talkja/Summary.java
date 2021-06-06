package osm.surveyor.solr.talkja;

import java.util.ArrayList;
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
	private String date = new String();
	private List<String> contents = new ArrayList<String>();
}
