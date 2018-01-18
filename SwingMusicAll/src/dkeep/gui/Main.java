package dkeep.gui;

import java.awt.Window;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import dkeep.client.Client;

/**
 * This Class controls the GUI page changes
 *
 */
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
	public static ThisAlbum thisalbum;
	public static ThisPlaylist thisplaylist;

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
		//shut down possible window
		register.frame.setVisible(false);
		artists.frame.setVisible(false);
		albuns.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		songs.frame.setVisible(false);
		logged.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		//set current frame visible
		notlogged.frame.setVisible(true);
		//reset tables
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
		
	}
	public void goToRegister() {
		notlogged.frame.setVisible(false);
		register.frame.setVisible(true);
	}
	public void goToHomepage() {
		//shut down possible window
		notlogged.frame.setVisible(false);
		artists.frame.setVisible(false);
		albuns.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		songs.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		thisalbum.frame.setVisible(false);
		//set current frame visible
		logged.frame.setVisible(true);
		//set names
		logged.user_name.setText(user.username);
		//reset tables
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
	}
	public void goToArtists() {
		//shut down possible window
		logged.frame.setVisible(false);
		albuns.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		songs.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		thisalbum.frame.setVisible(false);
		//set current frame visible
		artists.frame.setVisible(true);
		//set names
		artists.user_name.setText(user.username);
		//reset tables
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
		
	}
	public void goToSongs() {
		//
		logged.frame.setVisible(false);
		albuns.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		artists.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		thisalbum.frame.setVisible(false);
		//
		songs.frame.setVisible(true);
		//set name
		songs.user_name.setText(user.username);
		//reset tables
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
	}
	public void goToAlbuns() {
		//
		logged.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		artists.frame.setVisible(false);
		songs.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		thisalbum.frame.setVisible(false);
		//
		albuns.frame.setVisible(true);
		albuns.user_name.setText(user.username);
		//reset tables
		artists.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
	}
	public void goToThisAlbum() {
		albuns.frame.setVisible(false);
		thisalbum.frame.setVisible(true);
		//
		thisalbum.user_name.setText(user.username);
		
		albuns.tableModel.setRowCount(0);
		
	}
	public void goToLastPlayed() {
		logged.frame.setVisible(false);
		lastplayed.frame.setVisible(true);
	}
	public void goToCreatePlaylist() {
		//
		logged.frame.setVisible(false);
		artists.frame.setVisible(false);
		albuns.frame.setVisible(false);
		songs.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		//
		createplaylist.frame.setVisible(true);
		createplaylist.username.setText(user.username);
		//reset tables
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
	}
	public void goToMyPlaylists() {
		//
		logged.frame.setVisible(false);
		artists.frame.setVisible(false);
		albuns.frame.setVisible(false);
		songs.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		thisplaylist.frame.setVisible(false);
		thisalbum.frame.setVisible(false);
		//
		myplaylists.frame.setVisible(true);
		myplaylists.user_name.setText(user.username);
		////reset tables
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		thisplaylist.tableModel.setRowCount(0);
	}
	public void goToThisPlaylist() {
		logged.frame.setVisible(false);
		artists.frame.setVisible(false);
		albuns.frame.setVisible(false);
		songs.frame.setVisible(false);
		createplaylist.frame.setVisible(false);
		myplaylists.frame.setVisible(false);
		thisalbum.frame.setVisible(false);
		//set names
		thisplaylist.user_name.setText(user.username);
		thisplaylist.frame.setVisible(true);
		////reset tables
		artists.tableModel.setRowCount(0);
		albuns.tableModel.setRowCount(0);
		songs.tableModel.setRowCount(0);
		thisalbum.tableModel.setRowCount(0);
		myplaylists.tableModel.setRowCount(0);
	}
	public void refreshPage() {
		//thisplaylist.tableModel.setRowCount(0);
		thisplaylist.frame.repaint();
		
	}

	
	
}
