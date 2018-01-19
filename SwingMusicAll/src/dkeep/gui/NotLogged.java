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
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;


import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class NotLogged extends Main implements ActionListener {
	/**
	 * 
	 */
	public JFrame frame;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;
	static JLabel image_move = new JLabel("");
	//Client user=new Client();
	static Thread move;
	static JButton btnSignIn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		move = new Thread(){
			@Override
			public void run() {
				int oldx=image_move.getX();
				int oldy=image_move.getY();
				int tam=40;
				int x=oldx;
				int y=oldy;
				
				int velx=1;
				int vely=1;
				do {
					x+=velx;
					if(oldx+tam < x || oldx-tam > x) {
						velx*=-1;
						y-=2*vely;
					}
				
					if(oldy+tam < y || oldy-tam > y) {
						velx*=-1;
						y+=2*vely;
					}
					image_move.setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}while(true);
			}
		};
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				/*try {
					NotLogged frame = new NotLogged();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
			}
		});	
	
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public NotLogged() throws IOException {
		frame=new JFrame();
		frame.setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 898, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);

		ImageIcon regular = new ImageIcon(ClassLoader.getSystemResource("logopequeno.png"));
		ImageIcon hovering = new ImageIcon(ClassLoader.getSystemResource("logopequeno.png"));
		ImageIcon clicking = new ImageIcon(ClassLoader.getSystemResource("logopequeno.png"));
		BufferedImage img = ImageIO.read(ClassLoader.getSystemResource("logopequeno.png"));
												contentPane.setLayout(null);
												
												JPanel panel_1 = new JPanel();
												panel_1.setBounds(29, 25, 848, 61);
												panel_1.setForeground(Color.WHITE);
												panel_1.setBackground(Color.DARK_GRAY);
												contentPane.add(panel_1);
												panel_1.setLayout(new MigLayout("", "[91.00][][][][][][43.00,grow][][][-75.00][86.00][54.00][58.00][][][109.00][][42.00,grow]", "[]"));
												
												JButton btnRegister = new JButton("Register");
												btnRegister.setBackground(new Color(211, 211, 211));
												btnRegister.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														user.goToRegister();
													}
												});
												
												txtUser = new JTextField();
												txtUser.setForeground(Color.BLACK);
												txtUser.setText("User");
												panel_1.add(txtUser, "cell 14 0,alignx right");
												txtUser.setColumns(10);
										
												
												txtPassword = new JTextField();
												txtPassword.setText("Password");
												panel_1.add(txtPassword, "cell 15 0,alignx right");
												txtPassword.setColumns(10);
												
												
												btnSignIn = new JButton("Sign in");
												btnSignIn.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent login) {
														String name=txtUser.getText();
														String password=txtPassword.getText();
														String message = "LOGN "+name+" "+password;
														user.run(message);
													}
												});
												
												btnSignIn.setBackground(new Color(211, 211, 211));
												panel_1.add(btnSignIn, "cell 16 0,alignx right");
												panel_1.add(btnRegister, "cell 17 0,alignx right");
												
														final JLabel lblNewLabel = new JLabel(regular);
														lblNewLabel.setBounds(453, 208, 0, 0);
														lblNewLabel.addMouseListener(new MouseAdapter() {
															@Override
															public void mousePressed(MouseEvent e) {
																int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
																if( (pixel>>24) == 0x00 ) {
																	return;
																}
																else { 
																	System.out.println("I was clicked! I really look like a button.");
																	lblNewLabel.setIcon(clicking);
																	super.mousePressed(e);
																}
															}
															@Override
															public void mouseReleased(MouseEvent e) {
																int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
																if( (pixel>>24) == 0x00 ) {
																	lblNewLabel.setIcon(regular);
																}
																else {
																	lblNewLabel.setIcon(hovering);					
																}
																super.mouseReleased(e);
															}
														});
														lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
															@Override
															public void mouseMoved(MouseEvent e) {
																int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
																if( (pixel>>24) == 0x00 ) {
																	lblNewLabel.setIcon(regular);
																	lblNewLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
																}
																else {
																	lblNewLabel.setIcon(hovering);
																	lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
																}
																super.mouseMoved(e);
															}
														});
														contentPane.add(lblNewLabel);
												
												JPanel panel = new JPanel();
												panel.setBounds(29, 329, 825, 61);
												panel.setBackground(Color.DARK_GRAY);
												contentPane.add(panel);
												panel.setLayout(new MigLayout("", "[][][][][][106.00][grow][][grow]", "[grow]"));
												/*
												JEditorPane dtrpnNameArtist = new JEditorPane();
												dtrpnNameArtist.setText("Name song");
												panel.add(dtrpnNameArtist, "cell 3 0,alignx center,aligny center");
												
												JEditorPane dtrpnSong = new JEditorPane();
												dtrpnSong.setText("Artist");
												panel.add(dtrpnSong, "cell 4 0,alignx center,aligny center");
												
												JEditorPane dtrpnAlbum = new JEditorPane();
												dtrpnAlbum.setText("Album");
												panel.add(dtrpnAlbum, "cell 5 0,alignx center,aligny center");
												
												JEditorPane dtrpnTime = new JEditorPane();
												dtrpnTime.setText("Time");
												panel.add(dtrpnTime, "cell 6 0,alignx center,aligny center");
												
												JButton btnPauseplay = new JButton("Pause/Play");
												btnPauseplay.setBackground(new Color(211, 211, 211));
												panel.add(btnPauseplay, "cell 7 0,aligny center");
												
												/*JSlider slider = new JSlider();
												panel.add(slider, "cell 8 0,aligny center");*/
												image_move.setBounds(346, 110, 200, 157);
												contentPane.add(image_move);
												

												image_move.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														move.start();
													}
												});
												image_move.setIcon(new ImageIcon("/Users/franciscofonseca/Desktop/SwingMusicAll/src/logopequeno.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
