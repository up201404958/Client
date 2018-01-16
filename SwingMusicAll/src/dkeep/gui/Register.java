package dkeep.gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dkeep.client.Client;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register {

	protected JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	Client user=new Client();
	public JTextField Invalid_Username;
	
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
		panel_1.setLayout(new MigLayout("", "[][][][][][][9.00][121.00][][][][][156.00,grow][48.00,grow]", "[][][][][][][][][][][][]"));
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		panel_1.add(lblUserName, "cell 7 2");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 12 2,growx");
		textField.setColumns(10);
		/*
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		panel_1.add(lblEmail, "cell 7 4");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 12 4,growx");
		textField_1.setColumns(10);
		*/
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		panel_1.add(lblPassword, "cell 7 6");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 12 6,growx");
		textField_2.setColumns(10);
		/*
		JLabel lblConfimPassword = new JLabel("Confirm Password");
		lblConfimPassword.setForeground(Color.WHITE);
		panel_1.add(lblConfimPassword, "cell 7 8");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 12 8,growx");
		textField_3.setColumns(10);*/
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=textField.getText();
				String password=textField_2.getText();
				String message = "REGS "+name+" "+password;
				user.run(message);
			}
		});
		panel_1.add(btnSignUp, "cell 11 11");
		
		Invalid_Username = new JTextField();
		panel_1.add(Invalid_Username, "cell 12 11,growx");
		Invalid_Username.setColumns(10);
	}

}
