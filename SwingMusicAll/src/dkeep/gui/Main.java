package dkeep.gui;

import java.awt.Window;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import dkeep.client.Client;

public class Main {

	protected String username;
	
	public static Logged logged;
	public static NotLogged notlogged;
	public static Register register;
	public static CreatePlaylist createplaylist;
	public static Search search;
	public static Playlist playlist;
	public static LastPlayed lastplayed;
	public static Songs songs;
	public static Albuns albuns;
	public static Artists artists;
	public static MyPlaylists myplaylists;

	public static Client user = new Client();
	
	public static void main(String[] args) throws IOException {
		
		//initialize frames
		logged = new Logged();
		notlogged = new NotLogged();
		register = new Register();
		songs = new Songs();
		artists = new Artists();
		albuns = new Albuns();
		lastplayed = new LastPlayed();
		createplaylist = new CreatePlaylist();
		myplaylists = new MyPlaylists();
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
		notlogged.frame.setVisible(true);
		//contemplate everywhere where we can logout
	}
	public void goToRegister() {
		notlogged.frame.setVisible(false);
		register.frame.setVisible(true);
	}
	public void goToHomepage() {
		notlogged.frame.setVisible(false);
		logged.frame.setVisible(true);
		logged.dtrpnUserName.setText(this.getUser());
		logged.dtrpnUserName_1.setText(this.getUser());
		
		//reset artists table
		artists.tableModel.setRowCount(0);
	}
	public void goToArtists() {
		logged.frame.setVisible(false);
		artists.frame.setVisible(true);
	}
	public void goToSongs() {
		logged.frame.setVisible(false);
		songs.frame.setVisible(true);
	}
	public void goToAlbuns() {
		logged.frame.setVisible(false);
		albuns.frame.setVisible(true);
	}
	public void goToLastPlayed() {
		logged.frame.setVisible(false);
		lastplayed.frame.setVisible(true);
	}
	public void goToCreatePlaylist() {
		logged.frame.setVisible(false);
		createplaylist.frame.setVisible(true);
	}
	public void goToMyPlaylists() {
		logged.frame.setVisible(false);
		myplaylists.frame.setVisible(true);
	}
	

	
	
}
