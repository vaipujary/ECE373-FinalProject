package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

// // Restaurant Menu Frame
public class RestaurantMenu extends JFrame {

	FeastFastApplication ffa;
	
	private JPanel contentPane;
	
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
	
	JLabel lblNewLabel;
	
	JList list;
	
	ImageIcon icon3;
	Image scaledIcon3;
	ImageIcon newScaledIcon3;
	
	
	JButton btnNewButton;
	
	ImageIcon icon4;
	Image scaledIcon4;
	ImageIcon newScaledIcon4;
	
	JButton btnBackToView;
	
	// TODO: display restaurant name of the menu the customer is viewing
	JLabel lblNewLabel_1;
	
	JLabel lblNewLabel_2;
	
	JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantMenu frame = new RestaurantMenu();
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
	public RestaurantMenu() {
		
		contentPane = new JPanel();
		
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
		
		lblNewLabel = new JLabel("Menu\n");
		
		list = new JList();
		
		icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/CartIcon.png"));
		scaledIcon3 = icon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon3 = new ImageIcon(scaledIcon3);
		
		
		btnNewButton = new JButton(newScaledIcon3);
		
		icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon4 = new ImageIcon(scaledIcon4);
		
		btnBackToView = new JButton(newScaledIcon4);
		
		// TODO: display restaurant name of the menu the customer is viewing
		lblNewLabel_1 = new JLabel("- Restaurant Name - ");
		
		lblNewLabel_2 = new JLabel("Rating: ");
		
		lblNewLabel_3 = new JLabel("Rating placeholder\n");
		
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
		
		
		lblNewLabel.setFont(new Font("Bangla MN", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 91, 104, 56);
		contentPane.add(lblNewLabel);
		
		
		list.setBounds(148, 146, 553, 351);
		contentPane.add(list);
		
		
		btnNewButton.setText("View Cart");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(503, 525, 206, 52);
		contentPane.add(btnNewButton);
		
		
		btnBackToView.setText("Back to View Restaurants");
		btnBackToView.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBackToView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBackToView.setBounds(131, 525, 304, 52);
		contentPane.add(btnBackToView);
		

		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(218, 20, 423, 48);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(534, 69, 96, 32);
		contentPane.add(lblNewLabel_2);
		
		
		lblNewLabel_3.setBounds(612, 80, 140, 16);
		contentPane.add(lblNewLabel_3);
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
