package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Home;
import model.Instrument;
import model.Musician;
import model.Performs;
import model.Phone;
import model.Plays;
import model.Song;

public class DbService {
	private final String url = "jdbc:postgresql://cs1.calstatela.edu/";
	private final String user = "User";
	private final String password = "Pass";
	
	public List<Musician> getMusicians(){
		List<Musician> musicians = new ArrayList<Musician>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Musician;");
			while(rs.next()) {
				int ssn = rs.getInt("ssn");
				String name = rs.getString("name");
				String home_address = rs.getString("home_address");
				Musician m = new Musician(ssn, name, home_address);
				musicians.add(m);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return musicians;
	}
	public List<Instrument> getInstruments(){
		List<Instrument> instrument = new ArrayList<Instrument>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Instrument;");
			while(rs.next()) {
				int inst_id = rs.getInt("inst_id");
				String name = rs.getString("name");
				String musical_key = rs.getString("musical_key");
				Instrument i = new Instrument(inst_id, name, musical_key);
				instrument.add(i);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return instrument;
	}
	public List<Album> getAlbum(){
		List<Album> album = new ArrayList<Album>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Album;");
			while(rs.next()) {
				String format = rs.getString("format");
				int unique_id = rs.getInt("unique_id");
				String title = rs.getString("title");
				Date copyright_date = rs.getDate("copyright_date");
				int album_id = rs.getInt("album_id");
				int musician_SSN = rs.getInt("musician_SSN");
				Album a = new Album(format, unique_id, title, copyright_date, album_id, musician_SSN);
				album.add(a);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return album;
	}
	public List<Song> getSongs(){
		List<Song> song = new ArrayList<Song>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Song;");
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				int album_unique_id = rs.getInt("album_unique_id");
				Song s = new Song(title, author, album_unique_id);
				song.add(s);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return song;
	}
	public List<Home> getHome(){
		List<Home> home = new ArrayList<Home>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Home;");
			while(rs.next()) {
				String address = rs.getString("address");
				Home h = new Home(address);
				home.add(h);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return home;
	}
	public List<Phone> getPhone(){
		List<Phone> phone = new ArrayList<Phone>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Phone;");
			while(rs.next()) {
				String phone_num = rs.getString("phone_num");
				String home_address = rs.getString("home_address");
				Phone p = new Phone(phone_num, home_address);
				phone.add(p);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return phone;
	}
	public List<Plays> getPlays(){
		List<Plays> plays = new ArrayList<Plays>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Plays;");
			while(rs.next()) {
				int musician_ssn = rs.getInt("musician_ssn");
				int inst_id = rs.getInt("inst_id");
				Plays p = new Plays(musician_ssn, inst_id);
				plays.add(p);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return plays;
	}
	public List<Performs> getPerforms(){
		List<Performs> performs = new ArrayList<Performs>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Performs;");
			while(rs.next()) {
				int musician_ssn = rs.getInt("musician_ssn");
				String song_title = rs.getString("song_title");
				Performs p = new Performs(musician_ssn, song_title);
				performs.add(p);	
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return performs;
	}
	public void addMusician(int snn, String name, String home) {
		 Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, password);

				PreparedStatement stmt = conn.prepareStatement("insert into Musician (ssn, name, home_address) values (?,?,?);");  
				stmt.setInt(1, snn);
				stmt.setString(2, name);
				stmt.setString(3, home);
				stmt.executeUpdate();
	            stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

	}
	public void addHome(String home) {
		 Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, password);

				PreparedStatement stmt = conn.prepareStatement("insert into Home (address) values (?);");  
				stmt.setString(1, home);
				stmt.executeUpdate();
	            stmt.close();
				conn.close();
			} catch (SQLException e) {
				// removing warning
//				System.out.println(e.getMessage());
			}

	}
	public void deleteMusician(int ssn) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			PreparedStatement stmt = conn.prepareStatement("delete from Musician where ssn = (?);");  
			stmt.setInt(1, ssn);
			stmt.executeUpdate();
            stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void deleteHome(String address) {
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(url, user, password);
			//String sql = "delete from home where address NOT IN (select home_address from Musician);";
			PreparedStatement stmt = conn.prepareStatement("delete from home where address = (?);");
			stmt.setString(1, address);
			stmt.executeUpdate();
            stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void addAlbum(String format, int uniqueId, String albumTitle, Date copyrightDateStr, int albumId, int musician_ssn) {
        Connection conn = null;
           try {
               conn = DriverManager.getConnection(url, user, password);

               PreparedStatement stmt = conn.prepareStatement("insert into Album (format, unique_id, title, copyright_date, album_id, musician_ssn) values (?, ?, ?, ?, ?, ?);");
               stmt.setString(1, format);
               stmt.setInt(2, uniqueId);
               stmt.setString(3, albumTitle);
               stmt.setDate(4, copyrightDateStr);
               stmt.setInt(5, albumId);
               stmt.setInt(6, musician_ssn);
               stmt.executeUpdate();
               stmt.close();
               conn.close();
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }

   }
	
	public void addSong(String songTitle, String author, int albumUniqueId) {
		 Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, password);

				PreparedStatement stmt = conn.prepareStatement("insert into song (title, author, album_unique_id) values (?, ?, ?);");  
				stmt.setString(1, songTitle);
				stmt.setString(2, author);
				stmt.setInt(3, albumUniqueId);
				stmt.executeUpdate();
	            stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

	}
	public void deleteAlbum(int uniqueid) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			PreparedStatement stmt = conn.prepareStatement("delete from Album where unique_id = (?);");  
			stmt.setInt(1, uniqueid);
			stmt.executeUpdate();
            stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
//	public void deleteAlbumWithMusician(int ssn) {
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url, user, password);
//
//			PreparedStatement stmt = conn.prepareStatement("delete from Album where musician_ssn = (?);");  
//			stmt.setInt(1, ssn);
//			stmt.executeUpdate();
//            stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//	}
	public void deleteSong(String title) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("delete from Song where title = (?);");  
            stmt.setString(1, title);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
	public void deleteSongWithAlbumId(int album_unique_id) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("delete from Song where album_unique_id = (?);");  
            stmt.setInt(1, album_unique_id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
	public void deleteSongWithMusicianSSN(int ssn) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            //select title from song where album_unique_id in (select unique_id from album where musician_ssn = 624972441)
            PreparedStatement stmt = conn.prepareStatement("delete from song where album_unique_id in (select unique_id from album where musician_ssn = (?)); ");  
            stmt.setInt(1, ssn);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("HERE");
        }
        
    }
	public void deletePerformsTableFromSong(String title) {
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("delete from Performs where song_title = (?);");  
            stmt.setString(1, title);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}
	public void deleteMusicianFromAlbum(int ssn) {
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("delete from Album where musician_ssn = (?);");  
            stmt.setInt(1, ssn);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}
	public void deleteFromPerformsTableFromTheSongsTable(int album_unique_id) {
		
		String s = "delete from performs where song_title in (select title from song where album_unique_id = (?));";
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(s);  
            stmt.setInt(1, album_unique_id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}
	public void deleteFromPlaysTable(int ssn) {
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("delete from Plays where musician_ssn = (?);");  
            stmt.setInt(1, ssn);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here");
        }
		
	}
	public void deletePerformsTableWithSSN(int ssn) {
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("delete from Performs where musician_ssn = (?);");  
            stmt.setInt(1, ssn);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR HERE WHEN DELETEING FOR PERFORMS TABLE");
        }
	}
	public void addToPerformsTable(int musician_ssn, String song_title) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);

			PreparedStatement stmt = conn.prepareStatement("insert into Performs (musician_ssn, song_title) values (?, ?);");  
			stmt.setInt(1, musician_ssn);
			stmt.setString(2, song_title);
			stmt.executeUpdate();
            stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public int getSSNFromUniqueId(int unique_id) {
		int ssn = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			 String query = "select musician_ssn from album where unique_id = " + unique_id + ";";
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 while (rs.next()) {
				 ssn = rs.getInt(1);
			 }
			 stmt.close();
			conn.close();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return ssn;
	}
	
	public double getCdAlbum() {
		double cdCount = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			 String query = "select cd_album();";
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 while (rs.next()) {
				 cdCount = rs.getDouble(1);
			 }
			 stmt.close();
			conn.close();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return cdCount;
	}
	public int getTotalSongs() {
		int totalSongs = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			 String query = "select total_songs();";
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 while (rs.next()) {
				 totalSongs = rs.getInt(1);
			 }
			 stmt.close();
			conn.close();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return totalSongs;
	}
	
	
//	public String getAddressFromSSN(int ssn) {
//		String address;
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(url, user, password);
//			 String query = "select home_address from home where phone_num = " + unique_id + ";";
//			 Statement stmt = conn.createStatement();
//			 ResultSet rs = stmt.executeQuery(query);
//			 while (rs.next()) {
//				 ssn = rs.getInt(1);
//			 }
//			
//		}catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		
//		return ssn;
//	}
	
	
	public void deletePhone(String phoneNum) {
		Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement("delete from phone where phone_num = (?);");  
            stmt.setString(1, phoneNum);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR");

        }
	}
	
	public String getPhoneNum(int ssn) {
		String phoneNum = "";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			 String query = "select phone_num from phone where home_address = (select home_address from musician where ssn = " + ssn + ");";
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 while (rs.next()) {
				 phoneNum = rs.getString(1);
			 }
			 stmt.close();
			conn.close();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return phoneNum;
	}
	public String getAddress(int ssn) {
		String address = "";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			 String query = "select address from Home where address = (select home_address from Musician where ssn = " + ssn + ");";
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 while (rs.next()) {
				 address = rs.getString(1);
			 }
			 
			 stmt.close();
			conn.close();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return address;
	}
	
	
	

}
