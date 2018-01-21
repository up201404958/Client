package dkeep.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
/**
 * This class represents the first page presented to the user where login can be made
 *
 */

public class NotLogged extends Main {
	/**
	 * 
	 */
	protected JFrame frame;
	protected JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;
	protected JButton btnSignIn;
	protected JLabel label;
	private JLabel lblNewLabel;
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
		
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 329, 825, 61);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][106.00][grow][][grow]", "[grow]"));
		
		label = new JLabel();
		label.setIcon(new ImageIcon(this.getClass().getResource("/logopequeno.png")));
		label.setBounds(363, 117, 208, 200);
		contentPane.add(label);
		
		setLblNewLabel(new JLabel());
		getLblNewLabel().setBounds(549, 99, 194, 25);
		contentPane.add(getLblNewLabel());
	
	
	
	
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
		lblNewLabel.setForeground(new Color(255, 255, 255));
	}

}
