package is.hi.byrjun.repository;

import is.hi.byrjun.model.Banquet;
import is.hi.byrjun.model.BanquetBookings;

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
	
	//Listi af veislusölum
	private List<Banquet> banquets;
	
	// Attributes for SQL Connection
	Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/bookingdb";
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
		banquets = new ArrayList<Banquet>();
	}
	
	@Override
	public List<Banquet> getAll() {
		ArrayList<Banquet> list = new ArrayList<Banquet>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM banquets");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Banquet temp = new Banquet(rs.getInt("banquetnumber"),
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
		return banquets;
	}
	
	// Add a banquet booking to the banquetbookings table in database
	@Override
	public void addNewBanquetBooking(BanquetBookings booking) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO banquetbookings ("
					+ "name, kennitala, email, phonenr, banquetnumber) VALUES ("
					+ "?,?,?,?,?)");
			
			ps.setString(1, booking.getName());
			ps.setLong(2, booking.getKennitala());
			ps.setString(3, booking.getEmail());
			ps.setInt(4, booking.getPhonenr());
			ps.setInt(5, booking.getBanquetnumber());
			
			// execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addNewBanquet(String name, String loc, String streetAddrs, int price,
			int maxppl, int phoneNr, String email, String key) {
		int result = -1;
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO banquets ("
					+ "name, location, street, price, maxppl, phonenr, email, key) VALUES ("
					+ "?,?,?,?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, loc);
			ps.setString(3, streetAddrs);
			ps.setInt(4, price);
			ps.setInt(5, maxppl);
			ps.setInt(6, phoneNr);
			ps.setString(7, email);
			ps.setString(8, key);
			
			//Execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
			
			ps = con.prepareStatement("SELECT * FROM banquets");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String temp = rs.getString("name");
				if (temp.equals(name)) {
					result = rs.getInt("banquetnumber");
				}
			}
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addNewSport(String name, String loc, String streetAddrs, int price, int maxppl, int phoneNr,
			String email, String key) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO sportvenues ("
					+ "name, location, street, price, phonenr, email, key) VALUES ("
					+ "?,?,?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, loc);
			ps.setString(3, streetAddrs);
			ps.setInt(4, price);
			//ps.setInt(5, maxppl);
			ps.setInt(5, phoneNr);
			ps.setString(6, email);
			ps.setString(7, key);
			
			//Execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Banquet verifyBanquet(int id, String key) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM banquets");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if (rs.getInt("banquetnumber") == id && rs.getString("key").equals(key)) {
					Banquet temp = new Banquet(rs.getInt("banquetnumber"),
							   rs.getString("name"),
							   rs.getString("location"),
							   rs.getString("street"),
							   rs.getInt("price"),
							   rs.getInt("maxppl"),
							   rs.getInt("phonenr"),
							   rs.getString("email"));
					return temp;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("ID/Key combination is not valid");
	}

	@Override
	public void removeBanquet(int id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("DELETE FROM banquets WHERE banquetnumber = " + id);
			ps.executeQuery();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}







