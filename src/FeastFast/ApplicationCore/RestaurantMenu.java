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
    // Variables
    private FeastFastApplication ffa;
    private Order currentOrder;

    DefaultListModel<String> listModel;

    // Image Icons
    ImageIcon homeIcon;
    ImageIcon logOutIcon;
    ImageIcon personIcon;
    ImageIcon backIcon;
    ImageIcon newScaledHomeIcon;
    ImageIcon newScaledLogOutIcon;
    ImageIcon newScaledPersonIcon;
    ImageIcon newScaledBackIcon;

    // Images
    Image scaledHomeIcon;
    Image scaledLogOutIcon;
    Image scaledPersonIcon;
    Image scaledBackIcon;

    // Side Panel Buttons
    JButton btnManageAddress;
    JButton btnManagePassword;
    JButton btnManagePreferredPayment;
    JButton btnUpdateName;
    JButton btnUpdatePhoneNumber;
    JButton btnViewPastOrders;
    JButton btnViewReviews;
    JButton btnWriteAReview;
    JButton btnExit;
    JButton btnHome;
    JButton btnUserMenu;

    // Class Specific Buttons
    JButton btnViewCart;
    JButton btnBackToView;

    // Labels
    JLabel lblAccount;
    JLabel lblMenu;
    JLabel lblRating;
    JLabel lblRatingVal;
    JLabel lblRestaurantName;

    // Menu Components
    JMenuBar menuBar;
    JPanel sidePanel;
    JSplitPane splitPane;
    JPanel contentPane;

    // List Components
    JList<String> list;

    /**
     * Launch the application.
     */
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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        // ICONS
        // Home Icon
        homeIcon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
        scaledHomeIcon = homeIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledHomeIcon = new ImageIcon(scaledHomeIcon);
        btnHome = new JButton(newScaledHomeIcon);

        // Person Icon
        personIcon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
        scaledPersonIcon = personIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledPersonIcon = new ImageIcon(scaledPersonIcon);
        btnUserMenu = new JButton(newScaledPersonIcon);
        btnUserMenu.addActionListener(new Listener());

        // Log Out Icon
        logOutIcon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
        scaledLogOutIcon = logOutIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledLogOutIcon = new ImageIcon(scaledLogOutIcon);
        btnExit = new JButton(newScaledLogOutIcon);
        btnExit.addActionListener(new Listener());
        
        
        // Back Icon
		backIcon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		scaledBackIcon = backIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledBackIcon = new ImageIcon(scaledBackIcon);

        // Content pane
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 128, 114));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        // Side panel
        sidePanel = new JPanel();
        sidePanel.setBounds(518, 0, 282, 609);
        sidePanel.setLayout(null);

        // Split Pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, contentPane);
        setContentPane(splitPane); // Set the content pane to the split pane
        splitPane.setDividerLocation(0); // Set initial divider location

        // Menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(btnHome);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(btnUserMenu);
        menuBar.add(btnExit);

        // Side Panel Buttons
        btnUpdateName = new JButton("Update Name");
        btnManageAddress = new JButton("Manage Address");
        btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
        btnViewPastOrders = new JButton("View Past Orders");
        btnViewReviews = new JButton("View Reviews");
        btnManagePassword = new JButton("Manage Password");
        btnUpdatePhoneNumber = new JButton("Update Phone Number");
        btnWriteAReview = new JButton("Write a Review");

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

        // Side Panel Labels
        lblAccount = new JLabel("Account");
        lblAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        lblAccount.setBounds(16, 6, 116, 40);
        sidePanel.add(lblAccount);

        // Content Pane Buttons
        btnViewCart = new JButton("View Cart");
        btnBackToView = new JButton(newScaledBackIcon);
        btnBackToView.setText("Back to View Restaurants");
        btnBackToView.addActionListener(new Listener());
        

        btnViewCart.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnViewCart.setBounds(503, 525, 206, 52);
        contentPane.add(btnViewCart);
        btnViewCart.addActionListener(new Listener());

        btnBackToView.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnBackToView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnBackToView.setBounds(131, 525, 304, 52);
        contentPane.add(btnBackToView);

        // Content Pane Labels
        lblRating = new JLabel("Rating: ");
        lblRatingVal = new JLabel("Rating placeholder");
        lblMenu = new JLabel("Menu");

        lblRating.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblRating.setBounds(534, 69, 96, 32);
        contentPane.add(lblRating);

        lblRatingVal.setBounds(612, 80, 140, 16);
        contentPane.add(lblRatingVal);

        lblMenu.setFont(new Font("Bangla MN", Font.PLAIN, 30));
        lblMenu.setBounds(94, 92, 104, 56);
        contentPane.add(lblMenu);

        // CLASS SPECIFIC CODE:
        // Dynamic restaurant name
        lblRestaurantName = new JLabel();
        lblRestaurantName.setText(restaurant.getName());
        lblRestaurantName.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        lblRestaurantName.setBounds(218, 20, 423, 48);
        contentPane.add(lblRestaurantName);

        // List code
        listModel = new DefaultListModel<>(); // Initialize the DefaultListModel
        // Add menu items to the list model
        Menu menu = restaurant.getMenu();
        for (MenuItem food : menu.getItems()) {
            String menuInfo = "<html>Name: " + food.getName() +
                    "<br>Price: " + food.getPrice() +
                    "<br>__________________________________________________________________________________________________________________"
                    + "</html>";
            listModel.addElement(menuInfo);
        }

        list = new JList<>(listModel); // Initialize the list
        list.setBounds(87, 146, 614, 351);
        contentPane.add(list);

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
                                JOptionPane.QUESTION_MESSAGE);

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
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException ex) {
                            // Handle the case where the quantity is not a valid number
                            JOptionPane.showMessageDialog(
                                    RestaurantMenu.this,
                                    "Invalid quantity. Please enter a valid number.",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
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
            if (source.equals(btnUserMenu)) {
                handleUserMenu();
            }
            // HomeIcon button
            else if (source.equals(btnViewCart)) {
                handleViewCart();
            }
            // HomeIcon button
            else if (source.equals(btnHome)) {
                handleHomeIcon();
            } else if (source.equals(btnExit)) {
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
            // Back to View Restaurants
            else if(source.equals(btnBackToView)) {
            	handleBackToView();
            }

        }

        private void handleBackToView() {
        	ViewRestaurants viewRestaurants = new ViewRestaurants(ffa);
        	viewRestaurants.setVisible(true);
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
                // Create a new ShoppingCart instance and pass the currentOrder
                ShoppingCart shoppingCart = new ShoppingCart(ffa, currentOrder);

                // Set the visibility of the ShoppingCart window
                shoppingCart.setVisible(true);
            } else {
                // If the order is not placed, show a message
                JOptionPane.showMessageDialog(
                        RestaurantMenu.this,
                        "Your cart is empty.",
                        "Empty Cart",
                        JOptionPane.INFORMATION_MESSAGE);
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
