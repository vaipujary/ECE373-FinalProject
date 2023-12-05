package FeastFast.ApplicationCore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import FeastFast.RestaurantManagement.MenuItem;
import FeastFast.UserManagement.Customer;
import FeastFast.UserManagement.Restaurant;

import FeastFast.UserManagement.Restaurant;
import javax.swing.ListSelectionModel;

public class ViewRestaurants extends JFrame {
	//Variables
		private FeastFastApplication ffa;
		private Customer loggedInCustomer;
		
		//Image Icons
		ImageIcon homeIcon;
	    ImageIcon logOutIcon;
	    ImageIcon personIcon;
	    ImageIcon newScaledHomeIcon;
	    ImageIcon newScaledLogOutIcon;
	    ImageIcon newScaledPersonIcon;

		
		//Images
		Image scaledHomeIcon;
	    Image scaledLogOutIcon;
	    Image scaledPersonIcon;

	    
	    //Side Panel Buttons
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
		
	    //Class Specific Buttons
	    
	    //Labels
	    JLabel lblAccount;
	    JLabel lblRestaurants;
	    
	    //Menu Components
	    JMenuBar menuBar;
	    JPanel sidePanel;
	    JPanel contentPane;
	    JSplitPane splitPane;
	    
	    //List Components
	    JList<String> list;
	    DefaultListModel<String> listModel;
	    
	    // Scroll Pane
	    JScrollPane scrollPane;
	    private JLabel customerNameLabel;

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
     * Create the frame.
     */
    public ViewRestaurants(FeastFastApplication ffa) {
    	this.ffa = ffa;
    	loggedInCustomer = ffa.getLoggedInCustomer();
        
        setBounds(100, 100, 800, 700);
        
        //ICONS
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
        
        // Content pane
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 128, 114));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        
        //Side panel
        sidePanel = new JPanel();
        sidePanel.setBounds(518, 0, 282, 609);
		sidePanel.setLayout(null);
        
        // Split Pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, contentPane); // SplitPane
        setContentPane(splitPane); // Set the content pane to the split pane     
        splitPane.setDividerLocation(0); // Set initial divider location
        
        // Menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        customerNameLabel = new JLabel();
        customerNameLabel.setText("Hi, " + loggedInCustomer.getName() + "!");
        customerNameLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 30));
        
        menuBar.add(customerNameLabel);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(btnUserMenu);
        menuBar.add(btnExit);
       
        //Side Panel Buttons
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
		
        //Side Panel Labels
        lblAccount = new JLabel("Account");
        lblAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblAccount.setBounds(16, 6, 116, 40);
		sidePanel.add(lblAccount);	

        //Content Pane Labels
        lblRestaurants = new JLabel("View Restaurants");
        lblRestaurants.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblRestaurants.setBounds(242, 6, 305, 63);
		contentPane.add(lblRestaurants);

		//CLASS SPECIFIC CODE:
		//List code
		listModel = new DefaultListModel<>(); // Initialize the DefaultListModel
        // Add restaurants to the list model
        List<Restaurant> restaurants = ffa.getRestaurants();
        for (Restaurant restaurant : restaurants) {
        	String restaurantInfo = "<html>Name: " + restaurant.getName() + 
                    "<br>__________________________________________________________________________________________________________________" + "</html>";
            listModel.addElement(restaurantInfo);
        }
		
		list = new JList<>(listModel); // Initialize the list
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(131, 119, 490, 468);
        scrollPane.setViewportView(list);
        contentPane.add(scrollPane);
        
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex != -1) {
                        // Get the selected restaurant
                        Restaurant selectedRestaurant = restaurants.get(selectedIndex);

                        // Open the RestaurantMenu window with the selected restaurant
                        openRestaurantMenu(selectedRestaurant);
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
            else if (source.equals(btnExit)) {
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

    private void openRestaurantMenu(Restaurant restaurant) {
        // Create a new RestaurantMenu window with the selected restaurant
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RestaurantMenu restaurantMenu = new RestaurantMenu(ffa, restaurant);
                    restaurantMenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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

    private void handleUpdatePhoneNumber() {

    }

    private void handleWriteReview() {

    }
}
