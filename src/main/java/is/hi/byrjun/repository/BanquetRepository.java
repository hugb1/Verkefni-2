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
	
	/*
	 * Bætir við nýrri bókun á veislusal í banquetbookings gagnagrunninn
	 * 
	 * @param booking Bókun á veislusal
	 */
	void addNewBanquetBooking(BanquetBookings booking);
	
	/*
	 * Bætir við veislusal með gefnar upplýsingar í gagnagrunn
	 */
	int addNewBanquet(String name, String loc, String streetAddrs, int price,
					int maxppl, int phoneNr, String email, String key, String description);
	
	/*
	 * Athugar hvort ID númer veitingasals og key eigi saman.
	 */
	Banquet verifyBanquet(int id, String key);
	
	/*
	 * Eyðir veislusal úr gagnagrunni.
	 */
	void removeBanquet(int id);
	
	/*
	 * Breytir upplýsingum um veislusal í gagnagrunni
	 */
	void changeBanquet(Banquet updated);
}
