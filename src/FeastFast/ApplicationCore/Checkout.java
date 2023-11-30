package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Checkout extends JFrame {

	// Content pane
	private JPanel contentPane = new JPanel();
	// Menu bar
	JMenuBar menuBar = new JMenuBar();
	
	// Icons
	ImageIcon icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
	Image scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon2 = new ImageIcon(scaledIcon2);
	//menuBar.add(Box.createHorizontalGlue());
	JButton item2 = new JButton(newScaledIcon2);
	
	ImageIcon icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
	Image scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon = new ImageIcon(scaledIcon);
	
	ImageIcon icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
	Image scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon4 = new ImageIcon(scaledIcon4);
	JButton btnNewButton = new JButton(newScaledIcon4);
	
	// PersonIcon button
	JButton item = new JButton(newScaledIcon);
	
	// Side panel
	JPanel panel = new JPanel();
	
	// Side panel contents
	JLabel lblNewLabel1 = new JLabel("Account");
	
	// Side panel buttons
	JButton btnNewButton1 = new JButton("Update Name");
	JButton btnManageAddress = new JButton("Manage Address");
	JButton btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
	JButton btnViewPastOrders = new JButton("View Past Orders");
	JButton btnViewReviews = new JButton("View Reviews");
	JButton btnManagePassword = new JButton("Manage Password");
	JButton btnUpdatePhoneNumber = new JButton("Update Phone Number");
	JButton btnWriteAReview = new JButton("Write a Review");
	
	// Order type label
	JLabel lblNewLabel = new JLabel("Pickup or Home Delivery?");
	
	// Payment method label
	JLabel lblChoosePaymentMethod = new JLabel("Choose payment method:");
	
	// Payment type Combo box
	JComboBox comboBox = new JComboBox();
	
	JLabel lblNewLabel_1 = new JLabel("Checkout\n");
	
	JButton btnContinue = new JButton("Continue");
	
	// Radio buttons
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Pickup");
	JRadioButton rdbtnHomeDelivery = new JRadioButton("Home delivery");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkout frame = new Checkout();
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
	public Checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		
		setJMenuBar(menuBar);
		
		menuBar.add(item2);
		
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(item);
		
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

		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 103, 227, 21);
		contentPane.add(lblNewLabel);
		
		lblChoosePaymentMethod.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblChoosePaymentMethod.setBounds(50, 183, 248, 26);
		contentPane.add(lblChoosePaymentMethod);
		
		comboBox.setBounds(370, 181, 164, 37);
		contentPane.add(comboBox);
		
		lblNewLabel_1.setBounds(307, 21, 227, 43);
		lblNewLabel_1.setFont(new Font("Bangla MN", Font.PLAIN, 35));
		contentPane.add(lblNewLabel_1);

		btnNewButton.setText("Back");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(76, 513, 132, 54);
		contentPane.add(btnNewButton);
		
		btnContinue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnContinue.setBounds(445, 514, 132, 54);
		contentPane.add(btnContinue);
		
		rdbtnNewRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(295, 101, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnHomeDelivery.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		rdbtnHomeDelivery.setBounds(438, 101, 164, 23);
		contentPane.add(rdbtnHomeDelivery);
	}
	
	// Event listener
		private class Listener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				JRadioButton source2 = (JRadioButton) e.getSource();
				
/////////////////////////////////////////Checking button events////////////////////////////////////////////
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
////////////////////////////////////////Checking Radio Button events///////////////////////////////////////////////
				// Pickup radio button
				if(source2.equals(rdbtnNewRadioButton)) {
					
				}
				else if(source2.equals(rdbtnHomeDelivery)) {
					
				}
////////////////////////////////////////Checking combo box events///////////////////////////////////////////////////////
			}
		}
}
