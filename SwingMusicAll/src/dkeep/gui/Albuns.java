package dkeep.gui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
 * This class represents the Album page
 *
 */
public class Albuns extends Main {

	protected JFrame frame;
	private JTable table;
	protected JLabel user_name;
	protected String[] col = {"Id","Name","Year","Genre","Artist"};
	
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
	
		private static final long serialVersionUID = 1L;

		@Override
		 public boolean isCellEditable(int row, int column)
		 {
		    return false;//This causes all cells to be not editable
		 }
	};
	/**
	 * Create the application.
	 */
	public Albuns() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(16, 81, 151, 348);
		panel.setBackground(new Color(255, 204, 153));
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][]"));
		
		JButton btnLastPlayed = new JButton("Last Played");
		btnLastPlayed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToLastPlayed();
			}
		});
		panel.add(btnLastPlayed, "cell 0 0");
		
		JButton btnSongs = new JButton("Songs");
		btnSongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToSongs();
			}
		});
		panel.add(btnSongs, "cell 0 1");
		
		JButton btnAlbuns = new JButton("Albums");
		panel.add(btnAlbuns, "cell 0 2");
		
		JButton btnArtists = new JButton("Artists");
		btnArtists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToArtists();
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
			}
		});
		panel.add(btnMyPlaylists, "cell 0 5");
		
		JButton btnCreatePlaylists = new JButton("Create Playlist");
		btnCreatePlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToCreatePlaylist();
			}
		});
		panel.add(btnCreatePlaylists, "cell 0 6");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 16, 866, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setBackground(new Color(255, 204, 153));
		
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
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToLogin();
			}
		});
		btnLogOut.setBounds(768, 16, 92, 29);
		panel_1.add(btnLogOut);
		
		user_name = new JLabel();
		user_name.setBackground(Color.LIGHT_GRAY);
		user_name.setFont(new Font("Orator Std", Font.BOLD, 17));
		user_name.setBounds(641, 21, 127, 25);
		panel_1.add(user_name);
		user_name.setText(username);
		
		
		JLabel lblDownloads = new JLabel("Downloads");
		panel.add(lblDownloads, "cell 0 7");
		JButton mySongs = new JButton("My Songs");
		mySongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMySongs();
			}
		});
		panel.add(mySongs, "cell 0 8");
		
		JLabel lblNewLabel = new JLabel("ALBUMS");
		lblNewLabel.setFont(new Font("Orator Std", Font.BOLD, 30));
		lblNewLabel.setBounds(382, 105, 193, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 172, 474, 196);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(getTableModel());
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
				if(evt.getClickCount()==2){
					int row = table.rowAtPoint(evt.getPoint());
					int col = table.columnAtPoint(evt.getPoint());
					if (row >= 0 && col >= 0) {
		        			thisalbum.album_name.setText((String) table.getValueAt(row, 1));
		        			thisalbum.album_year.setText((String) table.getValueAt(row, 2));
		        			thisalbum.artist_name.setText((String) table.getValueAt(row, 4));
		        			String id = (String)table.getValueAt(row, 0);
		        			user.goToThisAlbum();
		        			user.run("GOTOTA "+id);
		        			
					}
				}
			}
		});
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
