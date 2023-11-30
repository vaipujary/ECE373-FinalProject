package FeastFast.ApplicationCore;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;

public class Receipt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt();
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
	public Receipt() {
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
		
		JLabel lblNewLabel = new JLabel("Order Summary");
		lblNewLabel.setFont(new Font("Bangla MN", Font.PLAIN, 35));
		lblNewLabel.setBounds(51, 6, 322, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lblItems = new JLabel("Items: ");
		lblItems.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblItems.setBounds(51, 87, 595, 37);
		contentPane.add(lblItems);
		
		JList list = new JList();
		list.setBounds(51, 118, 595, 243);
		contentPane.add(list);
	}

}
