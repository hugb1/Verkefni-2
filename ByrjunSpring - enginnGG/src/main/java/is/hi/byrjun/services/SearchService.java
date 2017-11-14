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
	 * @param chosen Tegund sals
	 * @return skilar true ef valinn er veitingasalur, false ef valinn er
	 * íþróttasalur.
	 */
	boolean checkChosen(int chosen);
	
	/*
	 * Nær í alla íþróttasali sem staðsettir eru í locaction
	 * 
	 * @param list   Listi af íþróttasölum
	 * @param loc    Staðsetning íþróttasala
	 * 
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

	/*
	 * Sækir lista með öllum upplýsingum um alla veislusali
	 * 
	 * @return listi af veitingasölum
	 */
	List<Banquet> getAllBanq();

	/*
	 * Sækir lista með öllum upplýsingum um alla íþróttasali
	 * 
	 * @return listi af íþróttasölum
	 */
	List<SportVenues> getAllSport();
	
	/*
	 * Bætir við veislusal með gefnar upplýsingar í gagnagrunninn.
	 * 
	 * @param name        Nafn veislusals
	 * @param loc         Staðsetning veislusals
	 * @param streetAddrs Götuheiti veislusals
	 * @param price       Verð veislusals
	 * @param maxppl      Hámarksfjöldi veislusals
	 * @param phoneNr     Símanúmer veislusals
	 * @param email       Netfang veislusals
	 * @param key         Lykilorð veislusals
	 * @param description Lýsing veislusals
	 * 
	 * @return result, id númer veislusals
	 */
	int addBanquet(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key, String description);
	
	/*
	 * Bætir við Íþróttasal með gefnar upplýsingar í gagnagrunninn.
	 * 
	 * @param name        Nafn íþróttasals
	 * @param loc         Staðsetning íþróttasals
	 * @param streetAddrs Götuheiti íþróttasals
	 * @param price       Verð íþróttasals
	 * @param maxppl      Hámarksfjöldi íþróttasals
	 * @param phoneNr     Símanúmer íþróttasals
	 * @param email       Netfang íþróttasals
	 * @param key         Lykilorð íþróttasals
	 * @param description Lýsing íþróttasals
	 * 
	 * @return result Id númer íþróttasals
	 */
	int addSport(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key, String description);
	
	/*
	 * Athugar hvort ID númer Veitingasals og key eigi saman.
	 * 
	 * @param id  Id númer veislusals
	 * @param key Lykilorð veislusals
	 * 
	 * @return temp Skilar veislusal sem passar við upplýsngar sem
	 * hafa verið gefnar af notanda.
	 */
	Banquet verifyBanquet(int id, String key);
	
	/*
	 * Athugar hvort ID númer Íþróttasals og key eigi saman.
	 * 
	 * @param id  Id númer íþróttasals
	 * @param key Lykilorð íþróttasals
	 * 
	 * @return temp Skilar íþróttasal sem passar við upplýsingar sem
	 * hafa verið gefnar af notanda.
	 */
	SportVenues verifySport(int id, String key);

	/*
	 * Eyðir veislusal úr gagnagrunni
	 * 
	 * @param id Id númer veislusals
	 */
	void removeBanquet(int id);

	/*
	 * Eyðir íþróttasal úr gagnagrunni
	 * 
	 * @param id Id númer íþróttasals
	 */
	void removeSport(int id);
	
	/*
	 * Breytir upplýsingum um veislusali
	 * 
	 * @param updated Uppfærður veislusalur
	 */
	void editBanquet(Banquet updated);
	
	/*
	 * Breytir upplýsingum um íþróttasali
	 * 
	 * @param updated Uppfærður íþróttasalur
	 */
	void editSport(SportVenues updated);

	/*
	 * Finnur hvaða dagsetningar eru bókaðar fyrir veislusali
	 * 
	 * @param salur Id númer veislusals
	 * 
	 * @return unavalible Skilar lista af dagsetningum sem eru
	 * bókaðar af tilteknum veislusal.
	 */
	List<String> findBookedBanquetDates(Banquet salur);
	
	/*
	 * Finnur hvaða dagsetningar eru bókaðar fyrir íþróttasali
	 * 
	 * @param sport Id númer íþróttasals.
	 * 
	 * @return unavalible Skilar lista af dagsetningum sem eru
	 * bókaðar af tilteknum íþróttasal.
	 */
	List<String> checkAvalibleSport(SportVenues sport);
}