package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
*/

public interface BanquetRepository extends JpaRepository<Banquet, Long> {
	/**
	 * Nær í alla veitingasali
	 * @return listi af veitingasölum
	 */
	List<Banquet> getAll();
	
	
}
