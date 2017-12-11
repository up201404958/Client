package dkeep.gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Register {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 898, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][grow]", "[][grow]"));
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(Color.WHITE);
		panel.add(lblRegister, "cell 0 0 15 1,alignx center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][][][][][9.00][121.00][][][][][156.00][48.00,grow]", "[][][][][][][][][][][][]"));
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		panel_1.add(lblUserName, "cell 7 2");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 12 2,growx");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Email");
		lblPassword.setForeground(Color.WHITE);
		panel_1.add(lblPassword, "cell 7 4");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 12 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Password");
		lblEmail.setForeground(Color.WHITE);
		panel_1.add(lblEmail, "cell 7 6");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 12 6,growx");
		textField_2.setColumns(10);
		
		JLabel lblConfimPassword = new JLabel("Confim Password");
		lblConfimPassword.setForeground(Color.WHITE);
		panel_1.add(lblConfimPassword, "cell 7 8");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 12 8,growx");
		textField_3.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign up");
		panel_1.add(btnSignUp, "cell 11 11");
	}

}
