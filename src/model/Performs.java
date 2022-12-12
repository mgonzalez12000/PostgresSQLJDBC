package model;

public class Performs {
	
	private int musician_ssn;
	private String song_title;
	
	public Performs(int musician_ssn, String song_title) {
		this.musician_ssn = musician_ssn;
		this.song_title = song_title;
	}

	public int getMusician_ssn() {
		return musician_ssn;
	}

	public void setMusician_ssn(int musician_ssn) {
		this.musician_ssn = musician_ssn;
	}

	public String getSong_title() {
		return song_title;
	}

	public void setSong_title(String song_title) {
		this.song_title = song_title;
	}
	
	

}
