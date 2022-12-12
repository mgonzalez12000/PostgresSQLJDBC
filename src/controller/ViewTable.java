package controller;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.Album;
import model.Home;
import model.Instrument;
import model.Musician;
import model.Performs;
import model.Phone;
import model.Plays;
import model.Song;
import service.DbService;

public class ViewTable {

	public static void main(String[] args) {

		DbService d = new DbService();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);


		//		System.out.println("Enter: ");
		int choice;
		//		System.out.println("Entered option " + choice + "\n");




		do {
			showMenu();
			System.out.println("Enter: ");
			choice = input.nextInt();

			switch (choice) {
				case 0: {
					System.exit(0);
				}
				case 1: {
					displayAllTables(d);
					break;
				}
				case 2:{
					addMusician(input, d);
					break;
				}
				case 3:{
					removeMusician(input, d);
					break;
				}
				case 4:{
					addAlbum(input, d);
					break;
				}
				case 5:{
					removeAlbum(input, d);
					break;
				}
				case 6:{
					addSong(input, d);
					break;
				}
				case 7:{
					removeSong(input, d);
					break;
				}
				case 8:{
					showCdAlbum(d);
					break;
				}
				case 9:{
					showTotalSongs(d);
					break;
				}
				default:
					System.out.println("Incorrect value entered");

			}
			System.out.println("Entered option " + choice + "\n");


		}while (choice != 0);
		
	}
	public static void showMenu() {
		System.out.println(" ___________________________");
		System.out.println("|    O: EXIT                |");
		System.out.println("|    1: Show all tables     |");
		System.out.println("|    2: Add Musician        |");
		System.out.println("|    3: Remove Musician     |");
		System.out.println("|    4: Add Album           |");
		System.out.println("|    5: Remove Album        |");
		System.out.println("|    6: Add Song            |");
		System.out.println("|    7: Remove Song         |");
		System.out.println("|    8: cdAlbum()           |");
		System.out.println("|    9: totalSongs()        |");
		System.out.println("|___________________________|");

	}
	public static void showCdAlbum(DbService d) { 
		System.out.println("The percentage of cd albums are " +  String.format("%.2f", d.getCdAlbum()) + "%");
	}
	public static void showTotalSongs(DbService d) {
		System.out.println("The total number of songs are " + d.getTotalSongs());
	}
	public static void displayAllTables(DbService dbService) {
		
		List<Musician> musician = dbService.getMusicians();


		System.out.println("DISPLAYING ALL TABLES: ");
		System.out.print("Musicians Table\n");
		System.out.printf("|%-25s | %-25s | %-25s %n", "SSN", "NAME", "HOME ADDRESS");
		System.out.println("--------------------------------------------------------------------------------------------------------------");


		for(int i = 0; i < musician.size(); i++) {
			System.out.printf("|%-25s | %-25s | %-25s %n", musician.get(i).getM_ssn(), musician.get(i).getName(), musician.get(i).getHomeAddress());
			//System.out.printf("SSN: " + musician.get(i).getM_ssn() + " | Name: " + musician.get(i).getName() + " | Address: " + musician.get(i).getHomeAddress());

		}

		System.out.println("--------------------------------------------------------------------------------------------------------------");
		List<Instrument> instrument = dbService.getInstruments();

		System.out.println("Instrument Table");
		System.out.printf("|%-25s | %-25s | %-25s %n", "ID", "NAME", "MUSICAL KEY");
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < instrument.size(); i++) {
			System.out.printf("|%-25s | %-25s | %-25s %n",instrument.get(i).getInst_id(), instrument.get(i).getName(), instrument.get(i).getMusical_key());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Album Table");
		List<Album> album = dbService.getAlbum();
		System.out.printf("|%-25s | %-25s | %-25s |%-25s | %-25s | %-25s %n", "FORMAT", "UNIQUE_ID", "TITLE", "COPYRIGHT DATE", "ALBUM ID", "MUSICIAN SSN");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < album.size(); i++) {
			System.out.printf("|%-25s | %-25s | %-25s |%-25s | %-25s | %-25s %n", album.get(i).getFormat(), album.get(i).getUnique_id(), album.get(i).getTitle(),  album.get(i).getCopyright_date(), album.get(i).getAlbum_id(), album.get(i).getMusician_SSN());
		}

		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");

		List<Song> song = dbService.getSongs();

		System.out.println("Songs Table");
		System.out.printf("|%-25s | %-25s | %-25s %n", "TITLE", "AUTHOR", "ALBUM_UNIQUE_ID");
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < song.size(); i++) {
			System.out.printf("|%-25s | %-25s | %-25s %n",song.get(i).getTitle(), song.get(i).getAuthor(), song.get(i).getAlbum_unique_id());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		List<Home> home = dbService.getHome();

		System.out.println("Home Table");
		System.out.printf("|%-25s %n", "ADDRESS");
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < home.size(); i++) {
			System.out.printf("|%-25s %n", home.get(i).getAddress());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		List<Phone> phone = dbService.getPhone();

		System.out.println("Phone Table");
		System.out.printf("|%-25s |%-25s %n", "PHONE_NUM", "ADDRESS");
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < phone.size(); i++) {
			System.out.printf("|%-25s |%-25s %n", phone.get(i).getPhone_num(), phone.get(i).getHome_address());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------");



		List<Plays> plays = dbService.getPlays();

		System.out.println("Plays Table");
		System.out.printf("|%-25s |%-25s %n", "MUSICAL_SSN", "INST_ID");
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < plays.size(); i++) {
			System.out.printf("|%-25s |%-25s %n",plays.get(i).getMusician_ssn(), plays.get(i).getInst_id());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		List<Performs> performs = dbService.getPerforms();

		System.out.println("Performs Table");
		System.out.printf("|%-25s |%-25s %n", "MUSICAL_SSN", "SONG_TITLE");
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < performs.size(); i++) {
			System.out.printf("|%-25s |%-25s %n",performs.get(i).getMusician_ssn(), performs.get(i).getSong_title());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------");
	}


	public static void addMusician(Scanner i, DbService d) {
		int ssn;
		String name;
		String address;
		System.out.println("ADD Musician\n");
		System.out.println("Enter the SSN: ");
		ssn = i.nextInt();
		i.nextLine();
		System.out.println("SSN entered: " + ssn);
		System.out.println("Enter the Name: ");
		name = i.nextLine();
		//i.nextLine();
		System.out.println("Name entered: " + name);
		System.out.println("Enter the Home Address: ");
		address = i.nextLine();
		System.out.println("Home Address entered: " + address + "\n");
		d.addHome(address);
		d.addMusician(ssn, name, address);
		
	}
	public static void removeMusician(Scanner i, DbService d) {
		int ssn;
		String phoneNum;
		String address;
		System.out.println("Enter SSN of Musician to delete");
		ssn = i.nextInt();
		
		phoneNum = d.getPhoneNum(ssn);
		address = d.getAddress(ssn);
		
//		//Remove Musician
//		//1. Check to see if their are any musicians in the plays table
		d.deleteFromPlaysTable(ssn);
//		//2. check to see if their are any musicians in performs table
		d.deletePerformsTableWithSSN(ssn);
//		//3. check to see if their are any musicians with the song from the album (album made by musician)
		d.deleteSongWithMusicianSSN(ssn);
//		//4. Album
		d.deleteMusicianFromAlbum(ssn);
		d.deleteMusician(ssn);
		
		d.deletePhone(phoneNum);
		d.deleteHome(address);
		// delete musician from album table if musician has an album
		//test with ssn 624972441
		
	}
	public static void addAlbum(Scanner i, DbService d) {
        String format;
        int uniqueId;
        String title;
        Date copyrightDate;
        String copyrightDateStr;
        int albumId;
        int musician_ssn;

        System.out.println("ADD Album\n");

        System.out.println("Enter the format: ");
        format = i.next();
        System.out.println("format entered: " + format);

        System.out.println("Enter the unique id: ");
        uniqueId = i.nextInt();
        i.nextLine();
        
        System.out.println("unique ID entered: " + uniqueId);


        System.out.println("Enter the tile of the album: ");
        title = i.nextLine();
        System.out.println("You entered the title album: " + title + "\n");

        
        System.out.println("Enter the copyright date of the album: ");
        copyrightDateStr = i.nextLine();
        System.out.println("You entered the copyright date: " + copyrightDateStr + "\n");

        System.out.println("Enter the album_id of the album: ");
        albumId = i.nextInt();
        System.out.println("You entered the album ID: " + albumId + "\n");

        System.out.println("Enter the musician SSN of the album: ");
        musician_ssn = i.nextInt();
        System.out.println("You entered the musician SSN: " + musician_ssn + "\n");
        
        copyrightDate=Date.valueOf(copyrightDateStr);//converting string into sql date  
        System.out.println(copyrightDate);

      d.addAlbum(format, uniqueId, title, copyrightDate, albumId, musician_ssn);

    }
	public static void removeAlbum(Scanner i, DbService d) {
		//remove using unique_id
		int unique_id;
		System.out.println("Enter the unique_id of the album to delete");
		unique_id = i.nextInt();
		
		//delete the performs entries that are associated with the songs
		d.deleteFromPerformsTableFromTheSongsTable(unique_id);
		
		//delete all the songs that have this unique album id
		d.deleteSongWithAlbumId(unique_id);
		
		
		//finally delete the album
		d.deleteAlbum(unique_id);
	}
	public static void addSong(Scanner i, DbService d) {
		String songTitle;
		String author;
		int albumUniqueId;
		System.out.println("ADD Song\n");
		
		System.out.println("Enter the album unique ID: ");
		albumUniqueId = i.nextInt();
		System.out.println("Unique ID entered: " + albumUniqueId + "\n");
		
		i.nextLine();
		
		System.out.println("Enter the song title: ");
		songTitle = i.nextLine();
		System.out.println("Song title entered: " + songTitle);
		
		System.out.println("Enter the name of the author: ");
		author = i.nextLine();
		System.out.println("Author name entered: " + author);
		
	
		
		d.addSong(songTitle, author, albumUniqueId);
		//when we add a song we also have to add it to the performs table
		int ssn = d.getSSNFromUniqueId(albumUniqueId);
		d.addToPerformsTable(ssn, songTitle);
	}
	public static void removeSong(Scanner i, DbService d) {
		// remove from song means delete from song and perfoms table
        String title;
        i.nextLine();
        System.out.println("REMOVE Song\n");
        System.out.println("Enter the title of the song that you want to remove");
        title = i.nextLine();
        System.out.println("Deleting... " + title);
        d.deletePerformsTableFromSong(title);
        d.deleteSong(title);
    }

}
// case 3 prints 