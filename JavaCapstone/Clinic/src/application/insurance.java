package application;

public class insurance {
	private int ins_id;
	private String ins_name;
	private String ins_contact;
	private int phone;
	private int claim_address;

	public insurance(int ins_id, String ins_name, String ins_contact, int phone, int claim_address) {
		this.ins_id = ins_id;
		this.ins_name = ins_name;
		this.ins_contact = ins_contact;
		this.phone = phone;
		this.claim_address = claim_address;
	}

	public int getIns_id() {
		return ins_id;
	}

	public void setIns_id(int ins_id) {
		this.ins_id = ins_id;
	}

	public String getIns_name() {
		return ins_name;
	}

	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}

	public String getIns_contact() {
		return ins_contact;
	}

	public void setIns_contact(String ins_contact) {
		this.ins_contact = ins_contact;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getClaim_address() {
		return claim_address;
	}

	public void setClaim_address(int claim_address) {
		this.claim_address = claim_address;
	}

}
