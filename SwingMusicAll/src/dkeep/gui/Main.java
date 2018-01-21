package dkeep.gui;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import dkeep.client.Client;


/**
 * This Class controls the GUI page changes and reset the tables so there is never duplicated results on tables
 * Most of its methods are self explanatory
 *
 */
public class Main {

	protected String username;
	protected MusicThread Song = null;
	protected static ArrayList<String> lastplay;
	protected static Logged logged;
	protected static NotLogged notlogged;
	protected static Register register;
	protected static CreatePlaylist createplaylist;
	protected static LastPlayed lastplayed;
	protected static Songs songs;
	protected static Albuns albuns;
	protected static Artists artists;
	protected static MyPlaylists myplaylists;
	protected static MySongs mysongs;
	protected static ThisAlbum thisalbum;
	protected static ThisPlaylist thisplaylist;
	
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
	
	public void goToLogin() {
		this.changeWindow(notlogged.frame);
		this.resetTables();
	}
	public void goToRegister() {
		this.changeWindow(register.frame);
	}
	public void goToHomepage() {
		this.changeWindow(logged.frame);
		logged.user_name.setText(user.username);
		this.resetTables();
	}
	public void goToArtists() {
		this.changeWindow(artists.frame);
		artists.user_name.setText(user.username);
		this.resetTables();
		user.run("ARTS ALL");
	}
	public void goToSongs() {
		this.changeWindow(songs.frame);
		songs.user_name.setText(user.username);
		this.resetTables();
		user.run("SNGS ALL");
		user.run("SNGPLST "+user.username);
	}
	public void goToAlbuns() {
		this.changeWindow(albuns.frame);
		albuns.user_name.setText(user.username);
		this.resetTables();
		user.run("ALBS ALL");
	}
	public void goToThisAlbum() {
		this.changeWindow(thisalbum.frame);
		thisalbum.user_name.setText(user.username);
		this.resetTables();
	}
	public void goToLastPlayed() {
		this.changeWindow(lastplayed.frame);
		lastplayed.user_name.setText(user.username);
		this.resetTables();
		int size = lastplay.size()-1;
		if(size > 0) {
			for(int i=size;i>=0;i--) {
				String[] this_row = lastplay.get(i).split(",");
				Object[] row = {this_row[0],this_row[1],this_row[2],this_row[3],this_row[4],this_row[5]};
				lastplayed.tableModel.addRow(row);
			}
		}
	}
	public void goToCreatePlaylist() {
		this.changeWindow(createplaylist.frame);
		createplaylist.username.setText(user.username);
		this.resetTables();
	}
	public void goToMyPlaylists() {
		this.changeWindow(myplaylists.frame);
		myplaylists.user_name.setText(user.username);
		this.resetTables();
		user.run("PLAYLST "+user.username);
	}
	public void goToMySongs() {
		this.changeWindow(mysongs.frame);
		mysongs.user_name.setText(user.username);
		this.resetTables();
		user.run("MYSNGS "+user.username);
		user.run("SNGPLST "+user.username);
	}
	public void goToThisPlaylist() {
		this.changeWindow(thisplaylist.frame);
		thisplaylist.user_name.setText(user.username);
		this.resetTables();
	}
	/**
	 * this method turns off every frame and sets visible the specific frame passed to the method
	 * @param change frame to be activated
	 */
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
	/**
	 * this method resets all the tables
	 */
	public void resetTables() {
		artists.getTableModel().setRowCount(0);
		albuns.getTableModel().setRowCount(0);
		songs.getTableModel().setRowCount(0);
		myplaylists.getTableModel().setRowCount(0);
		thisalbum.getTableModel().setRowCount(0);
		thisplaylist.getTableModel().setRowCount(0);
		mysongs.getTableModel().setRowCount(0);
		lastplayed.tableModel.setRowCount(0);
	}
	
	public void setUser(String user) {
		this.username=user;
	}
	public String getUser() {
		return this.username;
	}
	public JFrame getHomepage() {
		return Main.logged.frame;
	}
	public JFrame getLogin() {
		return Main.notlogged.frame;
	}
}
