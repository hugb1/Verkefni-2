package is.hi.byrjun.repository;

import is.hi.byrjun.model.SportVenues;
import java.util.List;

/**
 * 
 * @author Gunnar Már Harðarson
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 */

public interface SportVenuesRepository {
	/**
	 * Nær í alla íþróttasali
	 * @return listi af íþróttasölum
	 */
	List<SportVenues> getAll();
	
	int addNewSport(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key);
	
	SportVenues verifySport(int id, String key);
	
	void removeSport(int id);
	
	void changeSport(int sportvenuenumber, String name, String loc, String streetAddrs, int price,
			int phonenr, String email);
}
