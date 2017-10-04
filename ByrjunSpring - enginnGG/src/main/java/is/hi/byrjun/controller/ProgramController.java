package is.hi.byrjun.controller;

import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.SportVenues;
import is.hi.byrjun.repository.BanquetRepository;
import is.hi.byrjun.repository.BanquetRepositoryImp;
import is.hi.byrjun.repository.SportVenuesRepositoryImp;
import is.hi.byrjun.services.SearchService;

import java.util.ArrayList;
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
public class ProgramController {

	// Tenging yfir í þjónustu klasa fyrir Search aðgerðina
	@Autowired
	SearchService searchService;

	//Tenging yfir í safn af veislusölum
	@Autowired
	BanquetRepositoryImp banquetRep;

	//Tenging yfir í safn af íþróttahúsum
	@Autowired
	SportVenuesRepositoryImp sportsRep;

	// Þar sem klasinn hefur slóðina "/demo", er þessi slóð "/demo/search"
	@RequestMapping("/search")
	public String searchPage() {
		return "demo/search"; //Skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/search.jsp
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@RequestParam(value = "myradio", required = true) int chosen,
			@RequestParam(value = "loc", required = true) int locNr,
			@RequestParam(value = "cap", required = false) int capNr, Model model) {
		if (chosen == 1) {
			List<Banquet> all = banquetRep.getAll();
			String location;
			int maxcap;

			switch(locNr) {
			case 1 :
				location = "Reykjavík";
				break;
			case 2:
				location = "Hafnarfjörður";
				break;
			case 3:
				location = "Garðabær";
				break;
			case 4:
				location = "Kópavogur";
				break;
			default :
				throw new IllegalArgumentException("Invalid Location");
			}

			switch(capNr) {
			case 1 :
				maxcap = 50;
				break;
			case 2 :
				maxcap = 100;
				break;
			case 3 :
				maxcap = 150;
				break;
			case 4 :
				maxcap = 200;
				break;
			default :
				throw new IllegalArgumentException("Invalid Capacity Number");
			}

			List<Banquet> list = searchService.searchBanquet(all, location, maxcap);

			model.addAttribute("veislusalir", list);
			return "demo/synaSali";
		} else {
			List<SportVenues> all = sportsRep.getAll();
			String location;

			switch(locNr) {
			case 1 :
				location = "Reykjavík";
				break;
			case 2:
				location = "Hafnarfjörður";
				break;
			case 3:
				location = "Garðabær";
				break;
			case 4:
				location = "Kópavogur";
				break;
			default :
				throw new IllegalArgumentException("Invalid Location");
			}

			List<SportVenues> list = searchService.searchSportVenues(all, location);

			model.addAttribute("sportsalir", list);
			return "demo/synaSport";
		}
	}

	@RequestMapping(value = "/salir", method = RequestMethod.POST)
	public String birtaSali(Model model) {
		ArrayList<Banquet> list;
		list = (ArrayList<Banquet>) banquetRep.getAll();
		model.addAttribute("veislusalir", list);

		return "demo/synaSali";
	}
	
	
	@RequestMapping(value = "/bokaSal", method = RequestMethod.POST)
	public String bokaSal(@RequestParam(value = "bokunNr")int nr, Model model) {
		Banquet salur = searchService.searchBanquetById(banquetRep.getAll(), nr);
		model.addAttribute("Banquet", salur);
		return "demo/bokunStadfest";
	}
	
	@RequestMapping(value = "/bokaSport", method = RequestMethod.POST)
	public String bokaSport(@RequestParam(value = "bokunNr")int nr, Model model) {
		SportVenues sport = searchService.searchSportVenuesById(sportsRep.getAll(), nr);
		model.addAttribute("SportVenues", sport);
		return "demo/bokunStadfest";
	}
}
