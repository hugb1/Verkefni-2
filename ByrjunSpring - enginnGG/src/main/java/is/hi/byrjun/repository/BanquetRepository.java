package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;
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
}
