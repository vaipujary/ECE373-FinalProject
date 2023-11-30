package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class MainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.highlight"));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to FeastFast!");
		lblNewLabel_1.setFont(new Font("Bangla MN", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_1.setBounds(154, 6, 533, 62);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel(new ImageIcon(MainPage.class.getResource("/FeastFast/ApplicationCore/FeastFastGIF.gif")));
		lblNewLabel.setBounds(154, 23, 500, 500);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(234, 92, 100));
		btnNewButton.setBounds(77, 576, 168, 55);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setOpaque(true);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBackground(new Color(234, 92, 100));
		btnSignUp.setBounds(310, 576, 168, 55);
		frame.getContentPane().add(btnSignUp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setOpaque(true);
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(234, 92, 100));
		btnExit.setBounds(572, 576, 168, 55);
		frame.getContentPane().add(btnExit);
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
