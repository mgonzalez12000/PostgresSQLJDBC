package model;

public class Song {
	private String title;
	private String author;
	private int album_unique_id;
	
	public Song(String title, String author, int album_unique_id) {
		this.title = title;
		this.author = author;
		this.album_unique_id = album_unique_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAlbum_unique_id() {
		return album_unique_id;
	}

	public void setAlbum_unique_id(int album_unique_id) {
		this.album_unique_id = album_unique_id;
	}
}
