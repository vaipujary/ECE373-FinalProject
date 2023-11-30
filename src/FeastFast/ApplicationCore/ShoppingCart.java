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

	private JPanel contentPane = new JPanel();
	private JTextField textField = new JTextField();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	JPanel panel = new JPanel();
	
	JLabel lblNewLabel1 = new JLabel("Account");
	JButton btnNewButton1 = new JButton("Update Name");
	JButton btnManageAddress = new JButton("Manage Address");
	JButton btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
	JButton btnViewPastOrders = new JButton("View Past Orders");
	JButton btnViewReviews = new JButton("View Reviews");
	JButton btnManagePassword = new JButton("Manage Password");
	JButton btnUpdatePhoneNumber = new JButton("Update Phone Number");
	JButton btnWriteAReview = new JButton("Write a Review");
	
	JMenuBar menuBar = new JMenuBar();
	
	ImageIcon icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
	Image scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon2 = new ImageIcon(scaledIcon2);
	//menuBar.add(Box.createHorizontalGlue());
	JButton item2 = new JButton(newScaledIcon2);
	
	ImageIcon icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
	Image scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon = new ImageIcon(scaledIcon);
	
	JButton item = new JButton(newScaledIcon);
	
	ImageIcon icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/CheckoutIcon.png"));
	Image scaledIcon3 = icon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon3 = new ImageIcon(scaledIcon3);
	
	JButton btnNewButton = new JButton(newScaledIcon3);
	
	ImageIcon icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
	Image scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon4 = new ImageIcon(scaledIcon4);
	
	JButton btnNewButton_1 = new JButton(newScaledIcon4);
	
	JLabel lblNewLabel = new JLabel("Order total:");
	
	JLabel lblSalesTax = new JLabel("Sales tax: ");
	
	JLabel lblServiceFee = new JLabel("Service fee:");
	
	JLabel lblTotal = new JLabel("Total:");
	
	JButton btnNewButton_1_1 = new JButton("X    Empty cart");

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
					JButton source = (JButton) e.getSource();
					
					// PersonIcon button
					if(source.equals(item)) {
						
					}
					// HomeIcon button
					else if(source.equals(item2)) {
						
					}
					// Update Name button
					else if(source.equals(btnNewButton1)) {
						
					}
					// Manage Address button
					else if(source.equals(btnManageAddress)){
						
					}
					// Manage Preferred Payment button
					else if(source.equals(btnManagePreferredPayment)) {
						
					}
					// View Past Orders button
					else if(source.equals(btnViewPastOrders)) {
						
					}
					// View Reviews button
					else if(source.equals(btnViewReviews)) {
						
					}
					// Manage Password button
					else if(source.equals(btnManagePassword)) {
						
					}
					// Update Phone Number button
					else if(source.equals(btnUpdatePhoneNumber)) {
						
					}
					// Write a Review button
					else if(source.equals(btnWriteAReview)) {
						
					}

					
				}
			}
}
