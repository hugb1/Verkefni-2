package search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Vilhjalmur Jonsson vij7@hi.is
 * 
 * Byrjunarcontroller sem styrir hvad er gert thegar notandi eda vidmot
 * setur inn skipun 
 */

@Controller
@RequestMapping("/demo") //Request Mapping er gerd fyrir klasann til ad slidinn byrji a /demo fyrir allar skipanir.
public class SearchController {
	
	
	
	// Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/search"
	@RequestMapping("/search")
	public String searchPage() {
		return "demo/search"; //Skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/search.jsp
	}
	
}
