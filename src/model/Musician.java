package model;

public class Musician {
	private int m_ssn;
	private String name;
	private String home_address;
	
	
	public Musician(int m_ssn, String name, String home_address) {
		this.m_ssn = m_ssn;
		this.name = name;
		this.home_address = home_address;
	
	}

	public int getM_ssn() {
		return m_ssn;
	}

	public void setM_ssn(int m_ssn) {
		this.m_ssn = m_ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeAddress() {
		return home_address;
	}

	public void setHomeAddress(String home_address) {
		this.home_address = home_address;
	}

}
