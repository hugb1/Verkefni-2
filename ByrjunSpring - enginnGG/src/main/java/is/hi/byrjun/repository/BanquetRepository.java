package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.BanquetBookings;

import java.util.List;

/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
*/

public interface BanquetRepository {
	/**
	 * Nær í alla veitingasali
	 * @return listi af veitingasölum
	 */
	List<Banquet> getAll();
	
	void addNewBanquetBooking(BanquetBookings booking);
	
	int addNewBanquet(String name, String loc, String streetAddrs, int price,
					int maxppl, int phoneNr, String email, String key);
	
	void addNewSport(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key);
	
	Banquet verifyBanquet(int id, String key);
	
	void removeBanquet(int id);
}
