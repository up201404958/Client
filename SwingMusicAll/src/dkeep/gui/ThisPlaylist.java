package dkeep.gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This class represents a specific playlist from a certain user
 *
 */
public class ThisPlaylist extends Main {


	protected JFrame frame;
	protected JLabel user_name;
	protected JTable table;
	protected JLabel playlist_name;
	protected String id;
	protected String[] col = {"Id","Name","Genre","Duration","BPM","Key"};
	protected int row;
	@SuppressWarnings("serial")
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
		 @Override
		 public boolean isCellEditable(int row, int column){
		    return false;
		 }
	};

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
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
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
		
		panel.add(MyPlaylists, "cell 0 6");
		
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
		user_name.setBounds(605, 16, 117, 31);
		panel_1.add(user_name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 185, 586, 182);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(getTableModel());
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
				
				row = table.rowAtPoint(evt.getPoint());
				System.out.println(row);
			
			}
		});
		
		playlist_name = new JLabel();
		playlist_name.setFont(new Font("Orator Std", Font.BOLD, 25));
		playlist_name.setBounds(351, 89, 163, 50);
		frame.getContentPane().add(playlist_name);
		
		JButton btnOrderByBpm = new JButton("Order by BPM");
		btnOrderByBpm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thisplaylist.getTableModel().setRowCount(0);
				user.run("BPLSTSNG "+thisplaylist.getID());
			}
		});
		btnOrderByBpm.setBounds(560, 144, 117, 29);
		frame.getContentPane().add(btnOrderByBpm);
		
		JButton btnOrderByKey = new JButton("Order by Key");
		btnOrderByKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thisplaylist.getTableModel().setRowCount(0);
				user.run("KPLSTSNG "+thisplaylist.getID());

			}
		});
		btnOrderByKey.setBounds(689, 144, 117, 29);
		frame.getContentPane().add(btnOrderByKey);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!Flags.activethread) {
					Song = new MusicThread((String) table.getValueAt(row, 0));
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
		
		JButton CreatePlaylist = new JButton("Create Playlist");
		CreatePlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToCreatePlaylist();
			}
		});
		panel.add(CreatePlaylist, "cell 0 7");
		
		JLabel lblDownloads = new JLabel("Downloads");
		panel.add(lblDownloads, "cell 0 8");
		JButton mySongs = new JButton("My Songs");
		mySongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMySongs();
			}
		});
		panel.add(mySongs, "cell 0 9");
		
		
	}
	protected void setID(String value) {
		this.id=value;
	}
	protected String getID() {
		return this.id;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
}
