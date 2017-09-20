package is.hi.byrjun.services;

import java.util.List;

import is.hi.byrjun.model.Banquet;

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
	 * Nær í alla veitingasali sem staðsettir eru í loc og hafa pláss fyrir a.m.k
	 * maxCap manns.
	 */
	List<Banquet> searchBanquet(List<Banquet> list, String loc, int maxCap);
}