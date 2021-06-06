package osm.surveyor.solr.talkja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.springframework.stereotype.Repository;

@Repository
public class TalkjaRepository {
	@SuppressWarnings("unchecked")
	public List<Summary> findAll(String key) {
		List<Summary> list = new ArrayList<>();
		try {
			// localhostのSolrに繋ぐ
	    	SolrClient client = new HttpSolrClient.Builder("http://surveyor.mydns.jp/solr/talkja").build();
	    	SolrQuery query = new SolrQuery();
	    	query.setQuery(key);
	    	
			// 検索してみる
			QueryResponse res = client.query(query);
			for(SolrDocument document : res.getResults()) {
				Summary summary = new Summary();
				summary.setPath((String)document.get("path"));
				summary.setDir((String)document.get("dir"));
				summary.setUrl((String)document.get("url"));
				summary.setTitle((String)document.get("title"));
				summary.setId((String)document.get("id"));
				summary.setName((String)document.get("name"));
				summary.setDate((String)document.get("date"));
				
				List<String> contents = (List<String>)document.get("contents");
				List<String> conts9 = new ArrayList<>();
				if (contents != null) {
					int i = 0;
					for (String str : contents) {
						i++;
						if (i < 10) {
							conts9.add(str);
						}
					}
					summary.setContents(conts9);
				}

				list.add(summary);
			}
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
