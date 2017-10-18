package is.hi.byrjun.controller;

import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.SportVenues;
import is.hi.byrjun.services.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ChangeController {

	// Tenging yfir í þjónustu klasa fyrir Search aðgerðina
	@Autowired
	SearchService searchService;
	
	@RequestMapping(value = "/innskra")
	public String skraning() {
		return "demo/authenticate";
	}
	
	@RequestMapping(value = "/verify")
	public String stadfesta(@RequestParam(value = "myradio", required = true)int chosen,
							@RequestParam(value = "id", required = true)int id,
							@RequestParam(value = "key", required = true)String key, Model model) {
		if (chosen == 1) {
			Banquet result = searchService.verifyBanquet(id, key);
			model.addAttribute("banquet", result);
			return "demo/breytaSal";
		} else {
			SportVenues result = searchService.verifySport(id, key);
			model.addAttribute("sportvenue", result);
			return "demo/breytaSport";
		}
	}
	
	@RequestMapping(value = "/eydaSal", method = RequestMethod.POST)
	public String removeBanquet(@RequestParam(value = "id")int id) {
		searchService.removeBanquet(id);
		return "demo/salEytt";
	}
	
	@RequestMapping(value = "/eydaSport", method = RequestMethod.POST)
	public String removeSport(@RequestParam(value = "id")int id) {
		searchService.removeSport(id);
		return "demo/salEytt";
	}
	
	@RequestMapping(value = "/breytaSal", method = RequestMethod.POST)
	public String editBanquet(@RequestParam(value = "id")int id,
							  @RequestParam(value = "nafn")String nafn,
							  @RequestParam(value = "location")int locNr,
							  @RequestParam(value = "streetAddrs")String street,
							  @RequestParam(value = "price")int price,
							  @RequestParam(value = "maxppl")int maxppl,
							  @RequestParam(value = "phonenr")int phonenr,
							  @RequestParam(value = "email")String email,
							  @RequestParam(value = "origLoc")String origLoc, Model model) {
		String loc;
		switch(locNr) {
		case 0 :
			loc = origLoc;
		case 1 :
			loc = "Reykjavík";
			break;
		case 2:
			loc = "Hafnarfjörður";
			break;
		case 3:
			loc = "Garðabær";
			break;
		case 4:
			loc = "Kópavogur";
			break;
		default :
			throw new IllegalArgumentException("Invalid Location");
		}
		searchService.editBanquet(id, nafn, loc, street, price, maxppl, phonenr, email);
		return "demo/salBreytt";
	}
	
	@RequestMapping(value = "/breytaSport", method = RequestMethod.POST)
	public String editSport(@RequestParam(value = "id")int id,
							@RequestParam(value = "nafn")String nafn,
							@RequestParam(value = "location")int locNr,
							@RequestParam(value = "streetAddrs")String street,
							@RequestParam(value = "price")int price,
							@RequestParam(value = "phonenr")int phonenr,
							@RequestParam(value = "email")String email,
							@RequestParam(value = "origLoc")String origLoc, Model model) {
		String loc;
		switch(locNr) {
		case 0 :
			loc = origLoc;
		case 1 :
			loc = "Reykjavík";
			break;
		case 2:
			loc = "Hafnarfjörður";
			break;
		case 3:
			loc = "Garðabær";
			break;
		case 4:
			loc = "Kópavogur";
			break;
		default :
			throw new IllegalArgumentException("Invalid Location");
		}
		searchService.editSport(id, nafn, loc, street, price, phonenr, email);
		return "demo/salBreytt";
	}
}

