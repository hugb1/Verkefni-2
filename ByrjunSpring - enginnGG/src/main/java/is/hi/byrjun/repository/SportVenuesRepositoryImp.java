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
public class SportVenuesRepositoryImp {
	
	//Listi af íþróttasölum
	private List<SportVenues> sportvenues;
	
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
	
	public SportVenuesRepositoryImp() {
		sportvenues = new ArrayList<SportVenues>();
	}
	
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
													rs.getString("email"));
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
					+ "name, kennitala, email, phonenr, sportvenuenumber) VALUES ("
					+ "?,?,?,?,?)");
			
			ps.setString(1, booking.getName());
			ps.setLong(2, booking.getKennitala());
			ps.setString(3, booking.getEmail());
			ps.setInt(4, booking.getPhonenr());
			ps.setInt(5, booking.getSportvenuenumber());
			
			// execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
