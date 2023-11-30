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

	// Content pane
	private JPanel contentPane = new JPanel();
	
	// Menu bar
	JMenuBar menuBar = new JMenuBar();

	// Icons
	ImageIcon icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
	Image scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon2 = new ImageIcon(scaledIcon2);
	JButton item2 = new JButton(newScaledIcon2);
	
	ImageIcon icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
	Image scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	ImageIcon newScaledIcon = new ImageIcon(scaledIcon);
	
	JButton item = new JButton(newScaledIcon);
	
	// Side panel
	JPanel panel = new JPanel();
	
	// Side panel content
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
	
	// Title
	JLabel lblNewLabel = new JLabel("View Restaurants");
	
	JList list = new JList();

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

