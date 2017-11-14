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
	
	/*
	 * Bætir við íþróttasal með gefnum uppýsingum í gangagrunn
	 */
	int addNewSport(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key, String description);
	
	/*
	 * Athugar hvort ID númer íþróttasals og key eigi saman.
	 */
	SportVenues verifySport(int id, String key);
	
	/*
	 * Eyðir íþróttasal úr gagnagrunni.
	 */
	void removeSport(int id);
	
	/*
	 * Breytir íþróttasölum í gagnagrunni
	 */
	void changeSport(SportVenues updated);
}
