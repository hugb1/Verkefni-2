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
}
