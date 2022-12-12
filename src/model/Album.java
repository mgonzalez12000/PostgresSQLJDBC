package model;

import java.sql.Date;

public class Album {
	private String format;
	private int unique_id;
	private String title;
	private Date copyright_date;
	private int album_id;
	private int musician_SSN;
	public Album(String format, int unique_id, String title, Date copyright_date, int album_id, int musician_SSN) {
		this.format = format;
		this.unique_id = unique_id;
		this.title = title;
		this.copyright_date = copyright_date;
		this.album_id = album_id;
		this.musician_SSN = musician_SSN;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCopyright_date() {
		return copyright_date;
	}
	public void setCopyright_date(Date copyright_date) {
		this.copyright_date = copyright_date;
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public int getMusician_SSN() {
		return musician_SSN;
	}
	public void setMusician_SSN(int musician_SSN) {
		this.musician_SSN = musician_SSN;
	}
	

}
