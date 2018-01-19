package dkeep.gui;

import java.awt.EventQueue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CreatePlaylist extends Main{

	public JFrame frame;
	private JTextField txtAddusername;
	private JTextField txtLol;
	protected JLabel username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePlaylist window = new CreatePlaylist();
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
	public CreatePlaylist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 102));
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 102));
		panel_1.setBounds(16, 16, 219, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToHomepage();
			}
		});
		btnNewButton.setBounds(16, 26, 89, 29);
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 102));
		panel.setBounds(16, 81, 172, 326);
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][]"));
		
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
		
		JButton btnMyPlaylists = new JButton("My Playlists");
		btnMyPlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMyPlaylists();
				user.run("PLAYLST "+user.username);
			}
		});
		panel.add(btnMyPlaylists, "cell 0 5");
		
		JButton btnCreatePlaylists = new JButton("Create Playlist");
		panel.add(btnCreatePlaylists, "cell 0 6");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 153, 102));
		panel_2.setBounds(239, 123, 830, 242);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new MigLayout("", "[106px,grow][grow][][][][grow][][][][][grow][-2.00][13.00][][20.00][156.00][][][][86px][][-56.00][][-23.00][][][-27.00][grow][][][]", "[20px,grow][][][grow][20px][][22.00px,grow,top][][grow][grow]"));
		
		JLabel lblEnterPlaylistName = new JLabel("ENTER PLAYLIST NAME");
		panel_2.add(lblEnterPlaylistName, "cell 3 2");
		
		JButton btnAdd = new JButton("Create");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = txtLol.getText();
				user.run("CREATE "+name+" "+user.username);
				frame.repaint();
			}
		});
		
		txtLol = new JTextField();
		txtLol.setText("lol");
		panel_2.add(txtLol, "cell 5 2,growx");
		txtLol.setColumns(10);
		
		panel_2.add(btnAdd, "cell 10 2");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 153, 102));
		panel_2.add(panel_3, "cell 0 6 20 1,grow");
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{101, 106, 0, 106, 101, 61, 123, 126, 0};
		gbl_panel_3.rowHeights = new int[]{30, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblSharedWith = new JLabel("   Shared with:");
		GridBagConstraints gbc_lblSharedWith = new GridBagConstraints();
		gbc_lblSharedWith.anchor = GridBagConstraints.WEST;
		gbc_lblSharedWith.insets = new Insets(0, 0, 0, 5);
		gbc_lblSharedWith.gridx = 1;
		gbc_lblSharedWith.gridy = 0;
		panel_3.add(lblSharedWith, gbc_lblSharedWith);
		
		txtAddusername = new JTextField();
		txtAddusername.setText("add username");
		GridBagConstraints gbc_txtAddusername = new GridBagConstraints();
		gbc_txtAddusername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddusername.insets = new Insets(0, 0, 0, 5);
		gbc_txtAddusername.gridx = 3;
		gbc_txtAddusername.gridy = 0;
		panel_3.add(txtAddusername, gbc_txtAddusername);
		txtAddusername.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 153, 102));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 7;
		gbc_panel_4.gridy = 0;
		panel_3.add(panel_4, gbc_panel_4);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToLogin();
			}
		});
		btnLogOut.setBounds(787, 31, 92, 29);
		frame.getContentPane().add(btnLogOut);
		JLabel lblDownloads = new JLabel("Downloads");
		panel.add(lblDownloads, "cell 0 7");
		JButton mySongs = new JButton("My Songs");
		mySongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.run("MYSNGS "+user.username);
				user.run("SNGPLST "+user.username);
				user.goToMySongs();
			}
		});
		panel.add(mySongs, "cell 0 8");
		username = new JLabel();
		username.setBounds(688, 36, 61, 16);
		frame.getContentPane().add(username);

	}
}
