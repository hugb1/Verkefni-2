package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
* Safn af veislusölum
* 
*/
@Repository
public class BanquetRepositoryImp implements BanquetRepository {
	
	//Listi af Veislusölum
	private final List<Banquet> banquets;
	
	public BanquetRepositoryImp() {
		this.banquets = new ArrayList<Banquet>();
	}
	
	@Override
	public List<Banquet> getAll() {
		// TODO Auto-generated method stub
		return banquets;
	}
	
}
