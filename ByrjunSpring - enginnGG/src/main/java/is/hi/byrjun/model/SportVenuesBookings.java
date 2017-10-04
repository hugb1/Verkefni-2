package is.hi.byrjun.model;

/**
 * 
 * @author Gunnar Már Harðarson
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 */

public class SportVenuesBookings {
	private int id;
	private String name;
	private int kennitala;
	private String email;
	private int phonenr;
	private int sportvenuenumber;

	public SportVenuesBookings(String name, int kennitala, String email,
			int phonenr, int sportvenuenumber) {
		this.name = name;
		this.kennitala = kennitala;
		this.email = email;
		this.phonenr = phonenr;
		this.sportvenuenumber = sportvenuenumber;
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
	
	public int getKennitala() {
		return kennitala;
	}
	
	public void setKennitala(int kennitala) {
		this.kennitala = kennitala;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhonenr() {
		return phonenr;
	}
	
	public void setPhonenr(int phonenr) {
		this.phonenr = phonenr;
	}
	
	public int getSportvenuenumber() {
		return sportvenuenumber;
	}
	
	public void setSportvenuenumber(int sportvenuenumber) {
		this.sportvenuenumber = sportvenuenumber;
	}

}
