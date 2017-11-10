package is.hi.byrjun.model;

import java.sql.Date;

/**
 * 
 * @author Gunnar Már Harðarson
 * @date október 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 *
 * BanquetBookings klasi inniheldur auðkennisnúmer, nafn, kennitölu,
 * póstfang, símanúmer og veislusalsnúmer fyrir bókanir á veislusal
 */

public class BanquetBookings {
	private int id;
	private String name;
	private long kennitala;
	private String email;
	private int phonenr;
	private int banquetnumber;
	private String date;
	
	public BanquetBookings(String name, long kennitala, String email,
							int phonenr, int banquetnumber, String dags) {
		this.name = name;
		this.kennitala = kennitala;
		this.email = email;
		this.phonenr = phonenr;
		this.banquetnumber = banquetnumber;
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
	
	public int getBanquetnumber() {
		return banquetnumber;
	}
	
	public void setBanquetnumber(int banquetnumber) {
		this.banquetnumber = banquetnumber;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String dags) {
		this.date = dags;
	}
}
