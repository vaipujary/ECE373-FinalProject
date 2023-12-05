package FeastFast.ApplicationCore;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import FeastFast.UserManagement.Restaurant;
import javax.swing.ListSelectionModel;

public class ViewRestaurants extends JFrame {

    private FeastFastApplication ffa;

    // Content pane
    private JPanel contentPane;
    private DefaultListModel<String> listRestaurantModel;

    // Menu bar
    JMenuBar menuBar;

    // Icons
    // Home Icon
    ImageIcon icon2;
    Image scaledIcon2;
    ImageIcon newScaledIcon2;
    JButton homeMenu;

    // Person Icon
    ImageIcon icon;
    Image scaledIcon;
    ImageIcon newScaledIcon;
    JButton userMenu;

    // Log Out Icon
    ImageIcon icon3;
    Image scaledIcon3;
    ImageIcon newScaledIcon3;
    JButton exit;

    // Side panel
    JPanel sidePanel;

    // Side panel content
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

    // Title
    JLabel viewRestaurantsLabel;

    JSplitPane splitPane; // Added JSplitPane

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FeastFastApplication ffa = new FeastFastApplication();
                    ViewRestaurants frame = new ViewRestaurants(ffa);
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
    public ViewRestaurants(FeastFastApplication ffa) {
        this.ffa = ffa;
        // Content pane
        contentPane = new JPanel();

        // Menu bar
        menuBar = new JMenuBar();

        listRestaurantModel = new DefaultListModel<String>();
        for(Restaurant restaurant: ffa.getRestaurants()) {
        	listRestaurantModel.addElement(restaurant.getName());
        }
        //ffa.getRestaurants().setModel(listRestaurantModel);
        
        // Icons
        // Home Icon
//        icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
//        scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
//        newScaledIcon2 = new ImageIcon(scaledIcon2);
//        homeMenu = new JButton(newScaledIcon2);

        // User Icon
        icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
        scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledIcon = new ImageIcon(scaledIcon);

        // Log Out Icon
        icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/LogOutIcon.png"));
        scaledIcon3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        newScaledIcon3 = new ImageIcon(scaledIcon3);
        exit = new JButton(newScaledIcon3);

        userMenu = new JButton(newScaledIcon);
        userMenu.addActionListener(new Listener());

        // Side panel
        sidePanel = new JPanel();

        // Side panel content
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
        
        // Side panel button listeners
        btnUpdateName.addActionListener(new Listener());
        btnManageAddress.addActionListener(new Listener());
        btnManagePreferredPayment.addActionListener(new Listener()); 
        btnViewPastOrders.addActionListener(new Listener()); 
        btnViewReviews.addActionListener(new Listener()); 
        btnManagePassword.addActionListener(new Listener());  
        btnUpdatePhoneNumber.addActionListener(new Listener());  
        btnWriteAReview.addActionListener(new Listener());  

        // Title
        viewRestaurantsLabel = new JLabel("View Restaurants");

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, contentPane); // SplitPane
        setContentPane(splitPane); // Set the content pane to the split pane
        splitPane.setDividerLocation(0); // Set initial divider location

        setBounds(100, 100, 800, 700);

        setJMenuBar(menuBar);

        //menuBar.add(homeMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(userMenu);
        menuBar.add(exit);

        contentPane.setBackground(new Color(250, 128, 114));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Rest of your code...
		
		
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
		contentPane.setLayout(null);

		viewRestaurantsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		viewRestaurantsLabel.setBounds(254, 10, 289, 42);
		contentPane.add(viewRestaurantsLabel);
		
		JList<String> list = new JList<String>(listRestaurantModel);
		list.setBounds(185, 68, 431, 506);
		contentPane.add(list);
    }

    // Event listener
    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

            // PersonIcon button
            if (source.equals(userMenu)) {
                handleUserMenu();
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

