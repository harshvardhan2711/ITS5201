package application;

public class person {
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String postalcode;
	private int phonenumber;

	public person() {

	}

	public person(String firstname, String lastname, String address, String city, String state, String postalcode,
			int phonenumber) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
		this.phonenumber = phonenumber;

	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getstate() {
		return state;

	}

	public void setstate(String state) {
		this.state = state;
	}

	public void setpostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getpostalcode() {
		return postalcode;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "the person is " + this.firstname + " " + this.lastname + " and his address is " + this.address + " "
				+ this.city + " " + this.state + " " + this.postalcode + " " + "and his phone number is "
				+ this.phonenumber;
	}

}
