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

	public static Client user = new Client();
	
	public static void main(String[] args) throws IOException {
		
		
		logged = new Logged();
		notlogged = new NotLogged();
		register = new Register();
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
	}

	
	
}
