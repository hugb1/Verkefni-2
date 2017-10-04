package is.hi.byrjun.services;

import java.util.List;
import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.BanquetBookings;
import is.hi.byrjun.model.SportVenues;
import is.hi.byrjun.model.SportVenuesBookings;

/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
* Þjónusta sem athugar hvort leit er á réttu formi 
* 
*/

public interface SearchService {
	
	/*
	 * Nær í alla veitingasali sem staðsettir eru í location og hafa pláss fyrir a.m.k
	 * maxCap manns.
	 */
	List<Banquet> searchBanquet(List<Banquet> list, String loc, int maxCap);
	
	/*
	 * Nær í alla íþróttasali sem staðsettir eru í locaction
	 */
	List<SportVenues> searchSportVenues(List<SportVenues> list, String loc);
	
	/*
	 * Nær í veislusal sem er með gefið ID númer
	 */
	Banquet searchBanquetById(List<Banquet> list, int id);
	
	/*
	 * Nær í íþróttasal sem er með gefið ID númer
	 */
	SportVenues searchSportVenuesById(List<SportVenues> list, int id);
	
	void addBanquetBooking(BanquetBookings book);
	
	void addSportVenuesBooking(SportVenuesBookings book);
}