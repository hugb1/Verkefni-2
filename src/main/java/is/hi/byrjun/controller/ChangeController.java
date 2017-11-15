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
 * Tekur við skipunum frá vefviðmóti til að breyta veislusölum og skrá nýja
 * sali í gagnagrunninn.
 * 
 */

@Controller
@RequestMapping("/demo") //Request Mapping er gerd fyrir klasann til ad slidinn byrji a /demo fyrir allar skipanir.
public class ChangeController {

	// Tenging yfir í þjónustu klasa fyrir Search aðgerðina
	@Autowired
	SearchService searchService;
	
	/*
	 * Takki sem skilar vefsíðu þar sem notandi getur skráð sig inn á sinn sal.
	 * 
	 * return vefsíðan authenticate.
	 */
	@RequestMapping(value = "/innskra")
	public String skraning() {
		return "demo/authenticate";
	}
	
	/*
	 * Tekur við id og key frá notanda og athugar hvort það sé salur
	 * í gagnagrunninum með eftirfarandi id og key.
	 * 
	 * @param chosen Tegund sals
	 * @param id     Id númer sals
	 * @param key    Lykilorð sals
	 * @param model  Módel með attributes
	 * 
	 * @return vefsíða sem gerir notanda kleift að breyta sal result.
	 */
	@RequestMapping(value = "/verify")
	public String stadfesta(@RequestParam(value = "myradio", required = true)int chosen,
							@RequestParam(value = "id", required = true)int id,
							@RequestParam(value = "key", required = true)String key, Model model) {
		if (chosen == 1) {
			Banquet result = searchService.verifyBanquet(id, key);
			int locNr = 0;
			String location = result.getLocation();
			if (location.equalsIgnoreCase("Reykjavík")) {
				locNr = 1;
			} else if (location.equalsIgnoreCase("Hafnarfjörður")) {
				locNr = 2;
			} else if (location.equalsIgnoreCase("Garðabær")) {
				locNr = 3;
			} else if (location.equalsIgnoreCase("Kópavogur")) {
				locNr = 4;
			}
			model.addAttribute("banquet", result);
			model.addAttribute("locNr", locNr);
			return "demo/breytaSal";
		} else {
			SportVenues result = searchService.verifySport(id, key);
			int locNr = 0;
			String location = result.getLocation();
			if (location.equalsIgnoreCase("Reykjavík")) {
				locNr = 1;
			} else if (location.equalsIgnoreCase("Hafnarfjörður")) {
				locNr = 2;
			} else if (location.equalsIgnoreCase("Garðabær")) {
				locNr = 3;
			} else if (location.equalsIgnoreCase("Kópavogur")) {
				locNr = 4;
			}
			model.addAttribute("sportvenue", result);
			model.addAttribute("locNr", locNr);
			return "demo/breytaSport";
		}
	}
	
	/*
	 * Takki sem tekur við upplýsingum frá notanda um hvaða veislusal
	 * hann vill eyða.
	 * 
	 * @param  id Id númer veislusals sem notandi vill eyða.
	 * @return salEytt vefsíða sem segir notanda að veislusalnum
	 * hafi verið eytt.
	 */
	@RequestMapping(value = "/eydaSal", method = RequestMethod.POST)
	public String removeBanquet(@RequestParam(value = "id")int id) {
		searchService.removeBanquet(id);
		return "demo/salEytt";
	}
	
	/*
	 * Takki sem tekur við upplýsingum frá notanda um hvaða íþróttasal
	 * hann vill eyða.
	 * 
	 * @param  id Id númer íþróttasals sem notandi vill eyða.
	 * @return salEytt vefsíða sem segir notanda að íþróttasalnum
	 * hafi verið eytt.
	 */
	@RequestMapping(value = "/eydaSport", method = RequestMethod.POST)
	public String removeSport(@RequestParam(value = "id")int id) {
		searchService.removeSport(id);
		return "demo/salEytt";
	}
	
	/*
	 * Tekur við upplýsingum um veislusal og gerir notanda kleift að breyta upplýsingum 
	 * sem hann er með skráðann inn á síðunni.
	 * 
	 * @param id          Id númer sals
	 * @param nafn        Nafn sals
	 * @param locNr       Staðsetning sals
	 * @param street      Götuheiti sals
	 * @param price       Verð sals
	 * @param maxppl      Hámarksfjöldi sals
	 * @param phonenr     Símanúmer sals
	 * @param email       Netfang sals
	 * @param description Lýsing sals
	 * @param origLoc     Upprunaleg staðsetning sals
	 * @param model       Módel með attributes
	 * @return salBreytt vefsíða sem staðfestir að sal hafi verið eytt.
	 */
	@RequestMapping(value = "/breytaSal", method = RequestMethod.POST)
	public String editBanquet(@RequestParam(value = "id")int id,
							  @RequestParam(value = "nafn")String nafn,
							  @RequestParam(value = "location")int locNr,
							  @RequestParam(value = "streetAddrs")String street,
							  @RequestParam(value = "price")int price,
							  @RequestParam(value = "maxppl")int maxppl,
							  @RequestParam(value = "phonenr")int phonenr,
							  @RequestParam(value = "email")String email,
							  @RequestParam(value = "lysing")String description,
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
		Banquet changedBanq = new Banquet(id, nafn, loc, street, price, maxppl, phonenr, email, description);
		searchService.editBanquet(changedBanq);
		return "demo/salBreytt";
	}
	
	/*
	 * Tekur við upplýsingum um íþróttasal og gerir notanda kleift að breyta upplýsingum 
	 * sem hann er með skráðann inn á síðunni.
	 * 
	 * @param id          Id númer sals
	 * @param nafn        Nafn sals
	 * @param locNr       Staðsetning sals
	 * @param street      Götuheiti sals
	 * @param price       Verð sals
	 * @param phonenr     Símanúmer sals
	 * @param email       Netfang sals
	 * @param description Lýsing sals
	 * @param origLoc     Upprunaleg staðsetning sals
	 * @param model       Módel með attributes
	 * @return salBreytt vefsíða sem staðfestir að sal hafi verið eytt.
	 */
	@RequestMapping(value = "/breytaSport", method = RequestMethod.POST)
	public String editSport(@RequestParam(value = "id")int id,
							@RequestParam(value = "nafn")String nafn,
							@RequestParam(value = "location")int locNr,
							@RequestParam(value = "streetAddrs")String street,
							@RequestParam(value = "price")int price,
							@RequestParam(value = "phonenr")int phonenr,
							@RequestParam(value = "email")String email,
							@RequestParam(value = "lysing")String description,
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
		SportVenues changedSport = new SportVenues(id, nafn, loc, street, price, phonenr, email, description);
		searchService.editSport(changedSport);
		return "demo/salBreytt";
	}
}

