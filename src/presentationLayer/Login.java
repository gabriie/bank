package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login {

	protected JFrame frameLogin;
	protected JFrame frameMsg;
	protected JTextField textFieldLoginUsername;
	protected JTextField textFieldLoginPassword;
	protected JButton btnLogin = new JButton("Login");
	protected JLabel labelmessage;

	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
//		frameLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frameLogin = new JFrame();
		frameLogin.setTitle("Login");
		frameLogin.setBounds(100, 100, 529, 311);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		
		frameMsg=new JFrame();
		frameMsg.setTitle("Error");
		frameMsg.setBounds(100,100,250,120);
		frameMsg.getContentPane().setLayout(null);
		labelmessage = new JLabel(" ");
		labelmessage.setBounds(20,20,150,30);
		frameMsg.getContentPane().add(labelmessage);
		frameMsg.setVisible(false);
//btnLogin
		btnLogin.setBounds(203, 193, 116, 25);
		frameLogin.getContentPane().add(btnLogin);
		
		JLabel lblLogInUsername = new JLabel("Username:");
		lblLogInUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogInUsername.setBounds(103, 74, 97, 33);
		frameLogin.getContentPane().add(lblLogInUsername);
		
		JLabel lblLoginPassword = new JLabel("Password:");
		lblLoginPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoginPassword.setBounds(103, 120, 86, 25);
		frameLogin.getContentPane().add(lblLoginPassword);
		
		textFieldLoginUsername = new JTextField();
		textFieldLoginUsername.setBounds(203, 80, 116, 22);
		frameLogin.getContentPane().add(textFieldLoginUsername);
		textFieldLoginUsername.setColumns(10);
		
		textFieldLoginPassword = new JPasswordField();
		textFieldLoginPassword.setBounds(203, 120, 116, 24);
		frameLogin.getContentPane().add(textFieldLoginPassword);
		
		JLabel lblLoginType = new JLabel("Type");
		lblLoginType.setBounds(103, 49, 46, 14);
		frameLogin.getContentPane().add(lblLoginType);
		
		JComboBox comboLoginType = new JComboBox();
		comboLoginType.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Employee", "Client"}));
		comboLoginType.setBounds(203, 49, 116, 20);
		frameLogin.getContentPane().add(comboLoginType);

	}
	
	public void close(){
		this.frameLogin.setVisible(false);
	}
}
