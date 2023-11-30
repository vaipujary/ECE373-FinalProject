package FeastFast.ApplicationCore;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;

// Shopping Cart Frame
public class ShoppingCart extends JFrame {

	FeastFastApplication ffa;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	JPanel panel;
	
	JLabel lblNewLabel1;
	JButton btnNewButton1;
	JButton btnManageAddress;
	JButton btnManagePreferredPayment;
	JButton btnViewPastOrders;
	JButton btnViewReviews;
	JButton btnManagePassword;
	JButton btnUpdatePhoneNumber;
	JButton btnWriteAReview;
	
	JMenuBar menuBar;
	
	ImageIcon icon2;
	Image scaledIcon2;
	ImageIcon newScaledIcon2;
	JButton item2;
	
	ImageIcon icon;
	Image scaledIcon;
	ImageIcon newScaledIcon;
	
	JButton item;
	
	ImageIcon icon3;
	Image scaledIcon3;
	ImageIcon newScaledIcon3;
	
	JButton btnNewButton;
	
	ImageIcon icon4;
	Image scaledIcon4;
	ImageIcon newScaledIcon4;
	
	// Log Out Icon
	ImageIcon icon5;
	Image scaledIcon5;
	ImageIcon newScaledIcon5;
	JButton item5;
	
	JButton btnNewButton_1;
	
	JLabel lblNewLabel;
	
	JLabel lblSalesTax;
	
	JLabel lblServiceFee;
	
	JLabel lblTotal;
	
	JButton btnNewButton_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCart frame = new ShoppingCart();
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
	public ShoppingCart() {
		
		contentPane = new JPanel();
		textField = new JTextField();
		textField_1 = new JTextField();
		textField_2 = new JTextField();
		textField_3 = new JTextField();
		
		panel = new JPanel();
		
		lblNewLabel1 = new JLabel("Account");
		btnNewButton1 = new JButton("Update Name");
		btnManageAddress = new JButton("Manage Address");
		btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
		btnViewPastOrders = new JButton("View Past Orders");
		btnViewReviews = new JButton("View Reviews");
		btnManagePassword = new JButton("Manage Password");
		btnUpdatePhoneNumber = new JButton("Update Phone Number");
		btnWriteAReview = new JButton("Write a Review");
		
		menuBar = new JMenuBar();
		
		icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
		scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon2 = new ImageIcon(scaledIcon2);
		item2 = new JButton(newScaledIcon2);
		
		icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
		scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon = new ImageIcon(scaledIcon);
		
		item = new JButton(newScaledIcon);
		
		icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/CheckoutIcon.png"));
		scaledIcon3 = icon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon3 = new ImageIcon(scaledIcon3);
		
		btnNewButton = new JButton(newScaledIcon3);
		
		icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon4 = new ImageIcon(scaledIcon4);
		
		// Log Out Icon
		icon5 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
		scaledIcon5 = icon5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon5 = new ImageIcon(scaledIcon5);
		item5 = new JButton(newScaledIcon5);
		
		btnNewButton_1 = new JButton(newScaledIcon4);
		
		lblNewLabel = new JLabel("Order total:");
		
		lblSalesTax = new JLabel("Sales tax: ");
		
		lblServiceFee = new JLabel("Service fee:");
		
		lblTotal = new JLabel("Total:");
		
		btnNewButton_1_1 = new JButton("X    Empty cart");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel.setBounds(518, 0, 282, 609);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel1.setBounds(16, 6, 116, 40);
		panel.add(lblNewLabel1);
		
		
		btnNewButton1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton1.setBounds(16, 59, 260, 48);
		panel.add(btnNewButton1);
		
		
		btnManageAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnManageAddress.setBounds(16, 275, 260, 48);
		panel.add(btnManageAddress);
		
		
		btnManagePreferredPayment.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnManagePreferredPayment.setBounds(16, 346, 260, 48);
		panel.add(btnManagePreferredPayment);
		
		
		btnViewPastOrders.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnViewPastOrders.setBounds(16, 406, 260, 48);
		panel.add(btnViewPastOrders);
		
		
		btnViewReviews.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnViewReviews.setBounds(16, 544, 260, 48);
		panel.add(btnViewReviews);
		
		
		btnManagePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnManagePassword.setBounds(16, 204, 260, 48);
		panel.add(btnManagePassword);
		
		
		btnUpdatePhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUpdatePhoneNumber.setBounds(16, 134, 260, 48);
		panel.add(btnUpdatePhoneNumber);
		
		
		btnWriteAReview.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnWriteAReview.setBounds(16, 473, 260, 48);
		panel.add(btnWriteAReview);
		
		
		setJMenuBar(menuBar);
		
		
		menuBar.add(item2);
		
		menuBar.add(Box.createHorizontalGlue());
		
		menuBar.add(item);
		menuBar.add(item5);
		
		btnNewButton.setText("Continue to Checkout");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(490, 526, 267, 55);
		contentPane.add(btnNewButton);
		

		btnNewButton_1.setText("Back to Menu");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(42, 525, 195, 55);
		contentPane.add(btnNewButton_1);
		
		
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(106, 257, 94, 29);
		contentPane.add(lblNewLabel);
		
		
		lblSalesTax.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSalesTax.setBounds(106, 298, 94, 29);
		contentPane.add(lblSalesTax);
		
		
		lblServiceFee.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblServiceFee.setBounds(106, 339, 94, 29);
		contentPane.add(lblServiceFee);
		
		
		lblTotal.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblTotal.setBounds(106, 380, 94, 29);
		contentPane.add(lblTotal);
		
		
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(278, 526, 161, 55);
		contentPane.add(btnNewButton_1_1);
		
		
		textField.setBounds(571, 373, 130, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(571, 331, 130, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(571, 290, 130, 36);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(571, 253, 130, 36);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("- Restaurant Name - ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel_1.setBounds(85, 6, 341, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblOrderInstructions = new JLabel("Order instructions (optional)");
		lblOrderInstructions.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblOrderInstructions.setBounds(103, 421, 254, 29);
		contentPane.add(lblOrderInstructions);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(106, 450, 595, 48);
		contentPane.add(textArea);
		
		JLabel lblItems = new JLabel("Items: ");
		lblItems.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblItems.setBounds(106, 56, 72, 29);
		contentPane.add(lblItems);
		
		JList list = new JList();
		list.setBounds(106, 83, 595, 171);
		contentPane.add(list);
	}
	
	// Event listener
			private class Listener implements ActionListener {
				
				public void actionPerformed(ActionEvent e) {
					
					// Button click events
					JButton source = (JButton) e.getSource();
					
					// PersonIcon button
					if(source.equals(item)) {
						handlePersonIcon();
					}
					// HomeIcon button
					else if(source.equals(item2)) {
						handleHomeIcon();
					}
					else if(source.equals(item5)) {
						handleLogOut();
					}
					// Update Name button
					else if(source.equals(btnNewButton1)) {
						handleUpdateName();
					}
					// Manage Address button
					else if(source.equals(btnManageAddress)){
						handleManageAddress();
					}
					// Manage Preferred Payment button
					else if(source.equals(btnManagePreferredPayment)) {
						handleManagePreferredPayment();
					}
					// View Past Orders button
					else if(source.equals(btnViewPastOrders)) {
						handleViewPastOrders();
					}
					// View Reviews button
					else if(source.equals(btnViewReviews)) {
						handleViewReviews();
					}
					// Manage Password button
					else if(source.equals(btnManagePassword)) {
						handleManagePassword();
					}
					// Update Phone Number button
					else if(source.equals(btnUpdatePhoneNumber)) {
						handleUpdatePhoneNumber();
					}
					// Write a Review button
					else if(source.equals(btnWriteAReview)) {
						handleWriteReview();
					}

					
				}
				
				private void handlePersonIcon() {
					
					
				}
				
				private void handleHomeIcon() {
					
				}
				
				private void handleLogOut() {
					
				}
				
				private void handleUpdateName() {
					
				}
				
				private void handleManageAddress() {
					
				}
				
				private void handleManagePreferredPayment() {
					
				}
				
				private void handleViewPastOrders() {
					
				
				
				}
				
				private void handleViewReviews() {
					
				}
				
				private void handleManagePassword() {
					
				}
				
				private void handleUpdatePhoneNumber() {
					
				}
				
				private void handleWriteReview() {
					
				}
			}
}
