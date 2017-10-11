package is.hi.byrjun.model;

/**
*
* @author Pétur Logi Pétursson
* @date september 2017
* HBV501G Hugbúnaðarverkefni 1
* Háskóli Íslands
* 
* Banquet klasi inniheldur veislusalsnúmer, nafn, staðsetningu, götuheiti,
* verð, fólksfjölda, símanúmer og póstfang fyrir veislusali
*/

public class Banquet {
	private int banquetnumber;
	private String name;
	private String location;
	private String streetAddrs;
	private int price;
	private int maxppl;
	private int phonenr;
	private String email;

	public Banquet(int idnr, String name, String loc, String address, int price,
			int max, int phone, String email) {
		this.banquetnumber = idnr;
		this.name = name;
		this.location = loc;
		this.streetAddrs = address;
		this.price = price;
		this.maxppl = max;
		this.phonenr = phone;
		this.email = email;
	}
	
	public int getId() {
		return banquetnumber;
	}
	
	public void setId(int idnr) {
		this.banquetnumber = idnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String input) {
		this.name = input;
	}

	public String getLocation() {
		return location;	
	}

	public void setLocation(String loc) {
		this.location = loc;
	}

	public String getAddress() {
		return streetAddrs;
	}

	public void setAddress(String addrs) {
		this.streetAddrs = addrs;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int input) {
		this.price = input;
	}

	public int getMax() {
		return maxppl;
	}

	public void setMax(int max) {
		this.maxppl = max;
	}

	public int getPhonenr() {
		return phonenr;
	}

	public void setPhonenr(int phone) {
		this.phonenr = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}
	
	@Override
	public String toString() { 
		return String.format("<BR>" + "Id:" + banquetnumber + "<BR>" + "Nafn:" + name + "<BR>" + "Location:" + location
				+ "<BR>" + "Address:" + streetAddrs + "<BR>" + "price:" + price + "<BR>" + "Max people:" + maxppl
				+ "<BR>" + "Phone nr:" + phonenr + "<BR>" + "e-mail:" + email);
	}
}
