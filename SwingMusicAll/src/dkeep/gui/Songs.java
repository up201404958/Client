package dkeep.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This class represents the Songs page
 *
 */
public class Songs extends Main{

	protected JFrame frame;
	protected JTable table;
	protected JLabel user_name;
	protected String[] col = {"Id","Name","Genre","BPM","Key","Duration","Artist","Album"};
	
	
	@SuppressWarnings("serial")
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
		 
		@Override
		 public boolean isCellEditable(int row, int column){  
			return false;//This causes all cells to be not editable
		 }
	};

	/**
	 * Create the application.
	 */
	public Songs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 153));
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(16, 81, 151, 342);
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
		panel.add(btnSongs, "cell 0 1");
		
		JButton btnAlbuns = new JButton("Albums");
		btnAlbuns.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToAlbuns();
			}
		});
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
		
		JButton MyPlaylists = new JButton("My Playlists");
		MyPlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMyPlaylists();
			}
		});
		panel.add(MyPlaylists, "cell 0 5");
		
		JButton CreatePlaylists = new JButton("Create Playlist");
		CreatePlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToCreatePlaylist();
			}
			
		});
		panel.add(CreatePlaylists, "cell 0 6");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 153));
		panel_1.setBounds(16, 16, 866, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
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
		user_name.setFont(new Font("Orator Std", Font.BOLD, 18));
		user_name.setBounds(610, 15, 107, 36);
		panel_1.add(user_name);
		
		JButton btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToHomepage();
			}
		});
		btnHome.setBounds(12, 16, 81, 29);
		panel_1.add(btnHome);
		
		JLabel lblSongs = new JLabel("SONGS");
		lblSongs.setFont(new Font("Orator Std", Font.BOLD, 30));
		lblSongs.setBounds(398, 118, 191, 61);
		frame.getContentPane().add(lblSongs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(204, 191, 617, 146);
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
						int r = JOptionPane.showConfirmDialog(null,(String) table.getValueAt(row, 1)," Download",JOptionPane.YES_NO_OPTION);
						if (r == JOptionPane.YES_OPTION) {
		        				user.run("DWLD "+(String) table.getValueAt(row, 0)+" "+user.username); //download music id
		        			}
					}
				}
			}
		});
		

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
		
		
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
