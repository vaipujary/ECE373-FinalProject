package FeastFast.ApplicationCore;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.RestaurantManagement.Order;
import FeastFast.RestaurantManagement.Menu;
import FeastFast.UserManagement.Restaurant;

public class RestaurantMenu extends JFrame {

    private FeastFastApplication ffa;
    private Order currentOrder;

    private JPanel contentPane;

    JMenuBar menuBar;

    ImageIcon homeIcon;
    Image scaledHomeIcon;
    ImageIcon newScaledHomeIcon;
    JButton homeMenu;

    ImageIcon personIcon;
    Image scaledPersonIcon;
    ImageIcon newScaledPersonIcon;
    JButton userMenu;

    ImageIcon logOutIcon;
    Image scaledLogOutIcon;
    ImageIcon newScaledLogOutIcon;
    JButton exit;

    JPanel sidePanel;

    JLabel accountLabel;

    JButton btnUpdateName;
    JButton btnManageAddress;
    JButton btnManagePreferredPayment;
    JButton btnViewPastOrders;
    JButton btnViewReviews;
    JButton btnManagePassword;
    JButton btnUpdatePhoneNumber;
    JButton btnWriteAReview;

    JLabel restaurantNameLabel; 

    JLabel ratingLabel;

    JLabel ratingValueLabel;

    JButton btnViewCart;

    JButton btnBackToView;
    JSplitPane splitPane;
    JList<String> list;
    DefaultListModel<String> listModel;
    JLabel menuLabel;
    JLabel lblRestaurant;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FeastFastApplication ffa = new FeastFastApplication();
                    Restaurant restaurant = new Restaurant();
                    RestaurantMenu frame = new RestaurantMenu(ffa, restaurant);
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
    public RestaurantMenu(FeastFastApplication ffa, Restaurant restaurant) {
        this.ffa = ffa;
        currentOrder = new Order();
        currentOrder.setRestaurant(restaurant);
        contentPane = new JPanel();
 
        // Menu bar
        menuBar = new JMenuBar();

        // Home Icon
        homeIcon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
        scaledHomeIcon = homeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledHomeIcon = new ImageIcon(scaledHomeIcon);
        homeMenu = new JButton(newScaledHomeIcon);

        // Person Icon
        personIcon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
        scaledPersonIcon = personIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledPersonIcon = new ImageIcon(scaledPersonIcon);
        userMenu = new JButton(newScaledPersonIcon);
        userMenu.addActionListener(new Listener());

        // Log Out Icon
        logOutIcon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
        scaledLogOutIcon = logOutIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledLogOutIcon = new ImageIcon(scaledLogOutIcon);
        exit = new JButton(newScaledLogOutIcon);

        // Side panel
        sidePanel = new JPanel();

        accountLabel = new JLabel("Account");

        btnUpdateName = new JButton("Update Name");
        btnManageAddress = new JButton("Manage Address");
        btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
        btnViewPastOrders = new JButton("View Past Orders");
        btnViewReviews = new JButton("View Reviews");
        btnManagePassword = new JButton("Manage Password");
        btnUpdatePhoneNumber = new JButton("Update Phone Number");
        btnWriteAReview = new JButton("Write a Review");

        restaurantNameLabel = new JLabel();
        restaurantNameLabel.setText(restaurant.getName());
        
        listModel = new DefaultListModel<>(); // Initialize the DefaultListModel

        // Add restaurants to the list model
        Menu menu = restaurant.getMenu();
        for (MenuItem food : menu.getItems()) {
        	String menuInfo = "<html>Name: " + food.getName() +
                    "<br>Price: " + food.getPrice() +
                    "<br>__________________________________________________________________________________________________________________" + "</html>";
            listModel.addElement(menuInfo);
        }
		
		list = new JList<>(listModel); // Initialize the list
        list.setBounds(77, 81, 612, 487);
        contentPane.add(list);

        ratingLabel = new JLabel("Rating: ");

        ratingValueLabel = new JLabel("Rating placeholder");

        btnViewCart = new JButton("View Cart");

        btnBackToView = new JButton("Back to View Restaurants");

        menuLabel = new JLabel("Menu");

        lblRestaurant = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, contentPane);
        setContentPane(splitPane); // Set the content pane to the split pane
        contentPane.setLayout(null);
        splitPane.setDividerLocation(0); // Set initial divider location
        
        setBounds(100, 100, 800, 700);
        
        setJMenuBar(menuBar);

        menuBar.add(homeMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(userMenu);
        menuBar.add(exit);
               
        contentPane.setBackground(new Color(250, 128, 114));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        
        sidePanel.setBounds(518, 0, 282, 609);
        //contentPane.add(sidePanel);
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

        restaurantNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        restaurantNameLabel.setBounds(174, 21, 423, 48);
        contentPane.add(restaurantNameLabel);

        ratingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        ratingLabel.setBounds(534, 69, 96, 32);
        contentPane.add(ratingLabel);

        ratingValueLabel.setBounds(612, 80, 140, 16);
        contentPane.add(ratingValueLabel);

        btnViewCart.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnViewCart.setBounds(503, 525, 206, 52);
        contentPane.add(btnViewCart);
        

        btnBackToView.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnBackToView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBackToView.setBounds(131, 525, 304, 52);
        contentPane.add(btnBackToView);

        menuLabel.setFont(new Font("Bangla MN", Font.PLAIN, 30));
        menuLabel.setBounds(94, 92, 104, 56);
        contentPane.add(menuLabel);

        list.setBounds(87, 146, 614, 351);
        contentPane.add(list);

        btnViewCart.setText("View Cart");
        btnViewCart.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnViewCart.addActionListener(new Listener());

        btnBackToView.setText("Back to View Restaurants");
        btnBackToView.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

        restaurantNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        restaurantNameLabel.setBounds(218, 20, 423, 48);
        contentPane.add(restaurantNameLabel);

        ratingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        ratingLabel.setBounds(534, 69, 96, 32);
        contentPane.add(ratingLabel);

        ratingValueLabel.setBounds(612, 80, 140, 16);
        contentPane.add(ratingValueLabel);

    
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex != -1) {
                        // Get the selected menu item
                        MenuItem selectedMenuItem = restaurant.getMenu().getItems().get(selectedIndex);

                        // Prompt the user for quantity (you can customize this part)
                        String quantityString = JOptionPane.showInputDialog(
                                RestaurantMenu.this,
                                "Enter quantity for " + selectedMenuItem.getName() + ":",
                                "Quantity",
                                JOptionPane.QUESTION_MESSAGE
                        );

                        try {
                            // Parse the quantity as an integer
                            int quantity = Integer.parseInt(quantityString);

                            // Add the selected menu item to the currentOrder with the specified quantity
                            currentOrder.addItem(selectedMenuItem, quantity);

                            // Display a popup message
                            JOptionPane.showMessageDialog(
                                    RestaurantMenu.this, // Use 'RestaurantMenu.this' as the parent component
                                    quantity + " " + selectedMenuItem.getName() + "(s) have been added to your cart",
                                    "Item Added",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        } catch (NumberFormatException ex) {
                            // Handle the case where the quantity is not a valid number
                            JOptionPane.showMessageDialog(
                                    RestaurantMenu.this,
                                    "Invalid quantity. Please enter a valid number.",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                }
            }
        });

    }
	// Event listener
		private class Listener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
	            JButton source = (JButton) e.getSource();
	            	
	            // PersonIcon button
	            if (source.equals(userMenu)) {
	            	handleUserMenu();
	            }
	            // HomeIcon button
	            else if (source.equals(btnViewCart)) {
	                handleViewCart();
	            }
	            // HomeIcon button
	            else if (source.equals(homeMenu)) {
	                handleHomeIcon();
	            } 
	            else if (source.equals(exit)) {
	                handleLogOut();
	            }
	            // Update Name button
	            else if (source.equals(btnUpdateName)) {
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
			
			private void handleViewCart() {
			    if (currentOrder != null) {
			        // Get the items and total price from the order
			        HashMap<MenuItem, Integer> orderItems = currentOrder.getItems();
			        double totalPrice = currentOrder.getTotalPrice();

			        // Create a StringBuilder to build the message
			        StringBuilder messageBuilder = new StringBuilder("Items in Your Cart:\n");

			        // Append each item to the message
			        for (Map.Entry<MenuItem, Integer> entry : orderItems.entrySet()) {
			            MenuItem item = entry.getKey();
			            int quantity = entry.getValue();
			            messageBuilder.append(quantity).append(" x ").append(item.getName()).append("\n");
			        }

			        // Append the total price to the message
			        messageBuilder.append("\nTotal Price: $").append(totalPrice);

			        // Display the message in a dialog
			        JOptionPane.showMessageDialog(
			                RestaurantMenu.this, // Use 'RestaurantMenu.this' as the parent component
			                messageBuilder.toString(),
			                "Your Cart",
			                JOptionPane.INFORMATION_MESSAGE
			        );
			    } else {
			        // If the order is not placed, show a message
			        JOptionPane.showMessageDialog(
			                RestaurantMenu.this, // Use 'RestaurantMenu.this' as the parent component
			                "Your cart is empty.",
			                "Empty Cart",
			                JOptionPane.INFORMATION_MESSAGE
			        );
			    }
			}


			

	        private void handleHomeIcon() {
	            // Implement your logic here
	        }

	        private void handleLogOut() {
	            // Implement your logic here
	        }

	        private void handleUpdateName() {
	            // Implement your logic here
	        }

	        private void handleManageAddress() {
	            // Implement your logic here
	        }

	        private void handleManagePreferredPayment() {
	            // Implement your logic here
	        }

	        private void handleViewPastOrders() {
	            // Implement your logic here
	        }

	        private void handleViewReviews() {
	            // Implement your logic here
	        }

	        private void handleManagePassword() {
	            // Implement your logic here
	        }

	        private void handleUpdatePhoneNumber() {
	            // Implement your logic here
	        }

	        private void handleWriteReview() {
	            // Implement your logic here
	        }
	    }
}
