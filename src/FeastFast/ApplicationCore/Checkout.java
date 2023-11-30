package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Checkout extends JFrame {

	private JPanel contentPane;

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
	 * Create the frame.
	 */
	public Checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		
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
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(518, 0, 282, 609);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Account");
		lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel1.setBounds(16, 6, 116, 40);
		panel.add(lblNewLabel1);
		
		JButton btnNewButton1 = new JButton("Update Name");
		btnNewButton1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton1.setBounds(16, 59, 260, 48);
		panel.add(btnNewButton1);
		
		JButton btnManageAddress = new JButton("Manage Address");
		btnManageAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnManageAddress.setBounds(16, 275, 260, 48);
		panel.add(btnManageAddress);
		
		JButton btnManagePreferredPayment = new JButton("Manage Preferred Payment Method");
		btnManagePreferredPayment.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btnManagePreferredPayment.setBounds(16, 346, 260, 48);
		panel.add(btnManagePreferredPayment);
		
		JButton btnViewPastOrders = new JButton("View Past Orders");
		btnViewPastOrders.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnViewPastOrders.setBounds(16, 406, 260, 48);
		panel.add(btnViewPastOrders);
		
		JButton btnViewReviews = new JButton("View Reviews");
		btnViewReviews.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnViewReviews.setBounds(16, 544, 260, 48);
		panel.add(btnViewReviews);
		
		JButton btnManagePassword = new JButton("Manage Password");
		btnManagePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnManagePassword.setBounds(16, 204, 260, 48);
		panel.add(btnManagePassword);
		
		JButton btnUpdatePhoneNumber = new JButton("Update Phone Number");
		btnUpdatePhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUpdatePhoneNumber.setBounds(16, 134, 260, 48);
		panel.add(btnUpdatePhoneNumber);
		
		JButton btnWriteAReview = new JButton("Write a Review");
		btnWriteAReview.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnWriteAReview.setBounds(16, 473, 260, 48);
		panel.add(btnWriteAReview);

		JLabel lblNewLabel = new JLabel("Pickup or Home Delivery?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 103, 227, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblChoosePaymentMethod = new JLabel("Choose payment method:");
		lblChoosePaymentMethod.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblChoosePaymentMethod.setBounds(50, 183, 248, 26);
		contentPane.add(lblChoosePaymentMethod);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(370, 181, 164, 37);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Checkout\n");
		lblNewLabel_1.setBounds(307, 21, 227, 43);
		lblNewLabel_1.setFont(new Font("Bangla MN", Font.PLAIN, 35));
		contentPane.add(lblNewLabel_1);
		
		ImageIcon icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		Image scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		ImageIcon newScaledIcon4 = new ImageIcon(scaledIcon4);
		JButton btnNewButton = new JButton(newScaledIcon4);
		btnNewButton.setText("Back");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(76, 513, 132, 54);
		contentPane.add(btnNewButton);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnContinue.setBounds(445, 514, 132, 54);
		contentPane.add(btnContinue);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pickup");
		rdbtnNewRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(295, 101, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHomeDelivery = new JRadioButton("Home delivery");
		rdbtnHomeDelivery.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		rdbtnHomeDelivery.setBounds(438, 101, 164, 23);
		contentPane.add(rdbtnHomeDelivery);
	}
}
