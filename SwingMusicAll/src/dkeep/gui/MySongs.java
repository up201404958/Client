package dkeep.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This class represents the songs that belong to a user allowing us to play them
 *
 */
public class MySongs extends Main{

	protected JFrame frame;
	public JTable table;
	protected JLabel user_name;
	protected String[] col = {"Id","Name","Album","Artist","Duration","Genre","BPM","Key","AddTo"};

	protected JComboBox<String> combobox;
	protected javax.swing.table.TableColumn plColumn;
	
	protected int row;
	@SuppressWarnings("serial")
	protected DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
		 
		@Override
		 public boolean isCellEditable(int row, int column){  
			if(column==8) {
				if(user.hasPlaylist())
					return true;
			}
		    return false;
		 }
	};

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MySongs() {
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
		
		JLabel lblSongs = new JLabel("MY SONGS");
		lblSongs.setFont(new Font("Orator Std", Font.BOLD, 30));
		lblSongs.setBounds(398, 118, 191, 61);
		frame.getContentPane().add(lblSongs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(204, 191, 617, 146);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(getTableModel());
		scrollPane.setViewportView(table);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!Flags.activethread) {
					Song = new MusicThread((String) table.getValueAt(row, 0));
					Song.start();
					Flags.flag=true;
					String line = (String) table.getValueAt(row,0)+","+(String)table.getValueAt(row,1)+","+(String)table.getValueAt(row,2)+","+(String)table.getValueAt(row,3)+","+(String) table.getValueAt(row,4)+","+(String) table.getValueAt(row,5);
					System.out.println(line);
					lastplay.add(line);
				}

			}
		});
		btnPlay.setBounds(221, 376, 117, 29);
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
		btnStop.setBounds(371, 376, 117, 29);
		frame.getContentPane().add(btnStop);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Flags.stoped=true;
			}
		});
		btnPause.setBounds(528, 376, 117, 29);
		frame.getContentPane().add(btnPause);
		
		JButton btnResume = new JButton("Resume");
		btnResume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Flags.stoped=false;
			}
		});
		btnResume.setBounds(672, 376, 117, 29);
		frame.getContentPane().add(btnResume);
		
		getTableModel().addTableModelListener(new TableModelListener() {
			 @Override
			    public void tableChanged(TableModelEvent e) {
			        int type = e.getType();
			        switch (type) {
			            case TableModelEvent.UPDATE:
			                if (e.getFirstRow() - e.getLastRow() == 0) {
			                    TableModel model = (TableModel) e.getSource();
			                    int row = e.getFirstRow();
			                    int col = e.getColumn();
			                    System.out.println("Update " + row + "x" + col + " = " + model.getValueAt(row, col));
			                    if(model.getValueAt(row,col)!=null){
			                    		String aux = (String) model.getValueAt(row, col);
			                    		String[] parts = aux.split("-");
			                    	    user.run("ADDSNG "+parts[1]+" "+model.getValueAt(row, 0));
			       
			                    }
			                }
			                break;
			        }
			    }
			});
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
				row = table.rowAtPoint(evt.getPoint());
				System.out.println(row);
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

	public JComboBox<String> getCombobox() {
		return combobox;
	}

	public void setCombobox(JComboBox<String> combobox) {
		this.combobox = combobox;
	}

	public javax.swing.table.TableColumn getPlColumn() {
		return plColumn;
	}

	public void setPlColumn(javax.swing.table.TableColumn plColumn) {
		this.plColumn = plColumn;
	}
}
