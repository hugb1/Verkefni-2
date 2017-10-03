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
	private int id;
	private String name;
	private String location;
	private String street;
	private int price;
	private int phonenr;
	private String email;

	public SportVenues(int id, String name, String location, String street,
						int price, int phonenr, String email) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.street = street;
		this.price = price;
		this.phonenr = phonenr;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
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
