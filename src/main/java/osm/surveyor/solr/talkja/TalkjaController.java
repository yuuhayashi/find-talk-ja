package osm.surveyor.solr.talkja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TalkjaController {
	
	@Autowired
	private TalkjaService talkjaService;

    /**
     * GET用の処理.
     * http://localhost:8080/talk-ja
     */
    @GetMapping("/talk-ja")
    public String getHome(@ModelAttribute QueryForm queryForm, Model model) {
    	
        // "talkja.html"に画面遷移
    	model.addAttribute("sidebar", "talkja::home_query");
    	model.addAttribute("contents", "talkja::home_contents");
        return "homeLayout";
    }

    /**
     * POST用の処理.
     */
    @PostMapping("/talk-ja")
    public String postRequest(@ModelAttribute @Validated QueryForm queryForm, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
    		return getHome(queryForm, model);
    	}
    	
		// 検索してみる
    	String str = queryForm.getQuery();
    	List<Summary> list = talkjaService.findAll(str);
        model.addAttribute("query", str);
    	
        // 画面から受け取った文字列をModelに登録
        model.addAttribute("list", list);

        // "talkjaResponse.html"に画面遷移
    	model.addAttribute("sidebar", "talkja::home_query");
    	model.addAttribute("contents", "talkjaResponse::home_contents");
        return "homeLayout";
    }
}
