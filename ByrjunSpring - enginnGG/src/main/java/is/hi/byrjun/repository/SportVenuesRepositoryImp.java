package is.hi.byrjun.repository;

import is.hi.byrjun.model.SportVenues;
import is.hi.byrjun.model.SportVenuesBookings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Gunnar Már Harðarson
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * 
 * Safn af íþróttasölum
 *
 */
@Repository
public class SportVenuesRepositoryImp implements SportVenuesRepository{
	
	//Listi af íþróttasölum
	private List<SportVenues> sportvenues;
	
	// Attributes for SQL Connection
	Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/bookingdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "postgres";
	private final String password = "villijons";

	
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
	
	public SportVenuesRepositoryImp() {
		sportvenues = new ArrayList<SportVenues>();
	}
	
	@Override
	public List<SportVenues> getAll() {
		ArrayList<SportVenues> list = new ArrayList<SportVenues>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM  sportvenues");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SportVenues temp = new SportVenues(rs.getInt("sportvenuenumber"),
													rs.getString("name"),
													rs.getString("location"),
													rs.getString("street"),
													rs.getInt("price"),
													rs.getInt("phonenr"),
													rs.getString("email"),
													rs.getString("description"));
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.sportvenues = list;
		return sportvenues;
	}
	
	// Add a sportvenue booking to the sportvenuebookings table in database
	public void addNewSportVenueBooking(SportVenuesBookings booking) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO sportvenuebookings ("
					+ "name, kennitala, email, phonenr, sportvenuenumber, dagsetning) VALUES ("
					+ "?,?,?,?,?,?)");
			
			ps.setString(1, booking.getName());
			ps.setLong(2, booking.getKennitala());
			ps.setString(3, booking.getEmail());
			ps.setInt(4, booking.getPhonenr());
			ps.setInt(5, booking.getSportvenuenumber());
			ps.setString(6, booking.getDate());
			
			// execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addNewSport(String name, String loc, String streetAddrs, int price, int maxppl, int phoneNr,
			String email, String key, String description) {
		int result = -1;
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO sportvenues ("
					+ "name, location, street, price, phonenr, email, key, description) VALUES ("
					+ "?,?,?,?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, loc);
			ps.setString(3, streetAddrs);
			ps.setInt(4, price);
			ps.setInt(5, phoneNr);
			ps.setString(6, email);
			ps.setString(7, key);
			ps.setString(8, description);
			
			//Execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
			
			ps = con.prepareStatement("SELECT * FROM sportvenues");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String temp = rs.getString("name");
				if (temp.equals(name)) {
					result = rs.getInt("sportvenuenumber");
				}
			}
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public SportVenues verifySport(int id, String key) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM sportvenues");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if (rs.getInt("sportvenuenumber") == id && rs.getString("key").equals(key)) {
					SportVenues temp = new SportVenues(rs.getInt("sportvenuenumber"),
							   rs.getString("name"),
							   rs.getString("location"),
							   rs.getString("street"),
							   rs.getInt("price"),
							   rs.getInt("phonenr"),
							   rs.getString("email"),
							   rs.getString("description"));
					return temp;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("ID/Key combination is not valid");
	}

	
	@Override
	public void removeSport(int id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("DELETE FROM sportvenues WHERE sportvenuenumber = " + id);
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// Update Sportvenues in database
	public void changeSport(SportVenues updated) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("UPDATE sportvenues SET name = ?,"
					+ "location = ?, street = ?, price = ?, phonenr = ?,"
					+ "email = ?, " + "description = ? WHERE sportvenuenumber = ?");
			ps.setString(1, updated.getName());
			ps.setString(2, updated.getLocation());
			ps.setString(3, updated.getAddress());
			ps.setInt(4, updated.getPrice());
			ps.setInt(5, updated.getPhonenr());
			ps.setString(6, updated.getEmail());
			ps.setString(7, updated.getDescription());
			ps.setInt(8, updated.getId());
			
			// Execute the prepared statement update
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> checkAvalible(SportVenues sport) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM sportvenuebookings WHERE sportvenuenumber = ? AND dagsetning IS NOT NULL");
			ps.setInt(1, sport.getId());
			ResultSet rs = ps.executeQuery();
			List<String> unavalible = new ArrayList<String>();
			
			while (rs.next()) {
				String temp = rs.getString("dagsetning");
				unavalible.add(temp);
			}
			return unavalible;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}









