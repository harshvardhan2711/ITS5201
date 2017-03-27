package application;

import java.sql.Date;

public class patient extends person {
	private int patient_id;
	private Date birthdate;

	public patient() {

	}

	public patient(String firstname, String lastname, String address, String city, String state, String postalcode,
			int phonenumber, int patient_id, Date birthdate) {
		super(firstname, lastname, address, city, state, postalcode, phonenumber);
		this.setPatient_id(patient_id);
		this.setBirthdate(birthdate);
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
