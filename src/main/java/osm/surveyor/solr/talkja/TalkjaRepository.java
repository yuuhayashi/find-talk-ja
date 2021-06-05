package osm.surveyor.solr.talkja;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.springframework.stereotype.Repository;

@Repository
public class TalkjaRepository {
	public List<Summary> findAll(String key) {
		List<Summary> list = new ArrayList<>();
		try {
			// localhostのSolrに繋ぐ
	    	HttpSolrServer server = new HttpSolrServer("http://surveyor.mydns.jp/solr/talkja");

			// 10秒でタイムアウトに設定
			server.setConnectionTimeout(10000);

			// 3回までリトライ
			server.setMaxRetries(3);

			// 検索してみる
			QueryResponse res = server.query(new SolrQuery(key));
			for(SolrDocument document : res.getResults()) {
				Summary summary = new Summary();
				summary.setPath((String)document.get("path"));
				summary.setDir((String)document.get("dir"));
				summary.setUrl((String)document.get("url"));
				summary.setTitle((String)document.get("title"));
				summary.setId((String)document.get("id"));
				summary.setName((String)document.get("name"));
				list.add(summary);
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return list;
	}
}
