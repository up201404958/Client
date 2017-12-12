package dkeep.gui;

import java.awt.Cursor;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Logged{

	private JFrame frame;
	private JTextField txtSearch;
	private JTextField changePass;
	private JTextField confirmPass;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logged window = new Logged();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Logged() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 338, 406, 0};
		gridBagLayout.rowHeights = new int[]{37, 118, 45, 194, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);
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
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridheight = 3;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
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
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.anchor = GridBagConstraints.NORTH;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		panel_2.setLayout(new MigLayout("", "[125.00px][20.00,grow][grow][][][][][][grow][-2.00][16.00][][20.00][156.00][][][][86px][][-56.00][][-23.00][][][-27.00][][][][]", "[20px,grow][][][grow][grow][20px][][][22.00px,grow,top][][grow][][grow]"));
		
		JEditorPane dtrpnUserName_1 = new JEditorPane();
		dtrpnUserName_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dtrpnUserName_1.setText("User Name");
		panel_2.add(dtrpnUserName_1, "cell 0 1 11 1,grow");
		
		JLabel lblChangePassword = new JLabel("Change Password");
		panel_2.add(lblChangePassword, "cell 0 4");
		
		changePass = new JTextField();
		panel_2.add(changePass, "cell 1 4 10 1,growx");
		changePass.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "cell 11 1 16 12,alignx center,aligny center");
		panel_4.setLayout(new MigLayout("", "[][][][][][][][-6.00,grow]", "[][][][][grow]"));
		
		ImageIcon regular = new ImageIcon(ClassLoader.getSystemResource("logomedio.png"));
		ImageIcon hovering = new ImageIcon(ClassLoader.getSystemResource("logomedio.png"));
		ImageIcon clicking = new ImageIcon(ClassLoader.getSystemResource("logomedio.png"));
		BufferedImage img = ImageIO.read(ClassLoader.getSystemResource("logomedio.png"));
		
		
		final JLabel lblMusicall = new JLabel(regular);
		lblMusicall.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
				if( (pixel>>24) == 0x00 ) {
					return;
				}
				else { 
					System.out.println("I was clicked! I really look like a button.");
					lblMusicall.setIcon(clicking);
				}
				super.mousePressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
				if( (pixel>>24) == 0x00 ) {
					lblMusicall.setIcon(regular);
				}
				else {
					lblMusicall.setIcon(hovering);					
				}
				super.mouseReleased(e);
			}
		});
		lblMusicall.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
				if( (pixel>>24) == 0x00 ) {
					lblMusicall.setIcon(regular);
					lblMusicall.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				else {
					lblMusicall.setIcon(hovering);
					lblMusicall.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				super.mouseMoved(e);
			}
		});
		panel_4.add(lblMusicall, "cell 0 1,alignx center,aligny center");
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, "cell 0 3,alignx center,aligny center");
		panel_5.setLayout(new MigLayout("", "[][][][75.00][][106.00][149.00][67.00][]", "[grow]"));
		
		JEditorPane dtrpnNameArtist = new JEditorPane();
		dtrpnNameArtist.setText("Name song");
		panel_5.add(dtrpnNameArtist, "cell 3 0,alignx center,aligny center");
		
		JEditorPane dtrpnSong = new JEditorPane();
		dtrpnSong.setText("Artist");
		panel_5.add(dtrpnSong, "cell 4 0,alignx center,aligny center");
		
		JEditorPane dtrpnAlbum = new JEditorPane();
		dtrpnAlbum.setText("Album");
		panel_5.add(dtrpnAlbum, "cell 5 0,alignx center,aligny center");
		
		JEditorPane dtrpnTime = new JEditorPane();
		dtrpnTime.setText("Time");
		panel_5.add(dtrpnTime, "cell 6 0,alignx center,aligny center");
		
		JButton btnPauseplay = new JButton("Pause/Play");
		btnPauseplay.setBackground(new Color(211, 211, 211));
		panel_5.add(btnPauseplay, "cell 7 0,aligny center");
		
		JSlider slider = new JSlider();
		panel_5.add(slider, "cell 8 0,alignx center,aligny center");
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		panel_2.add(lblConfirmPassword, "cell 0 6");
		
		confirmPass = new JTextField();
		panel_2.add(confirmPass, "cell 1 6 10 1,growx");
		confirmPass.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		
		JButton btnWorkout_1 = new JButton("Workout");
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSleep_1 = new JButton("Sleep");
		
		JButton btnLove_1 = new JButton("Love");
		
		JScrollBar scrollBar = new JScrollBar();
		
		JButton btnPortuguese_1 = new JButton("Portuguese");
		
		JButton btnTravel_1 = new JButton("Travel");
		
		JButton btnElectronic_1 = new JButton("Electronic");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(btnWorkout_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPortuguese_1))
					.addGap(186)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSleep_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTravel_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(197)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLove_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
						.addComponent(btnElectronic_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(36)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnSleep_1)
									.addComponent(btnLove_1))
								.addGap(135)))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(btnWorkout_1)
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnPortuguese_1)
								.addComponent(btnTravel_1)
								.addComponent(btnElectronic_1))
							.addGap(69))))
		);
		panel_3.setLayout(gl_panel_3);

	}

}