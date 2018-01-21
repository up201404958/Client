package dkeep.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends Main{

	protected JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	protected JLabel label;
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
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		panel_1.add(lblPassword, "cell 7 6");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 12 6,growx");
		textField_2.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=textField.getText();
				String password=textField_2.getText();
				if(name.equals("") || password.equals("")) {
					getLabel().setText("INVALID");
				}else {
					String message = "REGS "+name+" "+password;
					user.run(message);
				}
			}
		});
		panel_1.add(btnSignUp, "cell 11 11");
		
		setLabel(new JLabel(""));
		getLabel().setForeground(Color.WHITE);
		panel_1.add(getLabel(), "cell 12 11");
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

}
