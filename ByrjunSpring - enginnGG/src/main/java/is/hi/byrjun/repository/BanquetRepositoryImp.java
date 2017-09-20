package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	// Attributes for SQL Connection
	Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/bookingsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "postgres";
	private final String password = "123456";
	
	// Connection to Database
	public Connection connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public BanquetRepositoryImp() {
		this.banquets = new ArrayList<Banquet>();
	}
	
	@Override
	public List<Banquet> getAll() {
		// TODO Auto-generated method stub
		return banquets;
	}
	
}
