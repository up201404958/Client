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

import java.awt.FlowLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NotLogged extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotLogged frame = new NotLogged();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public NotLogged() throws IOException {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ImageIcon regular = new ImageIcon(ClassLoader.getSystemResource("logopequeno.png"));
		ImageIcon hovering = new ImageIcon(ClassLoader.getSystemResource("logopequeno.png"));
		ImageIcon clicking = new ImageIcon(ClassLoader.getSystemResource("logopequeno.png"));
		BufferedImage img = ImageIO.read(ClassLoader.getSystemResource("logopequeno.png"));
		contentPane.setLayout(new MigLayout("", "[1px][][][][][][][][][][][][grow][][grow][grow][][][grow][grow][grow][][][][][][][][][][][]", "[1px][grow][][][][][][][][137.00][24.00,grow][grow]"));
												
												JPanel panel_1 = new JPanel();
												panel_1.setForeground(Color.WHITE);
												panel_1.setBackground(Color.DARK_GRAY);
												contentPane.add(panel_1, "cell 1 1 31 2,grow");
												panel_1.setLayout(new MigLayout("", "[91.00][][][][][][43.00,grow][][][-75.00][86.00][54.00][58.00][][][109.00][][42.00,grow]", "[]"));
												
												JButton btnRegister = new JButton("Register");
												btnRegister.setBackground(new Color(211, 211, 211));
												btnRegister.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
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
												
												JButton btnSignIn = new JButton("Sign in");
												btnSignIn.setBackground(new Color(211, 211, 211));
												panel_1.add(btnSignIn, "cell 16 0,alignx right");
												panel_1.add(btnRegister, "cell 17 0,alignx right");
												
														final JLabel lblNewLabel = new JLabel(regular);
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
																}
																super.mousePressed(e);
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
														contentPane.add(lblNewLabel, "cell 7 3 19 7,alignx center,aligny center");
												
												JPanel panel = new JPanel();
												panel.setBackground(Color.DARK_GRAY);
												contentPane.add(panel, "cell 1 10 30 1,grow");
												panel.setLayout(new MigLayout("", "[][][][][][106.00][grow][][grow]", "[grow]"));
												
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
												
												JSlider slider = new JSlider();
												panel.add(slider, "cell 8 0,aligny center");
	}
}
