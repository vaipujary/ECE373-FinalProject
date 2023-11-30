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

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		ImageIcon icon2 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/HomeIcon.png"));
		Image scaledIcon2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon newScaledIcon2 = new ImageIcon(scaledIcon2);
		//menuBar.add(Box.createHorizontalGlue());
		JButton item2 = new JButton(newScaledIcon2);
		menuBar.add(item2);
		
		ImageIcon icon = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/PersonIcon.jpg"));
		Image scaledIcon = icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon newScaledIcon = new ImageIcon(scaledIcon);
		menuBar.add(Box.createHorizontalGlue());
		JButton item = new JButton(newScaledIcon);
		
		menuBar.add(item);
		
		JLabel lblNewLabel = new JLabel("Menu\n");
		lblNewLabel.setFont(new Font("Bangla MN", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 91, 104, 56);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(148, 146, 553, 351);
		contentPane.add(list);
		
		ImageIcon icon3 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/CartIcon.png"));
		Image scaledIcon3 = icon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon newScaledIcon3 = new ImageIcon(scaledIcon3);
		
		
		JButton btnNewButton = new JButton(newScaledIcon3);
		btnNewButton.setText("View Cart");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(503, 525, 206, 52);
		contentPane.add(btnNewButton);
		
		ImageIcon icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		Image scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon newScaledIcon4 = new ImageIcon(scaledIcon4);
		
		JButton btnBackToView = new JButton(newScaledIcon4);
		btnBackToView.setText("Back to View Restaurants");
		btnBackToView.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBackToView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBackToView.setBounds(131, 525, 304, 52);
		contentPane.add(btnBackToView);
		
		// TODO: display restaurant name of the menu the customer is viewing
		JLabel lblNewLabel_1 = new JLabel("- Restaurant Name - ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(218, 20, 423, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rating: ");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(534, 69, 96, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rating placeholder\n");
		lblNewLabel_3.setBounds(612, 80, 140, 16);
		contentPane.add(lblNewLabel_3);
	}
}
