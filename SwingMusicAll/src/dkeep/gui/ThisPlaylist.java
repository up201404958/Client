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

public class ThisPlaylist extends Main {

	protected MusicThread Song;
	protected JFrame frame;
	private JTextField txtSearch;
	protected JLabel user_name;
	private JTable table;
	protected JLabel playlist_name;
	protected String id;
	protected String[] col = {"Id","Name","Genre","Duration","BPM","Key"};
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
	 * @wbp.parser.entryPoint
	 */
	public ThisPlaylist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 204));
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
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
		panel_1.setBackground(new Color(204, 255, 204));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 185, 586, 182);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		playlist_name = new JLabel();
		playlist_name.setFont(new Font("Orator Std", Font.BOLD, 25));
		playlist_name.setBounds(351, 89, 163, 50);
		frame.getContentPane().add(playlist_name);
		
		JButton btnOrderByBpm = new JButton("Order by BPM");
		btnOrderByBpm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thisplaylist.tableModel.setRowCount(0);
				user.run("BPLSTSNG "+thisplaylist.getID());
			}
		});
		btnOrderByBpm.setBounds(560, 144, 117, 29);
		frame.getContentPane().add(btnOrderByBpm);
		
		JButton btnOrderByKey = new JButton("Order by Key");
		btnOrderByKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thisplaylist.tableModel.setRowCount(0);
				user.run("KPLSTSNG "+thisplaylist.getID());
				//user.refreshPage();

			}
		});
		btnOrderByKey.setBounds(689, 144, 117, 29);
		frame.getContentPane().add(btnOrderByKey);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Flags.activethread==false) {
					Song = new MusicThread();
					Song.start();
					Flags.flag=true;
				}
			}
		});
		btnPlay.setBounds(230, 379, 117, 29);
		frame.getContentPane().add(btnPlay);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Flags.flag=false;
				Flags.activethread=false;
				Song.interrupt();
				
			}
		});
		btnStop.setBounds(397, 379, 117, 29);
		frame.getContentPane().add(btnStop);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Flags.stoped=true;
			}
		});
		btnPause.setBounds(560, 379, 117, 29);
		frame.getContentPane().add(btnPause);
		
		JButton btnResume = new JButton("Resume");
		btnResume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Flags.stoped=false;
			}
		});
		btnResume.setBounds(699, 379, 117, 29);
		frame.getContentPane().add(btnResume);
		
		
		
	}
	protected void setID(String value) {
		this.id=value;
	}
	protected String getID() {
		return this.id;
	}
}
