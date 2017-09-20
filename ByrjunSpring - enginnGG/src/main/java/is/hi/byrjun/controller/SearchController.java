package is.hi.byrjun.controller;

import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.repository.BanquetRepository;
import is.hi.byrjun.repository.BanquetRepositoryImp;
import is.hi.byrjun.services.SearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
* Tekur við skipunum frá vefviðmóti til að leita af veislusölum og birta 
* leitarniðurstöðurnar.
* 
*/

@Controller
@RequestMapping("/demo") //Request Mapping er gerd fyrir klasann til ad slidinn byrji a /demo fyrir allar skipanir.
public class SearchController {
	
	// Tenging yfir í þjónustu klasa fyrir Search aðgerðina
	@Autowired
	SearchService searchService;
	
	//Tenging yfir í safn af veislusölum
	@Autowired
	BanquetRepositoryImp banquetRep;
		
	// Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/search"
	@RequestMapping("/search")
	public String searchPage() {
		return "demo/search"; //Skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/search.jsp
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@RequestParam(value = "myradio", required = false) String type, ModelMap model) {
		List<Banquet> list = banquetRep.getAll();

		model.addAttribute("salir", list);
		return "demo/synaSali";
	}
	
}
