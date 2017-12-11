package dkeep.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;

public class Artists {

	private JFrame frame;
	private JTextField txtSearch;

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
		
		JEditorPane dtrpnArtists = new JEditorPane();
		dtrpnArtists.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dtrpnArtists.setText("Artists");
		panel_2.add(dtrpnArtists, "cell 7 2 5 1,grow");
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 0 7 17 2,alignx left,growy");
		panel_5.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][106.00][grow][][grow]", "[grow][grow]"));
		
		JEditorPane dtrpnNameArtist = new JEditorPane();
		dtrpnNameArtist.setText("Name artist");
		panel_5.add(dtrpnNameArtist, "cell 0 0,alignx center,aligny center");
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, "cell 0 9 17 1,alignx left,growy");
		panel_7.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][106.00][grow][][grow]", "[grow][grow]"));
		
		JEditorPane dtrpnNameArtist_1 = new JEditorPane();
		panel_7.add(dtrpnNameArtist_1);
		dtrpnNameArtist_1.setText("Name artist");
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, "cell 0 6 17 1,alignx left,growy");
		panel_3.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][106.00][grow][][grow]", "[grow][grow]"));
		
		JEditorPane dtrpnNameArtist_2 = new JEditorPane();
		dtrpnNameArtist_2.setText("Name artist");
		panel_3.add(dtrpnNameArtist_2, "cell 0 0,alignx center,aligny center");
		


	}

}
