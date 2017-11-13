package is.hi.byrjun.services;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.BanquetBookings;
import is.hi.byrjun.model.SportVenues;
import is.hi.byrjun.model.SportVenuesBookings;
import is.hi.byrjun.repository.BanquetRepositoryImp;
import is.hi.byrjun.repository.SportVenuesRepositoryImp;


/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
*/
@Service
public class SearchServiceImp implements SearchService {
	
	//Tenging yfir í safn af veislusölum
	 @Autowired
	 BanquetRepositoryImp banquetRep;
	 
	 //Tenging yfir í safn af íþróttasölum
	 @Autowired
	 SportVenuesRepositoryImp sportRep;

	@Override
	public List<Banquet> searchBanquet(List<Banquet> list, String loc, int maxCap) {
		ArrayList<Banquet> result = new ArrayList<Banquet>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLocation().equalsIgnoreCase(loc) && list.get(i).getMax() >= maxCap) {
				result.add(list.get(i));
			}
		}
		return result;
	}
	
	@Override
	public List<SportVenues> searchSportVenues(List<SportVenues> list, String loc) {
		ArrayList<SportVenues> result = new ArrayList<SportVenues>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLocation().equalsIgnoreCase(loc)) {
				result.add(list.get(i));
			}
		}
		return result;
	}

	@Override
	public Banquet searchBanquetById(List<Banquet> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return list.get(i);
			}
		}
		throw new IllegalArgumentException("No banquets were found with the given ID number");
	}

	@Override
	public SportVenues searchSportVenuesById(List<SportVenues> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return list.get(i);
			}
		}
		throw new IllegalArgumentException("No banquets were found with the given ID number");
	}

	@Override
	public void addBanquetBooking(BanquetBookings book) {
		banquetRep.addNewBanquetBooking(book);
	}

	@Override
	public void addSportVenuesBooking(SportVenuesBookings book) {
		sportRep.addNewSportVenueBooking(book);
	}

	@Override
	public List<Banquet> getAllBanq() {
		return banquetRep.getAll();
	}

	@Override
	public List<SportVenues> getAllSport() {
		return sportRep.getAll();
	}

	@Override
	public int addBanquet(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key) {
		return banquetRep.addNewBanquet(name, loc, streetAddrs, price, maxppl, phoneNr, email, key);
	}

	@Override
	public int addSport(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key) {
		return sportRep.addNewSport(name, loc, streetAddrs, price, maxppl, phoneNr, email, key);
		
	}

	@Override
	public Banquet verifyBanquet(int id, String key) {
		return banquetRep.verifyBanquet(id, key);
	}

	@Override
	public SportVenues verifySport(int id, String key) {
		return sportRep.verifySport(id, key);
	}

	@Override
	public void removeBanquet(int id) {
		banquetRep.removeBanquet(id);
		
	}

	@Override
	public void removeSport(int id) {
		sportRep.removeSport(id);
	}

	@Override
	public void editBanquet(int id, String name, String loc, String streetAddrs, int price, int maxppl, int phoneNr,
			String email) {
		banquetRep.changeBanquet(id, name, loc, streetAddrs, price, maxppl,
								 phoneNr, email);
		
	}

	@Override
	public void editSport(int id, String name, String loc, String streetAddrs, int price, int phoneNr,
			String email) {
		sportRep.changeSport(id, name, loc, streetAddrs, price, phoneNr, email);
		
	}

	@Override
	public boolean checkChosen(int chosen) {
		if (chosen == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Date> checkAvalibleBanquet(Banquet salur) {
		return banquetRep.checkAvalible(salur);
	}
	
	@Override
	public List<Date> checkAvalibleSport(SportVenues sport) {
		return sportRep.checkAvalible(sport);
	}
	
}
