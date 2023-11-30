package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MainPage extends JFrame {

	JButton btnNewButton;
	JButton btnSignUp;
	JButton btnExit;
	JLabel customerNameLabel;
	JLabel emailLabel;
	JLabel passwordLabel;
	JTextField customerNameText;
	JTextField emailText;
	JPasswordField passwordText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {

		getContentPane().setBackground(UIManager.getColor("Button.highlight"));
		getContentPane().setLayout(null);
		
		customerNameLabel = new JLabel("Name: ");
		customerNameText = new JTextField();
		
		emailLabel = new JLabel("Email: ");
		emailText = new JTextField();
		
		passwordLabel = new JLabel("Password: ");
		passwordText = new JPasswordField();
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to FeastFast!");
		lblNewLabel_1.setFont(new Font("Bangla MN", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_1.setBounds(154, 6, 533, 62);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel(new ImageIcon(MainPage.class.getResource("/FeastFast/ApplicationCore/FeastFastGIF.gif")));
		lblNewLabel.setBounds(154, 23, 500, 500);
		getContentPane().add(lblNewLabel);
		
		// Log In Button
		btnNewButton = new JButton("Log In");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(234, 92, 100));
		btnNewButton.setBounds(77, 576, 168, 55);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new Listener());
		
		// Sign Up Button
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setOpaque(true);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBackground(new Color(234, 92, 100));
		btnSignUp.setBounds(310, 576, 168, 55);
		getContentPane().add(btnSignUp);
		btnSignUp.addActionListener(new Listener());
		
		// Exit Button
		btnExit = new JButton("Exit");
		btnExit.setOpaque(true);
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(234, 92, 100));
		btnExit.setBounds(572, 576, 168, 55);
		btnExit.addActionListener(new Listener());
		
		
		getContentPane().add(btnExit);
		setBounds(100, 100, 800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	// Event listener
				private class Listener implements ActionListener {
					
					public void actionPerformed(ActionEvent e) {
						
						// Button click events
						JButton source = (JButton) e.getSource();
						
						// Log In button
						if(source.equals(btnNewButton)) {
							handleLogIn();
						}
						// Sign Up button
						else if(source.equals(btnSignUp)) {
							handleSignUp();
						}
						// button
						else if(source.equals(btnExit)) {
							handleExit();
						}

					}
					
					// Method to handle log ins 
					private void handleLogIn() {
			
						LoginPage loginFrame = new LoginPage();
						loginFrame.setVisible(true);
					}
					
					private void handleSignUp() {
						
						SignUpPage signUpFrame = new SignUpPage();
						signUpFrame.setVisible(true);
					}
					
					private void handleExit() {
						System.exit(0);
					}
					
				}

}
