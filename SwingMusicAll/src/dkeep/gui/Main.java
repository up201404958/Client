package dkeep.gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import dkeep.client.Client;

/**
 * This Class controls the GUI page changes
 *
 */
public class Main {

	protected String username;
	public MusicThread Song;
	protected static ArrayList<String> lastplay;
	public static Logged logged;
	public static NotLogged notlogged;
	public static Register register;
	public static CreatePlaylist createplaylist;
	public static LastPlayed lastplayed;
	public static Songs songs;
	public static Albuns albuns;
	public static Artists artists;
	public static MyPlaylists myplaylists;
	public static MySongs mysongs;
	public static ThisAlbum thisalbum;
	public static ThisPlaylist thisplaylist;
	

	public static Client user = new Client();
	
	public static void main(String[] args) throws IOException {
		
		lastplay = new ArrayList<String>();
		logged = new Logged();
		notlogged = new NotLogged();
		register = new Register();
		songs = new Songs();
		artists = new Artists();
		albuns = new Albuns();
		lastplayed = new LastPlayed();
		createplaylist = new CreatePlaylist();
		myplaylists = new MyPlaylists();
		mysongs = new MySongs();
		thisalbum = new ThisAlbum();
		thisplaylist = new ThisPlaylist();
		//starting page
		user.goToLogin();
		
	}
	public void setUser(String user) {
		this.username=user;
	}
	public String getUser() {
		return this.username;
	}
	public void goToLogin() {
		
		register.frame.setVisible(false);
		artists.frame.setVisible(false);
		albuns.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		songs.frame.setVisible(false);
		logged.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		mysongs.frame.setVisible(false);
		//set current frame visible
		notlogged.frame.setVisible(true);
		//reset tables
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
		mysongs.tableModel.setRowCount(0);
	}
	public void goToRegister() {
		notlogged.frame.setVisible(false);
		register.frame.setVisible(true);
	}
	public void goToHomepage() {
		
		//shut down possible window
		this.changeWindow(logged.frame);
		//set names
		logged.user_name.setText(user.username);
		//reset tables
		this.resetTables();
		
	}
	public void goToArtists() {
		
		this.changeWindow(artists.frame);
		//set names
		artists.user_name.setText(user.username);
		//reset tables
		this.resetTables();
	}
	public void goToSongs() {
		
		this.changeWindow(songs.frame);
		//set name
		songs.user_name.setText(user.username);
		//reset tables
		this.resetTables();
	}
	public void goToAlbuns() {
		
		this.changeWindow(albuns.frame);
		albuns.user_name.setText(user.username);
		this.resetTables();
	}
	public void goToThisAlbum() {
		this.changeWindow(thisalbum.frame);
		//
		thisalbum.user_name.setText(user.username);
		
		this.resetTables();
		
	}
	public void goToLastPlayed() {
		this.changeWindow(lastplayed.frame);
		lastplayed.user_name.setText(user.username);
		this.resetTables();
	}
	public void goToCreatePlaylist() {
		//
		this.changeWindow(createplaylist.frame);
		createplaylist.username.setText(user.username);
		//reset tables
		this.resetTables();
	}
	public void goToMyPlaylists() {
		//
		this.changeWindow(myplaylists.frame);
		myplaylists.user_name.setText(user.username);
		this.resetTables();
	}
	public void goToMySongs() {
		//
		this.changeWindow(mysongs.frame);
		mysongs.user_name.setText(user.username);
		this.resetTables();
	}
	public void goToThisPlaylist() {
		
		this.changeWindow(thisplaylist.frame);
		thisplaylist.user_name.setText(user.username);
		////reset tables
		this.resetTables();

	}

	public void changeWindow(JFrame change){
		notlogged.frame.setVisible(false);
		logged.frame.setVisible(false);
		register.frame.setVisible(false);
		artists.frame.setVisible(false);
		albuns.frame.setVisible(false);
		songs.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		mysongs.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		lastplayed.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		thisalbum.frame.setVisible(false);
		change.setVisible(true);
	}
	
	public void resetTables() {
		
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
		mysongs.tableModel.setRowCount(0);
		lastplayed.tableModel.setRowCount(0);
		
	}
}
