package osm.surveyor.solr.talkja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalkjaService {
	@Autowired
	private TalkjaRepository talkjaRepository;
	
	public List<Summary> findAll(String key) {
		return talkjaRepository.findAll(key);
	}
}
