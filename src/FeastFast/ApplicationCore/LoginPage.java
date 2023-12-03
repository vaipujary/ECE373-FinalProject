package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.User;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
	private FeastFastApplication ffa;
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JPanel contentPane;
	JLabel lblUsername;
	JLabel lblPassword;
	JButton btnLogin;
	JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeastFastApplication ffa = new FeastFastApplication();
					LoginPage window = new LoginPage(ffa);
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
	public LoginPage(FeastFastApplication ffa) {
		this.ffa = ffa;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUsername.setBounds(49, 92, 91, 16);
		contentPane.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 147, 129, 40);
		contentPane.add(passwordField);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPassword.setBounds(49, 159, 91, 16);
		contentPane.add(lblPassword);
		
		//Login Button
		btnLogin = new JButton("Login");
		btnLogin.setBounds(161, 215, 117, 29);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new Listener());
		
		usernameField = new JTextField();
		usernameField.setBounds(249, 81, 130, 39);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		lblTitle = new JLabel("Log In");
		lblTitle.setFont(new Font("Bangla MN", Font.BOLD | Font.ITALIC, 25));
		lblTitle.setBounds(178, 20, 85, 40);
		contentPane.add(lblTitle);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
private class Listener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// Button click events
			JButton source = (JButton) e.getSource();
			
			if(source.equals(btnLogin)) {
				handleLogin();
			}
			
			

		}
		
		private void handleLogin() {
		        try {	
	                String username = usernameField.getText();
	                char[] passwordChars = passwordField.getPassword();
	                String password = new String(passwordChars);
	                
	                

	            //Verify input is not empty
	            if (username.isEmpty() || password.isEmpty() ){
	                throw new IllegalArgumentException("All fields must be filled.");
	            }
	            
	            //ISSUE
	            //LOOK THROUGH USERS TO FIND USERNAME
	            boolean found = false;
	            	         

	            // Look through users to find username
	            for (Customer customer : ffa.getCustomers()) {
	                if (customer.getUserName().equals(username)) {
	                    found = true;
	                    System.out.println("Found you! User: " + username);
	                    JOptionPane.showMessageDialog(null,
	                            "Found you! User: " + username,
	                            "Success",
	                            JOptionPane.PLAIN_MESSAGE);

	                    // Check the password
	                    if (customer.getPassword().equals(password)) {
	                        // Password is correct, you can proceed with further actions
	                        System.out.println("Password is correct");
	                    } else {
	                        // Password is incorrect
	                        System.out.println("Incorrect password");
	                        JOptionPane.showMessageDialog(null,
	                                "Incorrect password for user: " + username,
	                                "Failure",
	                                JOptionPane.ERROR_MESSAGE);
	                    }
	                    

	                    break; // Exit the loop since the user is found
	                }
	            }

	            if (!found) {
	            	String list = ffa.getCustomers().toString() ;
	                JOptionPane.showMessageDialog(null,
	                        "Sorry, " + username + " was not found :("
	                        + "\n Heres what we found: \n" + list,
	                        "Failure",
	                        JOptionPane.PLAIN_MESSAGE);
	            }
	            }
	            
		        //Catch errors and return them
		        catch (Exception ex) {
		            JOptionPane.showMessageDialog(null,
		                    "Error: " + ex.getMessage(),
		                    "Error",
		                    JOptionPane.ERROR_MESSAGE);
		        }		     		
		}
		
		
	}

}

