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

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Playlist {

	private JFrame frame;
	private JTextField txtSearch;
	private JTextField txtAddusername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Playlist window = new Playlist();
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
	public Playlist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[101px][4px][680.00px]", "[37px][357px]"));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 1,alignx left,growy");
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][]"));
		
		JButton btnLastPlayed = new JButton("Last Played");
		panel.add(btnLastPlayed, "cell 0 0");
		
		JButton btnSongs = new JButton("Songs");
		panel.add(btnSongs, "cell 0 1");
		
		JButton btnAlbuns = new JButton("Albuns");
		panel.add(btnAlbuns, "cell 0 2");
		
		JButton btnArtists = new JButton("Artists");
		panel.add(btnArtists, "cell 0 3,alignx left");
		
		JLabel lblPlaylists = new JLabel("Playlists");
		panel.add(lblPlaylists, "cell 0 4");
		
		JButton btnWorkout = new JButton("Workout");
		panel.add(btnWorkout, "cell 0 5");
		
		JButton btnSleep = new JButton("Sleep");
		panel.add(btnSleep, "cell 0 6");
		
		JButton btnElectronic = new JButton("Electronic");
		panel.add(btnElectronic, "cell 0 7");
		
		JButton btnPortuguese = new JButton("Portuguese");
		panel.add(btnPortuguese, "cell 0 8");
		
		JButton btnTravel = new JButton("Travel");
		panel.add(btnTravel, "cell 0 9");
		
		JButton btnLove = new JButton("Love");
		panel.add(btnLove, "cell 0 10");
		
		JButton btnAddPlaylist = new JButton("Add playlist");
		panel.add(btnAddPlaylist, "cell 0 12");
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "cell 0 0 3 1,growx,aligny top");
		panel_1.setLayout(new MigLayout("", "[][19.00][19.00][20.00][87.00][659.00]", "[]"));
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		panel_1.add(txtSearch, "cell 4 0,alignx center");
		txtSearch.setColumns(10);
		
		JEditorPane dtrpnUserName = new JEditorPane();
		dtrpnUserName.setText("User name");
		panel_1.add(dtrpnUserName, "flowx,cell 5 0,alignx right");
		
		JButton btnLogOut = new JButton("Log out");
		panel_1.add(btnLogOut, "cell 5 0,alignx right");
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "cell 2 1,growx,aligny top");
		panel_2.setLayout(new MigLayout("", "[106px,grow][grow][][][][][][grow][-2.00][13.00][][20.00][156.00][][][][86px][][-56.00][][-23.00][][][-27.00][grow][][][]", "[20px,grow][][][grow][20px][][22.00px,grow,top][][grow][grow]"));
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9, "cell 17 0 5 10,grow");
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		panel_9.add(scrollBar);
		
		JEditorPane dtrpnPlaylistName = new JEditorPane();
		dtrpnPlaylistName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dtrpnPlaylistName.setText("Playlist Name");
		panel_2.add(dtrpnPlaylistName, "cell 7 2 5 1,grow");
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, "cell 0 6 17 1,grow");
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{101, 106, 106, 101, 61, 123, 126, 0};
		gbl_panel_3.rowHeights = new int[]{30, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblSharedWith = new JLabel("   Shared with:");
		GridBagConstraints gbc_lblSharedWith = new GridBagConstraints();
		gbc_lblSharedWith.anchor = GridBagConstraints.WEST;
		gbc_lblSharedWith.insets = new Insets(0, 0, 0, 5);
		gbc_lblSharedWith.gridx = 0;
		gbc_lblSharedWith.gridy = 0;
		panel_3.add(lblSharedWith, gbc_lblSharedWith);
		
		JEditorPane dtrpnUsername = new JEditorPane();
		dtrpnUsername.setText("username1");
		GridBagConstraints gbc_dtrpnUsername = new GridBagConstraints();
		gbc_dtrpnUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_dtrpnUsername.insets = new Insets(0, 0, 0, 5);
		gbc_dtrpnUsername.gridx = 1;
		gbc_dtrpnUsername.gridy = 0;
		panel_3.add(dtrpnUsername, gbc_dtrpnUsername);
		
		JEditorPane dtrpnUsername_1 = new JEditorPane();
		dtrpnUsername_1.setText("username2");
		GridBagConstraints gbc_dtrpnUsername_1 = new GridBagConstraints();
		gbc_dtrpnUsername_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dtrpnUsername_1.insets = new Insets(0, 0, 0, 5);
		gbc_dtrpnUsername_1.gridx = 2;
		gbc_dtrpnUsername_1.gridy = 0;
		panel_3.add(dtrpnUsername_1, gbc_dtrpnUsername_1);
		
		txtAddusername = new JTextField();
		txtAddusername.setText("add username");
		GridBagConstraints gbc_txtAddusername = new GridBagConstraints();
		gbc_txtAddusername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddusername.insets = new Insets(0, 0, 0, 5);
		gbc_txtAddusername.gridx = 3;
		gbc_txtAddusername.gridy = 0;
		panel_3.add(txtAddusername, gbc_txtAddusername);
		txtAddusername.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 0;
		panel_3.add(btnAdd, gbc_btnAdd);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 6;
		gbc_panel_4.gridy = 0;
		panel_3.add(panel_4, gbc_panel_4);
		
		JComboBox comboBox = new JComboBox();
		panel_4.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Key", "Bpm", "Format"}));
		comboBox.setToolTipText("Order");
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 0 7 17 2,grow");
		panel_5.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][106.00][grow][][grow]", "[grow][grow]"));
		
		JEditorPane dtrpnNameArtist = new JEditorPane();
		dtrpnNameArtist.setText("Name song");
		panel_5.add(dtrpnNameArtist, "cell 0 0,alignx center,aligny center");
		
		JEditorPane dtrpnSong = new JEditorPane();
		dtrpnSong.setText("Artist");
		panel_5.add(dtrpnSong, "cell 2 0,alignx center,aligny center");
		
		JEditorPane dtrpnAlbum = new JEditorPane();
		dtrpnAlbum.setText("Album");
		panel_5.add(dtrpnAlbum, "cell 4 0,alignx center,aligny center");
		
		JEditorPane dtrpnTime = new JEditorPane();
		dtrpnTime.setText("Time");
		panel_5.add(dtrpnTime, "cell 6 0,alignx center,aligny center");
		
		JButton btnPauseplay = new JButton("Pause/Play");
		btnPauseplay.setBackground(new Color(211, 211, 211));
		panel_5.add(btnPauseplay, "cell 7 0,aligny center");
		
		JSlider slider = new JSlider();
		panel_5.add(slider, "cell 9 0 8 1,aligny center");
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, "flowy,cell 17 0,aligny center");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_6.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Workout", "Sleep", "Electronic", "Portuguese", "Travel", "Love"}));
		comboBox_1.setToolTipText("Add playlist");
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, "cell 0 9 17 1,grow");
		
		panel_7.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][106.00][grow][][grow]", "[grow][grow]"));
		
		JEditorPane dtrpnNameArtist_1 = new JEditorPane();
		dtrpnNameArtist_1.setText("Name song");
		panel_7.add(dtrpnNameArtist_1, "cell 0 0,alignx center,aligny center");
		
		JEditorPane dtrpnSong_1 = new JEditorPane();
		dtrpnSong_1.setText("Artist");
		panel_7.add(dtrpnSong_1, "cell 2 0,alignx center,aligny center");
		
		JEditorPane dtrpnAlbum_1 = new JEditorPane();
		dtrpnAlbum_1.setText("Album");
		panel_7.add(dtrpnAlbum_1, "cell 4 0,alignx center,aligny center");
		
		JEditorPane dtrpnTime_1 = new JEditorPane();
		dtrpnTime_1.setText("Time");
		panel_7.add(dtrpnTime_1, "cell 6 0,alignx center,aligny center");
		
		JButton btnPauseplay_1 = new JButton("Pause/Play");
		btnPauseplay_1.setBackground(new Color(211, 211, 211));
		panel_7.add(btnPauseplay_1, "cell 7 0,aligny center");
		
		JSlider slider_1 = new JSlider();
		panel_7.add(slider_1, "cell 9 0 8 1,aligny center");
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, "flowy,cell 17 0,aligny center");
		
		JComboBox comboBox_2 = new JComboBox();
		panel_8.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Workout", "Sleep", "Electronic", "Portuguese", "Travel", "Love"}));
		comboBox_2.setToolTipText("Add playlist");
		
		
		
	}

}
