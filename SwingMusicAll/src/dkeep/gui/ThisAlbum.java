package dkeep.gui;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThisAlbum extends Main {

	protected JFrame frame;
	private JTextField txtSearch;
	protected JLabel user_name;
	protected JLabel album_name;
	protected JLabel artist_name;
	protected JLabel album_year;
	private JTable table;
	protected String[] col = {"Id","Name","Genre","Duration","Key","BPM"};
	public DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
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
					ThisAlbum window = new ThisAlbum();
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
	public ThisAlbum() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 102, 51));
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 102, 51));
		panel.setBounds(16, 81, 151, 332);
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][][][][][][]"));
		
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
		btnArtists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToArtists();
				user.run("ARTS ALL");
			}
		});
		panel.add(btnArtists, "cell 0 3,alignx left");
		
		JLabel lblPlaylists = new JLabel("Playlists");
		panel.add(lblPlaylists, "cell 0 4");
		
		JButton MyPlaylists = new JButton("My Playlists");
		MyPlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMyPlaylists();
				user.run("PLAYLST "+user.username);
			}
		});
		
		panel.add(MyPlaylists, "cell 0 6");
		
		JButton CreatePlaylist = new JButton("Create Playlist");
		CreatePlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToCreatePlaylist();
			}
		});
		panel.add(CreatePlaylist, "cell 0 8");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 102, 51));
		panel_1.setBounds(16, 16, 866, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToHomepage();
			}
		});
		btnHome.setBounds(16, 16, 81, 29);
		panel_1.add(btnHome);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(128, 16, 73, 26);
		txtSearch.setText("Search");
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToLogin();
			}
		});
		btnLogOut.setBounds(758, 16, 92, 29);
		panel_1.add(btnLogOut);
		
		user_name = new JLabel();
		user_name.setBounds(663, 21, 61, 16);
		panel_1.add(user_name);
		
		album_name = new JLabel();
		album_name.setFont(new Font("Orator Std", Font.BOLD, 25));
		album_name.setBounds(220, 112, 300, 61);
		frame.getContentPane().add(album_name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 196, 586, 182);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblBy = new JLabel("By");
		lblBy.setFont(new Font("Orator Std", Font.PLAIN, 20));
		lblBy.setBounds(566, 125, 61, 34);
		frame.getContentPane().add(lblBy);
		
		artist_name = new JLabel();
		artist_name.setFont(new Font("Orator Std", Font.BOLD, 25));
		artist_name.setBounds(639, 112, 211, 61);
		frame.getContentPane().add(artist_name);
		
		album_year = new JLabel();
		album_year.setFont(new Font("Orator Std", Font.BOLD, 13));
		album_year.setBounds(789, 180, 61, 16);
		frame.getContentPane().add(album_year);
		
		
		
	}
}
