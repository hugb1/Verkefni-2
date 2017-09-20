package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private final String url = "jdbc:postgresql://localhost:5432/bookingdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "postgres";
	private final String password = "123456";
	
	public BanquetRepositoryImp() {
		ArrayList<Banquet> list = new ArrayList<Banquet>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM banquets");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Banquet temp = new Banquet(rs.getInt("id"),
										   rs.getString("name"),
										   rs.getString("location"),
										   rs.getString("street"),
										   rs.getInt("price"),
										   rs.getInt("maxppl"),
										   rs.getInt("phonenr"),
										   rs.getString("email"));
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.banquets = list;
	}
	
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
	
	@Override
	public List<Banquet> getAll() {
		// TODO Auto-generated method stub
		return banquets;
	}
}
