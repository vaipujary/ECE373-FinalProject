package FeastFast.ApplicationCore;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import FeastFast.OrderingAndTransactions.Review;
import FeastFast.OrderingAndTransactions.Review.ReviewEntry;
// import FeastFast.ApplicationCore.ShoppingCart.Listener;
import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;
import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.Restaurant;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Checkout extends JFrame {

	private FeastFastApplication ffa;
	private Order currentOrder;
	private Customer loggedInCustomer;
	private JComboBox<String> restaurantNames;
	
    // Content pane
    private JPanel contentPane;
	// Menu bar
	JMenuBar menuBar;
	
	// Icons
	ImageIcon icon2;
    Image scaledIcon2;
    ImageIcon newScaledIcon2;
    JButton btnHome;


    // Person Icon
    ImageIcon icon;
    Image scaledIcon;
    ImageIcon newScaledIcon;
	JButton btnUserMenu;
	
	// Log Out Icon
	ImageIcon icon3;
	Image scaledIcon3;
	ImageIcon newScaledIcon3;
	JButton btnExit;
	
	ImageIcon icon4;
	Image scaledIcon4;
	ImageIcon newScaledIcon4;
	JButton btnBack;

	
	// Side panel
	JPanel sidePanel;
	
	JSplitPane splitPane;
	
	// Side panel contents
	JLabel accountLabel;
	
	// Side panel buttons
	JButton btnUpdateName;
	JButton btnManageAddress;
	JButton btnManagePreferredPayment;
	JButton btnViewPastOrders;
	JButton btnViewReviews;
	JButton btnManagePassword;
	JButton btnUpdatePhoneNumber;
	JButton btnWriteAReview;
	
	// Order type label
	JLabel orderTypeLabel;
	
	// Payment method label
	JLabel paymentLabel;
	
	// Payment type Combo box
	JComboBox<String> comboBox;
	
	JLabel titleLabel;
	
	JButton btnContinue;
	
	// Radio buttons
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnHomeDelivery;
	private JLabel totalLabel;
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
					Checkout frame = new Checkout(ffa, order);
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
	public Checkout(FeastFastApplication ffa, Order order) {
        this.ffa = ffa;
        this.currentOrder = order;
        loggedInCustomer = ffa.getLoggedInCustomer();
        
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Icons
		icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
        scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledIcon2 = new ImageIcon(scaledIcon2);
		btnHome = new JButton(newScaledIcon2);
		btnHome.addActionListener(new Listener());

		icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
		scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon = new ImageIcon(scaledIcon);
		btnUserMenu = new JButton(newScaledIcon);
		btnUserMenu.addActionListener(new Listener());

		// Log Out Icon
		icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
		scaledIcon3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon3 = new ImageIcon(scaledIcon3);
		btnExit = new JButton(newScaledIcon3);
		btnExit.addActionListener(new Listener());

		icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		scaledIcon4 = icon4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		newScaledIcon4 = new ImageIcon(scaledIcon4);
		btnBack = new JButton(newScaledIcon4);
		btnBack.addActionListener(new Listener());
		
		accountLabel = new JLabel("Account");
		
		// Side panel buttons
		btnUpdateName = new JButton("Update Name");
		btnManageAddress = new JButton("Manage Address");
		btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
		btnViewPastOrders = new JButton("View Past Orders");
		btnViewReviews = new JButton("View Reviews");
		btnManagePassword = new JButton("Manage Password");
		btnUpdatePhoneNumber = new JButton("Update Phone Number");
		btnWriteAReview = new JButton("Write a Review");
				
		// Side Panel Button Action Listeners
		btnUpdateName.addActionListener(new Listener());
		btnManageAddress.addActionListener(new Listener());
		btnManagePreferredPayment.addActionListener(new Listener());
		btnViewPastOrders.addActionListener(new Listener());
		btnViewReviews.addActionListener(new Listener());
		btnManagePassword.addActionListener(new Listener());
		btnUpdatePhoneNumber.addActionListener(new Listener());
		btnWriteAReview.addActionListener(new Listener());
		
		// Order type label
		orderTypeLabel = new JLabel("Pickup or Home Delivery?");
		
		// Payment method label
		paymentLabel = new JLabel("Choose payment method:");
		
		// Payment type Combo box
		comboBox = new JComboBox<String>();
		
		// Combo box options
		String option1 = "Credit/Debit Card";
		String option2 = "Cash on Delivery";
		String option3 = "Gift Card";
		
		// Add items to the payment method combo box
		comboBox.addItem(option1);
		comboBox.addItem(option2);
		comboBox.addItem(option3);
		
		titleLabel = new JLabel("Checkout\n");
		
		btnContinue = new JButton("Continue");
		
		// Radio buttons
		rdbtnNewRadioButton = new JRadioButton("Pickup");
		rdbtnHomeDelivery = new JRadioButton("Home delivery");
		
		
		sidePanel = new JPanel();
		// Split Pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, contentPane); // SplitPane
		
		menuBar.add(btnHome);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(btnUserMenu);
		menuBar.add(btnExit);
		
		setContentPane(splitPane);
		contentPane.setLayout(null);
		splitPane.setDividerLocation(0);
		
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		sidePanel.setBounds(518, 0, 282, 609);
		sidePanel.setLayout(null);
		
		accountLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		accountLabel.setBounds(16, 6, 116, 40);
		sidePanel.add(accountLabel);
		
		btnUpdateName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUpdateName.setBounds(16, 59, 260, 48);
		sidePanel.add(btnUpdateName);
		
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

		orderTypeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		orderTypeLabel.setBounds(50, 103, 227, 21);
		contentPane.add(orderTypeLabel);
		
		paymentLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		paymentLabel.setBounds(50, 183, 248, 26);
		contentPane.add(paymentLabel);
		
		comboBox.setBounds(305, 181, 164, 37);
		contentPane.add(comboBox);
		
		titleLabel.setBounds(307, 21, 227, 43);
		titleLabel.setFont(new Font("Bangla MN", Font.PLAIN, 35));
		contentPane.add(titleLabel);

		btnBack.setText("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBack.setBounds(76, 513, 132, 54);
		contentPane.add(btnBack);
		
		btnContinue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnContinue.setBounds(445, 514, 132, 54);
		contentPane.add(btnContinue);
		btnContinue.addActionListener(new Listener());
		
		rdbtnNewRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(295, 101, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnHomeDelivery.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		rdbtnHomeDelivery.setBounds(438, 101, 164, 23);
		contentPane.add(rdbtnHomeDelivery);
		
		double total = currentOrder.getFinalTotal();
		String formattedTotal = String.format("$ %.2f", total);
		totalLabel = new JLabel("Total:");
		totalLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		totalLabel.setBounds(50, 248, 94, 29);
		contentPane.add(totalLabel);
		
		totalValue = new JTextField();
		totalValue.setText(formattedTotal);
		totalValue.setEditable(false);
		totalValue.setBounds(589, 245, 130, 41);
		contentPane.add(totalValue);
	}
	
	// Event listener
		private class Listener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();
				//JRadioButton source2 = (JRadioButton) e.getSource();
				
/////////////////////////////////////////Checking button events////////////////////////////////////////////
				// PersonIcon button
				if(source.equals(btnUserMenu)) {
					handleUserMenu();
				}
				// HomeIcon button
				else if(source.equals(btnHome)) {
					handleHomeIcon();
				}
				
				else if(source.equals(btnExit)) {
					handleLogOut();
				}
				
				else if(source.equals(btnContinue)) {
					handlePlaceOrder();
				}
				
				// Update Name button
				else if(source.equals(btnUpdateName)) {
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
////////////////////////////////////////Checking Radio Button events///////////////////////////////////////////////
				// Pickup radio button
				//if(source2.equals(rdbtnNewRadioButton)) {
				//	
				//}
				//else if(source2.equals(rdbtnHomeDelivery)) {
					
				//}
////////////////////////////////////////Checking combo box events///////////////////////////////////////////////////////
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
			
			// Method to handle a customer placing an order
			private void handlePlaceOrder() {
				if (currentOrder != null) {
					
					// Checking if a radio button is selected
					if(rdbtnNewRadioButton.isSelected() || rdbtnHomeDelivery.isSelected()) {
						
						// Checking if a combo box element is selected
						if(comboBox.getSelectedIndex() > -1) {
							currentOrder.isPlaced(); //Place the order		    	
							Receipt receipt = new Receipt(ffa, currentOrder);			     
							receipt.setVisible(true);
						}
						
						else {
							JOptionPane.showMessageDialog(null,
					                "You must choose a payment method.",
					                "Error",
					                JOptionPane.ERROR_MESSAGE
					        );
						}
					}
					
					else {
						JOptionPane.showMessageDialog(null,
				                "You must choose whether you want Pickup or Home Delivery.",
				                "Error",
				                JOptionPane.ERROR_MESSAGE
				        );
					}
					
					
					
					
			    } else {
			        // If the order is not placed, show a message
			        JOptionPane.showMessageDialog(null,
			                "Your cart is empty.",
			                "Empty Cart",
			                JOptionPane.INFORMATION_MESSAGE
			        );
			    }
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
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (result == JOptionPane.YES_OPTION) {
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
			
			// Method to handle a customer updating their name
			private void handleUpdateName() {
				try {
		            JFrame temp = new JFrame("Update name");
		            JLabel updateNameLabel = new JLabel("What do you want to update your name to?");
		            JTextField updateNameText = new JTextField();

		            int result = JOptionPane.showOptionDialog(temp, new Object[] { updateNameLabel, updateNameText }, "Update Name",
		                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		            if (result == JOptionPane.OK_OPTION) {
		            		loggedInCustomer.setName(updateNameText.getText());
		            		JOptionPane.showMessageDialog(null,
		                            "Your name has been updated successfully, " + loggedInCustomer.getName() + ".",
		                            "Success",
		                            JOptionPane.OK_OPTION);
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
			
			private void handleManageAddress() {
				try {
					JFrame temp = new JFrame("Update address");
					JLabel currentAddress = new JLabel();
					
					if(loggedInCustomer.getAddress() != null && !(loggedInCustomer.getAddress().equals(""))) {
						currentAddress.setText("Your current address is: " + loggedInCustomer.getAddress());
					}
					
					JLabel newAddressLabel = new JLabel("New address: ");
					
					JTextField newAddressText =  new JTextField();

					int result = JOptionPane.showOptionDialog(temp, new Object[] { currentAddress, newAddressLabel, newAddressText }, "Update Delivery Address",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (result == JOptionPane.OK_OPTION) {

							loggedInCustomer.setAddress(newAddressText.getText());
							
							JOptionPane.showMessageDialog(null,
									"Successfully changed delivery address!",
									"Success",
									JOptionPane.PLAIN_MESSAGE);
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
			
			// Method to manage a customer's preferred payment method
			private void handleManagePreferredPayment() {
				try {
					JFrame temp = new JFrame("Manage preferred payment method");
					JLabel currentPreferredPaymentMethod = new JLabel();
					
					if(loggedInCustomer.getPreferredPaymentMethod() != null && !(loggedInCustomer.getPreferredPaymentMethod().equals(""))) {
						currentPreferredPaymentMethod.setText("Your current preferred payment method is: " + loggedInCustomer.getPreferredPaymentMethod());
					}
					
					JLabel newPreferredPaymentMethodLabel = new JLabel("New preferred payment method: ");
					
					JRadioButton newPreferredPaymentMethod1 =  new JRadioButton("Credit/Debit Card");
					JRadioButton newPreferredPaymentMethod2 =  new JRadioButton("Cash on Delivery");
					JRadioButton newPreferredPaymentMethod3 =  new JRadioButton("Gift Card");

					int result = JOptionPane.showOptionDialog(temp, new Object[] { currentPreferredPaymentMethod, newPreferredPaymentMethodLabel, newPreferredPaymentMethod1, newPreferredPaymentMethod2, newPreferredPaymentMethod3 }, "Manage Preferred Payment Method",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (result == JOptionPane.OK_OPTION) {

							if(newPreferredPaymentMethod1.isSelected()) {
								loggedInCustomer.setPreferredPaymentMethod("Credit/Debit Card");
								JOptionPane.showMessageDialog(null,
										"Successfully changed your preferred payment method!",
										"Success",
										JOptionPane.PLAIN_MESSAGE);
							}
							else if(newPreferredPaymentMethod2.isSelected()) {
								loggedInCustomer.setPreferredPaymentMethod("Cash on Delivery");
								JOptionPane.showMessageDialog(null,
										"Successfully changed your preferred payment method!",
										"Success",
										JOptionPane.PLAIN_MESSAGE);
							}
							else if(newPreferredPaymentMethod3.isSelected()) {
								loggedInCustomer.setPreferredPaymentMethod("Gift Card");
								JOptionPane.showMessageDialog(null,
										"Successfully changed your preferred payment method!",
										"Success",
										JOptionPane.PLAIN_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null,
										"You must select a new preferred payment method!",
										"Error",
										JOptionPane.ERROR_MESSAGE);
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
			
			// Method to handle customer viewing past orders
			private void handleViewPastOrders() {
				String output = "";
				MenuItem menuItem = new MenuItem();
				Integer quantity; 
				ArrayList<Order> customerPastOrders = new ArrayList<Order>();
				customerPastOrders = loggedInCustomer.getPastOrders();
				HashMap<MenuItem, Integer> orderFoodItems = new HashMap<MenuItem, Integer>();
				
				for(int i = 0; i < customerPastOrders.size(); i++) {
					orderFoodItems = customerPastOrders.get(i).getFoodItems();
					
					output += customerPastOrders.get(i).getRestaurant().getName() + ": \n";
					
					for (Entry<MenuItem, Integer> entry : orderFoodItems.entrySet()) {
						menuItem = entry.getKey();
						quantity = entry.getValue();
						output += quantity.toString() + "x " + menuItem.getName() + "\n";
					}
				}
				
				JOptionPane.showMessageDialog(null, output, "Your Past Orders", JOptionPane.INFORMATION_MESSAGE);
			
			
			}
			
			// Method to handle customer viewing their past reviews
			private void handleViewReviews() {
				String output = "";
		    	String key;
		    	List<ReviewEntry> value;
		    	ArrayList<Review> customerPastReviews = new ArrayList<Review>();
		    	customerPastReviews = loggedInCustomer.getPastReviews();
		    	
		    	for(int i = 0; i < customerPastReviews.size(); i++) {
		    		
		    		Map<String, List<ReviewEntry>> allRestaurantReviews = customerPastReviews.get(i).getReviewRestaurantReviews();
		   
		    			for (Entry<String, List<ReviewEntry>> entry : allRestaurantReviews.entrySet()) {
		    	            key = entry.getKey();
		    	            value = entry.getValue();
		    	            for(int j = 0; j < loggedInCustomer.getPastOrders().size(); j++) {
		    	            	if(key.equals(loggedInCustomer.getPastOrders().get(j).getRestaurant().getName())) {
		    	            		for(int k = 0; k < value.size(); k++) {
		    	            			if(value.get(k).getCustomerName().equals(loggedInCustomer.getName())) {
		    	            				output += key + ": \n";
		    	    	            		output += value.get(k).getReviewText() + "\n";
		    	            			}
		    	            		}
		    	            	}
		    	            }
		    	        }
		    	}
		    	
		    	JOptionPane.showMessageDialog(null, output, "Your Past Reviews", JOptionPane.INFORMATION_MESSAGE);
			}
			
			// Method to handle a customer managing their password
			private void handleManagePassword() {
				try {
					JFrame temp = new JFrame("Confirm selection");
					JLabel newPassLabel = new JLabel("New password: ");
					JLabel confirmNewPassLabel = new JLabel("Confirm new password: ");
					
					JPasswordField newPassText =  new JPasswordField();
					//String newPassTextString = new String(newPassText.getPassword());
					JPasswordField confirmNewPassText = new JPasswordField();
					String confirmNewPassTextString = new String(confirmNewPassText.getPassword());

					int result = JOptionPane.showOptionDialog(temp, new Object[] { newPassLabel, newPassText, confirmNewPassLabel, confirmNewPassText }, "Set new password",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (result == JOptionPane.OK_OPTION) {
						
						if(!Arrays.equals(newPassText.getPassword(), confirmNewPassText.getPassword())) {
							JOptionPane.showMessageDialog(null,
									"Passwords don't match!",
									"Error",
									JOptionPane.ERROR_MESSAGE);
						}
						
						else {
						
							loggedInCustomer.setPassword(confirmNewPassTextString);
							
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
			
			// Method to handle customer updating their phone number
			private void handleUpdatePhoneNumber() {
				try {
					JFrame temp = new JFrame("Update phone number");
					JLabel currentPhoneNumber = new JLabel();
					
					if(loggedInCustomer.getPhoneNumber() != null) {
						currentPhoneNumber.setText("Your current phone number is: " + loggedInCustomer.getPhoneNumber());
					}
					
					JLabel newPhoneNumberLabel = new JLabel("New phone number: ");
					
					JTextField newPhoneNumberText =  new JTextField();

					int result = JOptionPane.showOptionDialog(temp, new Object[] { currentPhoneNumber, newPhoneNumberLabel, newPhoneNumberText }, "Update Phone Number",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (result == JOptionPane.OK_OPTION) {

							loggedInCustomer.setPhoneNumber(newPhoneNumberText.getText());
							
							JOptionPane.showMessageDialog(null,
									"Successfully changed phone number!",
									"Success",
									JOptionPane.PLAIN_MESSAGE);
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
			
			private void handleWriteReview() {
				try {
					JFrame temp = new JFrame("Write Review");
					ArrayList<String> restaurantNamesArrayList = new ArrayList<String>();
					
					for(int i = 0; i < ffa.getRestaurants().size(); i++) {
						restaurantNamesArrayList.add(ffa.getRestaurants().get(i).getName());
					}
					
					JLabel restaurantNameLabel = new JLabel("Which restaurant do you want to write a review for?");
					boolean hasOrderedFromRestaurant = false;
					
					SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, //initial value
					         1, //min
					         5, //max
					         1);//step
					
					JLabel ratingLabel = new JLabel("Rating");
					JSpinner rating = new JSpinner(spinnerModel);
					restaurantNames = new JComboBox<String>();
					restaurantNames.setModel(new DefaultComboBoxModel<String>(restaurantNamesArrayList.toArray(new String[0])));
					String restaurantName = String.valueOf(restaurantNames.getSelectedItem());

					JTextArea review = new JTextArea(5, 10);
					
					int result = JOptionPane.showOptionDialog(temp, new Object[] { restaurantNameLabel, restaurantNames, ratingLabel, rating, review }, "Write a Review",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

					if (result == JOptionPane.OK_OPTION) {

							Restaurant restaurant = ffa.getRestaurant(restaurantName);
							restaurant.addRating((int)rating.getValue());
							Review customerReview = new Review();
							customerReview.submitReview(restaurantName, loggedInCustomer.getName(), result, review.getText());
							
							// Check if customer has ordered from restaurant
							for(int i = 0; i < loggedInCustomer.getPastOrders().size(); i++) {
								if(loggedInCustomer.getPastOrders().get(i).getRestaurant().getName().equals(restaurantName)) {
									hasOrderedFromRestaurant = true;
								}
							}
							
							if(hasOrderedFromRestaurant) {
								restaurant.addRestaurantReview(customerReview);
								loggedInCustomer.addPastReview(customerReview);
								
								JOptionPane.showMessageDialog(null,
										"Successfully submitted restaurant review!",
										"Success",
										JOptionPane.PLAIN_MESSAGE);
							}
							
							else {
								JOptionPane.showMessageDialog(null,
										"You cannot submit a review for this restaurant because you have not ordered from this restaurant before.",
										"Error",
										JOptionPane.ERROR_MESSAGE);
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
		}
}
