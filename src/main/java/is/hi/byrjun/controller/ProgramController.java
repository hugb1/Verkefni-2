package is.hi.byrjun.controller;

import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.BanquetBookings;
import is.hi.byrjun.model.SportVenues;
import is.hi.byrjun.model.SportVenuesBookings;
import is.hi.byrjun.services.SearchService;

import java.util.ArrayList;
import java.util.List;

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
public class ProgramController {

	// Tenging yfir í þjónustu klasa fyrir Search aðgerðina
	@Autowired
	SearchService searchService;

	/*
	 * Biður notandann um leitarupplýsingar, tegund sals, staðsetningu,
	 * og fjölda.
	 * 
	 * @return vefsíða með spurningum.
	 */
	@RequestMapping("/search")
	public String searchPage() {
		return "demo/search"; //Skilar .jsp skrá sem er /webapp/WEB-INF/vefvidmot/demo/search.jsp
	}
	
	/*
	 * Tekur við leitarupplýsingum frá notanda og birtir þá sali sem 
	 * eiga við. Biður síðan notandann um að velja einn af þeim sölum
	 * sem eru birtir.
	 * 
	 * @param chosen Tegund sals
	 * @param locNr  Staðsetning sals
	 * @param capNr  Lámarks fólksfjöldi sals
	 * @param model  Módel með attributum
	 * @return vefsíða sem birtir alla sali sem eiga við
	 */
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@RequestParam(value = "myradio", required = true) int chosen,
			@RequestParam(value = "loc", required = true) int locNr,
			@RequestParam(value = "cap", required = false) int capNr, Model model) {
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
		
		if (searchService.checkChosen(chosen)) {
			List<Banquet> all = searchService.getAllBanq();

			List<Banquet> list = searchService.searchBanquet(all, location, maxcap);

			model.addAttribute("veislusalir", list);
			return "demo/synaSali";
		} else {
			List<SportVenues> all = searchService.getAllSport();

			List<SportVenues> list = searchService.searchSportVenues(all, location);

			model.addAttribute("sportsalir", list);
			return "demo/synaSport";
		}
	}
	
	/*
	 * Aðferð sem hægt er að nota til þess að birta alla veislusali
	 */
	@RequestMapping(value = "/salir", method = RequestMethod.POST)
	public String birtaSali(Model model) {
		List<Banquet> list;
		list = searchService.getAllBanq();
		model.addAttribute("veislusalir", list);

		return "demo/synaSali";
	}
	
	
	/*
	 * Ef notandinn ákvað að velja veitingasal þá tekur þessi aðferð við hvaða
	 * salur var valinn og birtir notandanum upplýsingar um salinn. Og biður 
	 * síðan um persónuupplýsingar notanda fyrir bókun salsins.
	 * 
	 * @param nr    Id númer veislusals sem var valinn
	 * @param model Módel með attributes
	 * @return Vefsíða sem birtir upplýsingar um veislusal
	 */
	@RequestMapping(value = "/bokaSal", method = RequestMethod.POST)
	public String bokaSal(@RequestParam(value = "bokunNr")int nr, Model model) {
		Banquet salur = searchService.searchBanquetById(searchService.getAllBanq(), nr);
		List<String> bookedDates = new ArrayList<String>();
		bookedDates = searchService.findBookedBanquetDates(salur);
		String[] stringArray = new String[bookedDates.size()];
		for (int i = 0; i < bookedDates.size(); i++) {
			stringArray[i] = bookedDates.get(i);
		}
		model.addAttribute("banquet", salur);
		model.addAttribute("dateArray", stringArray);
		return "demo/bokaSal";
	}
	
	
	/*
	 * Ef notandinn ákvað að velja íþróttasal þá tekur þessi aðferð við hvaða
	 * salur var valinn og birtir notandanum upplýsingar um salinn. Og biður 
	 * síðan um persónuupplýsingar notanda fyrir bókun salsins.
	 * 
	 * @param nr    Id númer íþróttasals sem var valinn
	 * @param model Módel með attributum
	 * @return Vefsíða sem birtir upplýsingar um íþróttasal
	 */
	@RequestMapping(value = "/bokaSport", method = RequestMethod.POST)
	public String bokaSport(@RequestParam(value = "bokunNr")int nr, Model model) {
		SportVenues sport = searchService.searchSportVenuesById(searchService.getAllSport(), nr);
		List<String> bookedDates = searchService.checkAvalibleSport(sport);
		String[] stringArray = new String[bookedDates.size()];
		for (int i = 0; i < bookedDates.size(); i++) {
			stringArray[i] = bookedDates.get(i);
		}
		model.addAttribute("sportvenues", sport);
		model.addAttribute("dateArray", stringArray);
		return "demo/bokaSport";
	}
	
	/*
	 * Tekur við persónuupplýsingum frá notanda og sendir bókunina í
	 * gagnagrunn Veislusala bókanna og þakkar síðan notandanum fyrir
	 * viðskiptin.
	 * 
	 * @param nafn     Nafn notanda
	 * @param kennit   Kennitala notanda
	 * @param mail     Netfang notanda
	 * @param phNr     Símanúmer notanda
	 * @param id       Id númer veislusals
	 * @param model    Módel með attributum
	 * return Vefsíða sem þakkar notandanum fyrir viðskiptin
	 */
	@RequestMapping(value = "/salurStadfest", method = RequestMethod.POST)
	public String salurStad(@RequestParam(value = "name")String nafn,
							@RequestParam(value = "kt")long kennit,
							@RequestParam(value = "mail")String mail,
							@RequestParam(value = "phone")int phNr,
							@RequestParam(value = "date")String date,
							@RequestParam(value = "id")int id, Model model) {
		BanquetBookings book = new BanquetBookings(nafn, kennit, mail, phNr, id, date);
		
		searchService.addBanquetBooking(book);
		
		return "demo/lokaSida";
	}
	
	/*
	 * Tekur við persónuupplýsingum frá notanda og sendir bókunina í
	 * gagnagrunn Íþróttasala bókanna og þakkar síða notandanum fyrir
	 * viðskiptin.
	 * 
	 * @param nafn     Nafn notanda
	 * @param kennit   Kennitala notanda
	 * @param mail     Netfang notanda
	 * @param phNr     Símanúmer notanda
	 * @param id       Id númer íþróttasals
	 * @param model    Módel með attributes
	 * return Vefsíða sem þakkar notandanum fyrir viðskiptin
	 */
	@RequestMapping(value = "/sportStadfest", method = RequestMethod.POST)
	public String sportStad(@RequestParam(value = "name")String nafn,
							@RequestParam(value = "kt")long kennit,
							@RequestParam(value = "mail")String mail,
							@RequestParam(value = "phone")int phNr,
							@RequestParam(value = "date")String date,
							@RequestParam(value = "id")int id, Model model) {
		SportVenuesBookings book = new SportVenuesBookings(nafn, kennit, mail, phNr, id, date);
		
		searchService.addSportVenuesBooking(book);
		
		return "demo/lokaSida";
	}
	
	/*
	 * Takki sem skilar vefsíðu þar sem notandi getur srkáð nýjan sal.
	 * 
	 * @return vefsíðan newSalur.
	 */
	@RequestMapping(value = "/nyrSalur")
	public String nyrSalur() {
		return "demo/newSalur";
	}
	
	/*
	 * Tekur við upplýsingum frá notanda og og sendir í viðeigandi gagnagrunn
	 * fyrir hvaða sal notandi er að búa til, segir síðan notanda að bókun hafi
	 * verið staðfest.
	 * 
	 * @param chosen        Tegund sals
	 * @param name          Nafn sals
	 * @param loc           Staðsetning sals
	 * @param streetAddrs   Götuheiti sals
	 * @param price         Verð sals
	 * @param maxppl        Hámarksfjöldi sals
	 * @param phoneNr       Símanúmer sals
	 * @param email         Netfang sals
	 * @param description   Lýsing sals
	 * @param key           Lykilorð sals
	 * @param model         Módel með attributes
	 * 
	 * @return skraLokid vefsíða sem segir notanda að skráning sals hafi tekist.
	 * 
	 */
	@RequestMapping(value = "/skraSal")
	public String skraSal(@RequestParam(value = "myradio", required = true)int chosen,
						  @RequestParam(value = "heiti", required = true)String name,
						  @RequestParam(value = "loc")int loc,
						  @RequestParam(value = "streetAddress", required = true) String streetAddrs,
						  @RequestParam(value = "price", required = true)int price,
						  @RequestParam(value = "maxppl", required = true)int maxppl,
						  @RequestParam(value = "phone", required = true)int phoneNr,
						  @RequestParam(value = "mail", required = true)String email,
						  @RequestParam(value = "description", required = true)String description,
						  @RequestParam(value = "key", required = true)String key, Model model) {
		
		String location;
		int id;
		switch(loc) {
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
		
		if (chosen == 1) {
			id = searchService.addBanquet(name, location, streetAddrs, price, maxppl, phoneNr, email, key, description);
			Banquet salur = new Banquet(id, name, location, streetAddrs, price, maxppl, phoneNr, email, description);
			model.addAttribute("banquet", salur);
			return "demo/skraLokid";
		} else {
			id = searchService.addSport(name, location, streetAddrs, price, maxppl, phoneNr, email, key, description);
			SportVenues salur = new SportVenues(id, name, location, streetAddrs, price, phoneNr, email, description);
			model.addAttribute("banquet", salur);
			return "demo/skraLokid";
		}
	}
}
