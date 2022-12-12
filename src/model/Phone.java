package model;

public class Phone {
	private String phone_num;
	private String home_address;
	
	public Phone(String phone_num, String home_address) {
		this.phone_num = phone_num;
		this.home_address = home_address;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	
	

}
