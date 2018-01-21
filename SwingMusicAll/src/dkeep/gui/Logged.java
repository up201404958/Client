package dkeep.gui;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;


/**
 * This class represents the homePage of the user
 *
 */
public class Logged extends Main {

	protected JFrame frame;
	protected JLabel user_name;
	private JTextField textField;
	private JTextField textField_1;
	protected JLabel confirm;
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @wbp.parser.entryPoint
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
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 899, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][19.00][19.00][20.00][87.00][659.00]", "[]"));
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToLogin();
			}
		});
		panel_1.add(btnLogOut, "cell 5 0,alignx right");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 66, 166, 363);
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][]"));
		
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
		
		JButton btnMyPlaylists = new JButton("My Playlists");
		btnMyPlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToMyPlaylists();
			}
		});
		panel.add(btnMyPlaylists, "cell 0 5");
		
		JButton btnAddPlaylist = new JButton("Create playlist");
		btnAddPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.goToCreatePlaylist();
			}
		});
		panel.add(btnAddPlaylist, "cell 0 6");
		
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
		
		user_name = new JLabel();
		user_name.setFont(new Font("Orator Std", Font.BOLD, 25));
		user_name.setBounds(193, 98, 348, 44);
		frame.getContentPane().add(user_name);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setBounds(193, 182, 138, 16);
		frame.getContentPane().add(lblChangePassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(193, 215, 123, 16);
		frame.getContentPane().add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(325, 177, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(325, 210, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String new_pass = textField.getText();
				String confirm_pass = textField_1.getText();
				
				if(!new_pass.equals(confirm_pass))
					confirm.setText("Passwords dont match");
				else if(new_pass.equals("") || confirm_pass.equals(""))
					confirm.setText("Blank Fields Forever");
				else
					user.run("CHNGPASS "+confirm_pass+" "+user.username);
			
			}
		});
		btnConfirm.setBounds(508, 210, 117, 29);
		frame.getContentPane().add(btnConfirm);
		
		confirm = new JLabel();
		confirm.setBounds(518, 251, 107, 26);
		frame.getContentPane().add(confirm);
		
	
	}
	public void setText(String s) {
		confirm.setText(s);
	}
}
