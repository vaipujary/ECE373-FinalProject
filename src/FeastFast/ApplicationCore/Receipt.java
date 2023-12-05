package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;

import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;

public class Receipt extends JFrame {

	private FeastFastApplication ffa;
	private Order currentOrder;
	
	JPanel contentPane;
	JMenuBar menuBar;
	
	ImageIcon icon2;
	Image scaledIcon2;
	ImageIcon newScaledIcon2;
	JButton item2;
	
	ImageIcon icon;
	Image scaledIcon;
	ImageIcon newScaledIcon;
	
	// Log Out Icon
	ImageIcon icon3;
	Image scaledIcon3;
	ImageIcon newScaledIcon3;
	JButton item3;
	
	JButton btnUserMenu;
	
	JPanel sidePanel;
	
	JLabel lblNewLabel1;
	
	JButton btnNewButton1;
	
	JButton btnManageAddress;
	
	JButton btnManagePreferredPayment;
	
	JButton btnViewPastOrders;
	
	JButton btnViewReviews;
	
	JButton btnManagePassword;
	
	JButton btnUpdatePhoneNumber;
	
	JButton btnWriteAReview;
	
	JLabel lblNewLabel;
	
	JLabel lblItems;
	
	JList<String> list;
	DefaultListModel<String> listModel;

    JSplitPane splitPane; // Added JSplitPane

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeastFastApplication ffa = new FeastFastApplication();
					Order order = new Order();
					Receipt frame = new Receipt(ffa,order);
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
	public Receipt(FeastFastApplication ffa, Order order) {
        this.ffa = ffa;
        this.currentOrder = order;
        
		contentPane = new JPanel();
		menuBar = new JMenuBar();
		
		icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
		scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon2 = new ImageIcon(scaledIcon2);
		item2 = new JButton(newScaledIcon2);
		
		icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
		scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon = new ImageIcon(scaledIcon);
		
		// Log Out Icon
		icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
		scaledIcon3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon3 = new ImageIcon(scaledIcon3);
		item3 = new JButton(newScaledIcon3);
		
		btnUserMenu = new JButton(newScaledIcon);
		btnUserMenu.addActionListener(new Listener());
		
		sidePanel = new JPanel();
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, contentPane); // SplitPane

        setContentPane(splitPane); // Set the content pane to the split pane
        contentPane.setLayout(null);
        splitPane.setDividerLocation(0); // Set initial divider location
		
		lblNewLabel1 = new JLabel("Account");
		
		btnNewButton1 = new JButton("Update Name");
		
		btnManageAddress = new JButton("Manage Address");
		
		btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
		
		btnViewPastOrders = new JButton("View Past Orders");
		
		btnViewReviews = new JButton("View Reviews");
		
		btnManagePassword = new JButton("Manage Password");
		
		btnUpdatePhoneNumber = new JButton("Update Phone Number");
		
		btnWriteAReview = new JButton("Write a Review");
		
		lblNewLabel = new JLabel("Order Summary");
		
		lblItems = new JLabel("Items: ");
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setJMenuBar(menuBar);
	
		menuBar.add(item2);
		
		menuBar.add(Box.createHorizontalGlue());
		
		menuBar.add(btnUserMenu);
		menuBar.add(item3);
		
		sidePanel.setBounds(518, 0, 282, 609);
		sidePanel.setLayout(null);
		
		lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel1.setBounds(16, 6, 116, 40);
		sidePanel.add(lblNewLabel1);
		
		btnNewButton1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton1.setBounds(16, 59, 260, 48);
		sidePanel.add(btnNewButton1);
		
		btnManageAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnManageAddress.setBounds(16, 275, 260, 48);
		sidePanel.add(btnManageAddress);
		
		btnManagePreferredPayment.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnManagePreferredPayment.setBounds(16, 346, 260, 48);
		sidePanel.add(btnManagePreferredPayment);
		
		btnViewPastOrders.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnViewPastOrders.setBounds(16, 406, 260, 48);
		sidePanel.add(btnViewPastOrders);
		
		btnViewReviews.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnViewReviews.setBounds(16, 544, 260, 48);
		sidePanel.add(btnViewReviews);
		
		btnManagePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnManagePassword.setBounds(16, 204, 260, 48);
		sidePanel.add(btnManagePassword);
		
		btnUpdatePhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUpdatePhoneNumber.setBounds(16, 134, 260, 48);
		sidePanel.add(btnUpdatePhoneNumber);
		
		btnWriteAReview.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnWriteAReview.setBounds(16, 473, 260, 48);
		sidePanel.add(btnWriteAReview);
		
		lblNewLabel.setFont(new Font("Bangla MN", Font.PLAIN, 35));
		lblNewLabel.setBounds(51, 6, 322, 82);
		contentPane.add(lblNewLabel);
		
		lblItems.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblItems.setBounds(51, 87, 595, 37);
		contentPane.add(lblItems);
		
		listModel = new DefaultListModel<>();
		
		if (currentOrder != null) {
	        HashMap<MenuItem, Integer> orderItems = currentOrder.getItems();

	        if (!orderItems.isEmpty()) {
	            for (Map.Entry<MenuItem, Integer> entry : orderItems.entrySet()) {
	                MenuItem item = entry.getKey();
	                int quantity = entry.getValue();
	                listModel.addElement(quantity + " x " + item.getName());
	            }
	        } else {
	            System.out.println("Order is empty.");
	        }
	    } else {
	        System.out.println("Order is null.");
	    }
		
		list = new JList<>(listModel); // Initialize the list
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(106, 83, 595, 171);
        contentPane.add(scrollPane);
	}
	
	// Event listener
	private class Listener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			
			// PersonIcon button
			if(source.equals(btnUserMenu)) {
				handleUserMenu();
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
		
		private void handleUserMenu() {
	        // Toggle the side panel visibility by adjusting the divider location
	        int currentLocation = splitPane.getDividerLocation();
	        if (currentLocation < 10) {
	            // Show the side panel
	            splitPane.setDividerLocation(282);
	        } else {
	            // Hide the side panel
	            splitPane.setDividerLocation(0);
	        }
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
