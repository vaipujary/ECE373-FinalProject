package FeastFast.ApplicationCore;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.User;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;

public class SignUpPage extends JFrame {
	
	private FeastFastApplication ffa;
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JPanel contentPane;
	JLabel lblUsername;
	JLabel lblPassword;
	JButton btnSignUp;
	JButton btnBack;
	JLabel lblTitle;
	private JLabel lblName;
	private JTextField nameField;
	private JLabel lblUserType;
	ImageIcon icon4;
	Image scaledIcon4;
	ImageIcon newScaledIcon4;
	private JComboBox<String> usertypeBox;
	private Customer newCustomer = new Customer(); 
	private JLabel lblEmail;
	private JTextField emailTextField;
	private JLabel lblReenterPassword;
	private JPasswordField reenterPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    FeastFastApplication ffa = new FeastFastApplication();
					SignUpPage frame = new SignUpPage(ffa);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUpPage(FeastFastApplication ffa) {
		this.ffa = ffa;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername.setBounds(75, 236, 129, 16);
		contentPane.add(lblUsername);
		
		//Password Text Field
		passwordField = new JPasswordField();
		passwordField.setBounds(366, 276, 129, 40);
		contentPane.add(passwordField);
		
		//Password Label
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(75, 285, 117, 16);
		contentPane.add(lblPassword);
		
		//Sign Up Button
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSignUp.setBounds(317, 392, 117, 56);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new Listener());
		
		//Username Text Field
		usernameField = new JTextField();
		usernameField.setBounds(365, 228, 130, 39);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		//Sign Up
		lblTitle = new JLabel("Sign Up");
		lblTitle.setFont(new Font("Bangla MN", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setBounds(232, 18, 150, 47);
		contentPane.add(lblTitle);
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblName.setBounds(75, 142, 91, 16);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(367, 134, 130, 39);
		contentPane.add(nameField);
		
		lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUserType.setBounds(75, 94, 129, 25);
		contentPane.add(lblUserType);
		
		usertypeBox = new JComboBox<>();
		usertypeBox.setModel(new DefaultComboBoxModel<>(new String[] {"Customer", "Restaurant", "DeliveryDriver", "Administrator"}));
		usertypeBox.setBounds(367, 92, 129, 27);
		contentPane.add(usertypeBox);
		
		icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon4 = new ImageIcon(scaledIcon4);
		
		//Back Button
		btnBack = new JButton(newScaledIcon4);
		btnBack.setText("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBack.setBounds(135, 392, 129, 56);
		contentPane.add(btnBack);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEmail.setBounds(75, 187, 129, 16);
		contentPane.add(lblEmail);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(366, 185, 130, 39);
		contentPane.add(emailTextField);
		
		lblReenterPassword = new JLabel("Re-enter password:");
		lblReenterPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblReenterPassword.setBounds(75, 324, 204, 26);
		contentPane.add(lblReenterPassword);
		
		// Re-enter password text field
		reenterPasswordField = new JPasswordField();
		reenterPasswordField.setBounds(366, 320, 129, 40);
		contentPane.add(reenterPasswordField);
		
		setBounds(100, 100, 600, 500);
		btnBack.addActionListener(new Listener());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class Listener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// Button click events
			JButton source = (JButton) e.getSource();
			
			if(source.equals(btnBack)) {
				dispose();
			}
			else if(source.equals(btnSignUp)) {
				handleSignUpUser();
			}
			

		}
		
		private void handleSignUpUser() {
		        try {	
	            	String name = nameField.getText();
	                String username = usernameField.getText();
	                char[] passwordChars = passwordField.getPassword();
	                char[] reenterPasswordChars = reenterPasswordField.getPassword();
	                String reenterPassword = new String(reenterPasswordChars);
	                String password = new String(passwordChars);
	                String selectedUserType = (String) usertypeBox.getSelectedItem(); ;
	                
	                

	            //Verify input is not empty
	            if (name.isEmpty() || username.isEmpty() || password.isEmpty() ){
	                throw new IllegalArgumentException("All fields must be filled.");
	            }
	          
	            
	            //Instantiate New User with given credentials
	            if(selectedUserType.equals("Customer")) {
	            	
	            	if(password.equals(reenterPassword)) {
	            	//ffa here to add user     
	            	Customer newCustomer = ffa.registerCustomer(name, username, password);

	                // Add the new customer to the application
	                ffa.addCustomer(newCustomer);

		                JOptionPane.showMessageDialog(null,
		                		"Welcome " + name + ", you have been signed up for Feast Fast!",
		                        "Success",		                
		                        JOptionPane.PLAIN_MESSAGE);
		                dispose();		  
		                return;
	            	}
	            	
	            	else {
	            		JOptionPane.showMessageDialog(null,
			                    "Error: Passwords don't match! Please re-enter correct password.",
			                    "Error",
			                    JOptionPane.ERROR_MESSAGE);
	            	}
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
