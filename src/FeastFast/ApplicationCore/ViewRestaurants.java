package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class ViewRestaurants extends JFrame {

	FeastFastApplication ffa;
	
	// Content pane
	private JPanel contentPane;
	
	// Menu bar
	JMenuBar menuBar;

	// Icons
	// Home Icon
	ImageIcon icon2;
	Image scaledIcon2;
	ImageIcon newScaledIcon2;
	JButton item2;
	
	// Person Icon
	ImageIcon icon;
	Image scaledIcon;
	ImageIcon newScaledIcon;
	JButton item;
	
	// Log Out Icon
	ImageIcon icon3;
	Image scaledIcon3;
	ImageIcon newScaledIcon3;
	JButton item3;
	
	// Side panel
	JPanel panel;
	
	// Side panel content
	JLabel lblNewLabel1;
	
	// Side panel buttons
	JButton btnNewButton1;
	JButton btnManageAddress;
	JButton btnManagePreferredPayment;
	JButton btnViewPastOrders;
	JButton btnViewReviews;
	JButton btnManagePassword;
	JButton btnUpdatePhoneNumber;
	JButton btnWriteAReview;
	
	// Title
	JLabel lblNewLabel;
	
	JList list;

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
	 * Create the application.
	 */
	public ViewRestaurants() {
		
		// Content pane
		contentPane = new JPanel();
		
		// Menu bar
		menuBar = new JMenuBar();

		// Icons
		// Home Icon
		icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
		scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon2 = new ImageIcon(scaledIcon2);
		item2 = new JButton(newScaledIcon2);
		
		// Person Icon
		icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
		scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon = new ImageIcon(scaledIcon);
		
		// Log Out Icon
		icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
		scaledIcon3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon3 = new ImageIcon(scaledIcon3);
		item3 = new JButton(newScaledIcon3);
		
		
		item = new JButton(newScaledIcon);
		
		// Side panel
		panel = new JPanel();
		
		// Side panel content
		lblNewLabel1 = new JLabel("Account");
		
		// Side panel buttons
		btnNewButton1 = new JButton("Update Name");
		btnManageAddress = new JButton("Manage Address");
		btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
		btnViewPastOrders = new JButton("View Past Orders");
		btnViewReviews = new JButton("View Reviews");
		btnManagePassword = new JButton("Manage Password");
		btnUpdatePhoneNumber = new JButton("Update Phone Number");
		btnWriteAReview = new JButton("Write a Review");
		
		// Title
		lblNewLabel = new JLabel("View Restaurants");
		
		list = new JList();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		
		setJMenuBar(menuBar);
		
		menuBar.add(item2);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(item);
		menuBar.add(item3);
		
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

		
		
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel.setBounds(242, 6, 305, 63);
		contentPane.add(lblNewLabel);
		
		
		list.setBounds(77, 81, 496, 487);
		contentPane.add(list);
		
	}
	
	// Event listener
	private class Listener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			
			// PersonIcon button
			if(source.equals(item)) {
				handlePersonIcon();
			}
			// HomeIcon button
			else if(source.equals(item2)) {
				handleHomeIcon();
			}
			else if(source.equals(item3)) {
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

