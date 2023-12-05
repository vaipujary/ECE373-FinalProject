package FeastFast.ApplicationCore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.UserManagement.Restaurant;
import java.awt.TextField;

// Shopping Cart Frame
public class ShoppingCart extends JFrame {

	private FeastFastApplication ffa;
	private Order currentOrder;
	private RestaurantMenu selectedRestaurantMenu;
	private Restaurant selectedRestaurant;

	private JPanel contentPane;

	JButton btnNewButton1;
	JButton btnManageAddress;
	JButton btnManagePreferredPayment;
	JButton btnViewPastOrders;
	JButton btnViewReviews;
	JButton btnManagePassword;
	JButton btnUpdatePhoneNumber;
	JButton btnWriteAReview;

	JMenuBar menuBar;

	JPanel sidePanel;

	ImageIcon icon2;
	Image scaledIcon2;
	ImageIcon newScaledIcon2;
	JButton btnHome;

	ImageIcon icon;
	Image scaledIcon;
	ImageIcon newScaledIcon;

	JButton btnUser;

	ImageIcon icon3;
	Image scaledIcon3;
	ImageIcon newScaledIcon3;

	JButton btnCheckout;

	ImageIcon icon4;
	Image scaledIcon4;
	ImageIcon newScaledIcon4;

	// Log Out Icon
	ImageIcon icon5;
	Image scaledIcon5;
	ImageIcon newScaledIcon5;
	JButton btnExit;

	JButton btnBack;

	JLabel orderTotalLabel;

	JLabel salesTaxLabel;

	JLabel serviceFeeLabel;

	JLabel totalLabel;

	JLabel restaurantLabel;

	JButton btnEmptyCart;

	JLabel accountLabel;

	JList<String> list;
	DefaultListModel<String> listModel;
	JSplitPane splitPane;

	private JTextField orderTotalValue;
	private JTextField salesTaxValue;
	private JTextField serviceFeeValue;
	private JTextField totalValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeastFastApplication ffa = new FeastFastApplication();
					Order order = new Order();
					//Restaurant restaurant = new Restaurant();
					//RestaurantMenu restaurantMenu = new RestaurantMenu(ffa, restaurant);
					ShoppingCart frame = new ShoppingCart(ffa, order);
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
	public ShoppingCart(FeastFastApplication ffa, Order order) {
		this.ffa = ffa;
		this.currentOrder = order;
//		this.selectedRestaurantMenu = restaurantMenu;
//		this.selectedRestaurant = restaurant;

		contentPane = new JPanel();

		menuBar = new JMenuBar();

		// Icons
		icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
		scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon2 = new ImageIcon(scaledIcon2);
		btnHome = new JButton(newScaledIcon2);

		icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
		scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon = new ImageIcon(scaledIcon);

		btnUser = new JButton(newScaledIcon);
		btnUser.addActionListener(new Listener());

		icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/CheckoutIcon.png"));
		scaledIcon3 = icon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon3 = new ImageIcon(scaledIcon3);

		btnCheckout = new JButton(newScaledIcon3);

		icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon4 = new ImageIcon(scaledIcon4);
		btnBack = new JButton(newScaledIcon4);
		btnBack.addActionListener(new Listener());

		// Log Out Icon
		icon5 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
		scaledIcon5 = icon5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon5 = new ImageIcon(scaledIcon5);
		btnExit = new JButton(newScaledIcon5);
		btnExit.addActionListener(new Listener());

		// Side panel
		sidePanel = new JPanel();

		accountLabel = new JLabel("Account");

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

		// Split Pane
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, contentPane); // SplitPane

		setContentPane(splitPane); // Set the content pane to the split pane
		contentPane.setLayout(null);
		splitPane.setDividerLocation(0); // Set initial divider location

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);

		setJMenuBar(menuBar);
		menuBar.add(btnHome);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(btnUser);
		menuBar.add(btnExit);

		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		sidePanel.setBounds(518, 0, 282, 609);
		sidePanel.setLayout(null);

		contentPane.setLayout(null);

		listModel = new DefaultListModel<>();

		orderTotalLabel = new JLabel("Order total:");

		salesTaxLabel = new JLabel("Sales tax: ");

		serviceFeeLabel = new JLabel("Service fees:");

		totalLabel = new JLabel("Total:");

		btnEmptyCart = new JButton("X    Empty cart");
		btnEmptyCart.addActionListener(new Listener());

		sidePanel.setBounds(518, 0, 282, 609);
		sidePanel.setLayout(null);
		splitPane.setDividerLocation(0); // Set initial divider location

		sidePanel.setBounds(518, 0, 282, 609);
		sidePanel.setLayout(null);

		sidePanel.setBounds(518, 0, 282, 609);
		sidePanel.setLayout(null);

		accountLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		accountLabel.setBounds(16, 6, 116, 40);
		sidePanel.add(accountLabel);

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

		btnCheckout.setText("Continue to Checkout");
		btnCheckout.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnCheckout.setBounds(490, 526, 267, 55);
		contentPane.add(btnCheckout);
		btnCheckout.addActionListener(new Listener());

		btnBack.setText("Back to Menu");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBack.addActionListener(new Listener()); 
		
		btnBack.setBounds(42, 525, 195, 55);
		contentPane.add(btnBack);

		orderTotalLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		orderTotalLabel.setBounds(106, 257, 94, 29);
		contentPane.add(orderTotalLabel);

		salesTaxLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		salesTaxLabel.setBounds(106, 341, 94, 29);
		contentPane.add(salesTaxLabel);

		serviceFeeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		serviceFeeLabel.setBounds(106, 298, 114, 29);
		contentPane.add(serviceFeeLabel);

		totalLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		totalLabel.setBounds(106, 380, 94, 29);
		contentPane.add(totalLabel);

		btnEmptyCart.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnEmptyCart.setBounds(278, 526, 161, 55);
		contentPane.add(btnEmptyCart);

		// Add Restaurant Name
		restaurantLabel = new JLabel();
		if (currentOrder.getRestaurant() != null) {
			restaurantLabel.setText(currentOrder.getRestaurant().getName());
		} else {
			restaurantLabel.setText("Restaurant");
		}
		restaurantLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		restaurantLabel.setBounds(85, 6, 341, 55);
		contentPane.add(restaurantLabel);

		// Add Totals and Fees
		double orderTotal = currentOrder.getOrderPrice();
		double serviceFee = currentOrder.getServiceFee();
		double salesTax = currentOrder.getSalesTax();
		double total = currentOrder.getFinalTotal();

		// Format doubles as strings with two decimal places
		String formattedOrderTotal = String.format("$ %.2f", orderTotal);
		String formattedServiceFee = String.format("$ %.2f", serviceFee);
		String formattedSalesTax = String.format("$ %.2f", salesTax);
		String formattedTotal = String.format("$ %.2f", total);

		orderTotalValue = new JTextField();
		orderTotalValue.setText(formattedOrderTotal);
		orderTotalValue.setEditable(false);
		orderTotalValue.setBounds(598, 265, 103, 29);
		contentPane.add(orderTotalValue);

		serviceFeeValue = new JTextField();
		serviceFeeValue.setText(formattedServiceFee);
		serviceFeeValue.setEditable(false);
		serviceFeeValue.setBounds(598, 304, 103, 29);
		contentPane.add(serviceFeeValue);

		salesTaxValue = new JTextField();
		salesTaxValue.setText(formattedSalesTax);
		salesTaxValue.setEditable(false);
		salesTaxValue.setBounds(598, 347, 103, 29);
		contentPane.add(salesTaxValue);

		totalValue = new JTextField();
		totalValue.setText(formattedTotal);
		totalValue.setEditable(false);
		totalValue.setBounds(571, 388, 130, 41);
		contentPane.add(totalValue);

		//

		JLabel orderInstructionLabel = new JLabel("Order instructions (optional)");
		orderInstructionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		orderInstructionLabel.setBounds(103, 421, 254, 29);
		contentPane.add(orderInstructionLabel);

		JTextArea orderInstrTextArea = new JTextArea();
		orderInstrTextArea.setBounds(106, 450, 595, 48);
		contentPane.add(orderInstrTextArea);

		JLabel itemsLabel = new JLabel("Items: ");
		itemsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		itemsLabel.setBounds(106, 56, 72, 29);
		contentPane.add(itemsLabel);

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

		list = new JList<>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(106, 83, 595, 171);
		contentPane.add(scrollPane);

	}

	// Event listener
	// Event listener
	private class Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Button click events
			JButton source = (JButton) e.getSource();

			// User Icon button
			if (source.equals(btnUser)) {
				handleUserMenu();
			}
			// Back to Menu Icon
			else if(source.equals(btnBack)) {
				handleBackIcon();
			}
			// HomeIcon button
			else if (source.equals(btnHome)) {
				handleHomeIcon();
			} 
			else if (source.equals(btnExit)) {
				handleLogOut();
			} 
			else if (source.equals(btnCheckout)) {
				handleViewCheckout();
			}
			// Update Name button
			else if (source.equals(btnNewButton1)) {
				handleUpdateName();
			}
			// Manage Address button
			else if (source.equals(btnManageAddress)) {
				handleManageAddress();
			}
			// Manage Preferred Payment button
			else if (source.equals(btnManagePreferredPayment)) {
				handleManagePreferredPayment();
			}
			// View Past Orders button
			else if (source.equals(btnViewPastOrders)) {
				handleViewPastOrders();
			}
			// View Reviews button
			else if (source.equals(btnViewReviews)) {
				handleViewReviews();
			}
			// Manage Password button
			else if (source.equals(btnManagePassword)) {
				handleManagePassword();
			}
			// Update Phone Number button
			else if (source.equals(btnUpdatePhoneNumber)) {
				handleUpdatePhoneNumber();
			}
			// Write a Review button
			else if (source.equals(btnWriteAReview)) {
				handleWriteReview();
			}
			// Empty Cart
			else if(source.equals(btnEmptyCart)) {
				handleEmptyCart();
			}

		}
		
		// Method to handle emptying a customer's cart
		private void handleEmptyCart() {
			try {
				JFrame temp = new JFrame("Confirm selection");
				JLabel confirmLabel = new JLabel(
						"Are you sure you want to empty all of the items in your cart?");

				int result = JOptionPane.showOptionDialog(temp, new Object[] { confirmLabel }, "Confirm selection",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (result == JOptionPane.YES_OPTION) {
					currentOrder.emptyOrder();
				}

				else {
					JOptionPane.getRootFrame().dispose();
				}

			}
			// Catch errors and return them
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Error: " + ex.getMessage(),
						"Error",
						JOptionPane.ERROR_MESSAGE);
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

		private void handleViewCheckout() {
			if (currentOrder != null) {
				// Create a new ShoppingCart instance and pass the currentOrder
				Checkout checkout = new Checkout(ffa, currentOrder);
				// Set the visibility of the ShoppingCart window
				checkout.setVisible(true);
			} else {
				// If the order is not placed, show a message
				JOptionPane.showMessageDialog(null,
						"Your cart is empty. You must have items in your cart to proceed to checkout",
						"Empty Cart",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		private void handleBackIcon() {
			RestaurantMenu restaurantMenu = new RestaurantMenu(ffa, currentOrder.getRestaurant());
			restaurantMenu.setVisible(true);
		}

		// Home Icon: Return back to view restaurants
		private void handleHomeIcon() {

			try {
				JFrame temp = new JFrame("Confirm selection");
				JLabel confirmLabel = new JLabel(
						"Are you sure you want to view other restaurants? Your selections will not be saved.");

				int result = JOptionPane.showOptionDialog(temp, new Object[] { confirmLabel }, "Confirm selection",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (result == JOptionPane.YES_OPTION) {
					ViewRestaurants viewRestaurantsFrame = new ViewRestaurants(ffa);
					viewRestaurantsFrame.setVisible(true);
				}

				else {
					JOptionPane.getRootFrame().dispose();
				}

			}
			// Catch errors and return them
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Error: " + ex.getMessage(),
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		// Log Out button: return to main page
		private void handleLogOut() {
			try {
				JFrame temp = new JFrame("Confirm selection");
				JLabel confirmLabel = new JLabel("Are you sure you want to log out?");

				int result = JOptionPane.showOptionDialog(temp, new Object[] { confirmLabel }, "Confirm log out",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (result == JOptionPane.OK_OPTION) {
					MainPage mainPage = new MainPage(ffa);
					mainPage.setVisible(true);
				}

				else {
					JOptionPane.getRootFrame().dispose();
				}

			}
			// Catch errors and return them
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Error: " + ex.getMessage(),
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
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

			try {
				JFrame temp = new JFrame("Confirm selection");
				JLabel newPassLabel = new JLabel("New password: ");
				JLabel confirmNewPassLabel = new JLabel("Confirm new password: ");
				
				JPasswordField newPassText =  new JPasswordField();
				String newPassTextString = new String(newPassText.getPassword());
				JPasswordField confirmNewPassText = new JPasswordField();
				String confirmNewPassTextString = new String(confirmNewPassText.getPassword());

				int result = JOptionPane.showOptionDialog(temp, new Object[] { newPassLabel, newPassText, confirmNewPassLabel, confirmNewPassText }, "Set new password",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (result == JOptionPane.OK_OPTION) {
					
					if(newPassTextString.equals(confirmNewPassTextString)) {
					
						JOptionPane.showMessageDialog(null,
								"Successfully changed password!",
								"Success",
								JOptionPane.PLAIN_MESSAGE);
					}
					
					
					
				}

				else {
					JOptionPane.getRootFrame().dispose();
				}

			}
			// Catch errors and return them
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Error: " + ex.getMessage(),
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		private void handleUpdatePhoneNumber() {

		}

		private void handleWriteReview() {

		}
	}
}
