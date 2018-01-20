package dkeep.gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import net.miginfocom.swing.MigLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Color;

public class Artists extends Main{

	protected JFrame frame;
	protected JTable artists_table;
	protected String[] col = {"Artist Name","Country","Genre"};
	protected JLabel user_name;
	
	public DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		 public boolean isCellEditable(int row, int column)
		 {
		    return false;//This causes all cells to be not editable
		 }
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Artists window = new Artists();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Artists() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 204));
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(16, 81, 151, 332);
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][]"));
		
		JButton btnLastPlayed = new JButton("Last Played");
		panel.add(btnLastPlayed, "cell 0 0");
		
		JButton btnSongs = new JButton("Songs");
		btnSongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToSongs();
				user.run("SNGS ALL");
				user.run("SNGPLST "+user.username);
			}
		});
		panel.add(btnSongs, "cell 0 1");
		
		JButton btnAlbuns = new JButton("Albuns");
		btnAlbuns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToAlbuns();
				user.run("ALBS ALL");
			}
		});
		panel.add(btnAlbuns, "cell 0 2");
		
		JButton btnArtists = new JButton("Artists");
		panel.add(btnArtists, "cell 0 3,alignx left");
		
		JLabel lblPlaylists = new JLabel("Playlists");
		panel.add(lblPlaylists, "cell 0 4");
		
		JButton btnMyPlaylists = new JButton("My Playlists");
		btnMyPlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMyPlaylists();
				user.run("PLAYLST "+user.username);
			}
		});
		panel.add(btnMyPlaylists, "cell 0 5");
		
		JButton btnAddPlaylist = new JButton("Create Playlist");
		btnAddPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToCreatePlaylist();
			}
		});
		panel.add(btnAddPlaylist, "cell 0 6");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 204));
		panel_1.setBounds(16, 16, 866, 61);
		frame.getContentPane().add(panel_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(16, 16, 81, 29);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToHomepage();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnHome);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(758, 16, 92, 29);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToLogin();
			}
		});
		panel_1.add(btnLogOut);
		
		user_name = new JLabel();
		user_name.setFont(new Font("Orator Std", Font.BOLD, 17));
		user_name.setBounds(645, 21, 81, 26);
		panel_1.add(user_name);
		
	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 204, 204));
		panel_2.setBounds(189, 81, 693, 95);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblArtists = new JLabel("ARTISTS");
		lblArtists.setFont(new Font("Orator Std", Font.BOLD, 30));
		lblArtists.setBounds(229, 29, 126, 48);
		panel_2.add(lblArtists);
		Component scrTbl = null;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 213, 583, 106);
		frame.getContentPane().add(scrollPane);
		
		
		artists_table = new JTable(tableModel);
		scrollPane.setViewportView(artists_table);
		artists_table.add(new JScrollPane(scrTbl));
		
		JLabel lblDownloads = new JLabel("Downloads");
		panel.add(lblDownloads, "cell 0 7");
		JButton mySongs = new JButton("My Songs");
		mySongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMySongs();
				user.run("MYSNGS "+user.username);
				user.run("SNGPLST "+user.username);
			}
		});
		panel.add(mySongs, "cell 0 8");


	}
}
