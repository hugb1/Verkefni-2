package is.hi.byrjun.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.SportVenues;


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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
