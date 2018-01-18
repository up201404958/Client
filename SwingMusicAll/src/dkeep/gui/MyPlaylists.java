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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPlaylists extends Main{

	public JFrame frame;
	private JTextField txtSearch;
	protected JLabel user_name;
	protected String[] col = {"Id","Name"};
	
	public DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
		 @Override
		 public boolean isCellEditable(int row, int column)
		 {
		    return false;//This causes all cells to be not editable
		 }
	};
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPlaylists window = new MyPlaylists();
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
	public MyPlaylists() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(16, 81, 146, 332);
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
		panel.add(btnMyPlaylists, "cell 0 5");
		
		JButton btnCreatePlaylists = new JButton("Create Playlists");
		btnCreatePlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToCreatePlaylist();
			}
		});
		panel.add(btnCreatePlaylists, "cell 0 6");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
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
		user_name.setFont(new Font("Orator Std", Font.BOLD, 17));
		user_name.setBounds(643, 21, 103, 24);
		panel_1.add(user_name);
		
		JLabel lblMyPlaylists = new JLabel("MY PLAYLISTS");
		lblMyPlaylists.setFont(new Font("Orator Std", Font.BOLD, 30));
		lblMyPlaylists.setBounds(392, 100, 216, 48);
		frame.getContentPane().add(lblMyPlaylists);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(322, 160, 356, 69);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		//CHOOSE LINES
		/*ListSelectionModel select = table.getSelectionModel();
		select.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(! select.isSelectionEmpty()) {
					int row=select.getMinSelectionIndex();
					String namee = (String) table.getValueAt(row, 1);
					JOptionPane.showMessageDialog(null, namee);
				}
				
			}
			
		});*/
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
				if(evt.getClickCount()==2){
					int row = table.rowAtPoint(evt.getPoint());
					int col = table.columnAtPoint(evt.getPoint());
					if (row >= 0 && col >= 0) {
						String id = (String) table.getValueAt(row,0);
						String text = (String) table.getValueAt(row, 1);
						thisplaylist.playlist_name.setText(text);
						thisplaylist.setID(id);
						user.run("PLSTSNG "+thisplaylist.getID());
						user.goToThisPlaylist();
		        			//JOptionPane.showMessageDialog(null, (String) table.getValueAt(row, 1));
					}
				}
			}
		});
		
		
		
	}
}