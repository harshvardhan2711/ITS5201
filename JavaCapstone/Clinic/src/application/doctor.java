package application;

public class doctor extends person {
	private int id_number;

	public doctor() {

	}

	public doctor(String firstname, String lastname, String address, String city, String state, String postalcode,
			int phonenumber, int id_number) {
		super(firstname, lastname, address, city, state, postalcode, phonenumber);
		this.setId_number(id_number);
	}

	public int getId_number() {
		return id_number;
	}

	public void setId_number(int id_number) {
		this.id_number = id_number;
	}

}
