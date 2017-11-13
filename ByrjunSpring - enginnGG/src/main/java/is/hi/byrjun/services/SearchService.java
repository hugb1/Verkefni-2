package is.hi.byrjun.services;

import java.sql.Date;
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
	 * 
	 * @param list   Listi af veislusölum
	 * @param loc    Staðsetning veislusala
	 * @param maxCap Lámarksfjöldi veislusala
	 * @return Skilar lista af veislusölum sem eiga við
	 */
	List<Banquet> searchBanquet(List<Banquet> list, String loc, int maxCap);
	
	/*
	 * Athugar hvort valið hafi verið veitingasal eða íþróttahús.
	 * 
	 * 
	 */
	boolean checkChosen(int chosen);
	
	/*
	 * Nær í alla íþróttasali sem staðsettir eru í locaction
	 * 
	 * @param list   Listi af íþróttasölum
	 * @param loc    Staðsetning íþróttasala
	 * @return Skilar lista af íþróttasölum sem eiga við
	 */
	List<SportVenues> searchSportVenues(List<SportVenues> list, String loc);
	
	/*
	 * Nær í veislusal sem er með gefið ID númer
	 * 
	 * @param list Listi af veislusölum
	 * @param id   Id númer valda veislusalarins
	 * @return Skilar veislusal sem er með gefið ID númer
	 */
	Banquet searchBanquetById(List<Banquet> list, int id);
	
	/*
	 * Nær í íþróttasal sem er með gefið ID númer
	 * 
	 * @param list Listi af íþróttasölum
	 * @param id   Id númer valda íþróttasalarins
	 * @return Skilar íþróttasal sem er með gefið ID númer
	 */
	SportVenues searchSportVenuesById(List<SportVenues> list, int id);
	
	 /*
	  * Bætir við bókun á veislusal í banquetbookings gagnagrunninn
	  * 
	  * @param book Bókun á veislusal
	  */
	void addBanquetBooking(BanquetBookings book);
	
	/*
	 * Bætir við bókun á íþróttasal í sportvenuebookings gagnagrunninn
	 * 
	 * @param book Bókun á íþróttasal
	 */
	void addSportVenuesBooking(SportVenuesBookings book);

	List<Banquet> getAllBanq();

	List<SportVenues> getAllSport();
	
	/*
	 * Bætir við veislusal með gefnar upplýsingar í gagnagrunninn.
	 */
	int addBanquet(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key);
	
	/*
	 * Bætir við Íþróttasal með gefnar ulppýsingar í gagnagrunninn.
	 */
	int addSport(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key);
	
	/*
	 * Athugar hvort ID númer Veitingasals og key eigi saman.
	 */
	Banquet verifyBanquet(int id, String key);
	
	/*
	 * Athugar hvort ID númer Íþróttasals og key eigi saman.
	 */
	SportVenues verifySport(int id, String key);

	void removeBanquet(int id);

	void removeSport(int id);
	
	void editBanquet(int id, String name, String loc, String streetAddrs,
					 int price, int maxppl, int phoneNr, String email);
	
	void editSport(int id, String name, String loc, String streetAddrs,
					 int price, int phoneNr, String email);

	List<String> findBookedBanquetDates(Banquet salur);
	
	List<String> checkAvalibleSport(SportVenues sport);
}