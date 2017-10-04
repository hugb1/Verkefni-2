package is.hi.byrjun.model;

/**
 * 
 * @author Gunnar Már Harðarson
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 */

public class SportVenues {
	private int sportvenuenumber;
	private String name;
	private String location;
	private String streetAddrs;
	private int price;
	private int phonenr;
	private String email;

	public SportVenues(int id, String name, String location, String streetAddrs,
						int price, int phonenr, String email) {
		this.sportvenuenumber = id;
		this.name = name;
		this.location = location;
		this.streetAddrs = streetAddrs;
		this.price = price;
		this.phonenr = phonenr;
		this.email = email;
	}
	
	public int getId() {
		return sportvenuenumber;
	}
	
	public void setId(int id) {
		this.sportvenuenumber = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getAddress() {
		return streetAddrs;
	}
	
	public void setAddress(String streetAddrs) {
		this.streetAddrs = streetAddrs;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPhonenr() {
		return phonenr;
	}
	
	public void setPhonenr(int phonenr) {
		this.phonenr = phonenr;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
