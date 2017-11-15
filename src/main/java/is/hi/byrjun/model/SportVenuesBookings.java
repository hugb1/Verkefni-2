package is.hi.byrjun.model;

/**
 * 
 * @author Gunnar Már Harðarson
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * SportVenuesBookings klasi inniheldur auðkennisnúmer, nafn, kennitölu,
 * póstfang, símanúmer og íþróttasalsnúmer fyrir bókanir á íþróttasal
 */

public class SportVenuesBookings {
	private int id;
	private String name;
	private long kennitala;
	private String email;
	private int phonenr;
	private int sportvenuenumber;
	private String date;

	public SportVenuesBookings(String name, long kennitala, String email,
			int phonenr, int sportvenuenumber, String dags) {
		this.name = name;
		this.kennitala = kennitala;
		this.email = email;
		this.phonenr = phonenr;
		this.sportvenuenumber = sportvenuenumber;
		this.date = dags;
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
	
	public long getKennitala() {
		return kennitala;
	}
	
	public void setKennitala(long kennitala) {
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
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String dags) {
		this.date = dags;
	}
}






