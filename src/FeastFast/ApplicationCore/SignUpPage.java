package FeastFast.ApplicationCore;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class SignUpPage extends JFrame {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblPassword;
	JButton btnNewButton;
	JLabel lblNewLabel_1;
	private JLabel lblName;
	private JTextField textField_1;
	private JLabel lblUserType;
	ImageIcon icon4;
	Image scaledIcon4;
	ImageIcon newScaledIcon4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(75, 234, 129, 16);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(367, 296, 129, 40);
		contentPane.add(passwordField);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword.setBounds(75, 307, 117, 16);
		contentPane.add(lblPassword);
		
		btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(317, 392, 117, 56);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(366, 224, 130, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.setFont(new Font("Bangla MN", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(232, 25, 150, 40);
		contentPane.add(lblNewLabel_1);
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblName.setBounds(75, 166, 91, 16);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(366, 158, 130, 39);
		contentPane.add(textField_1);
		
		lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUserType.setBounds(75, 94, 129, 25);
		contentPane.add(lblUserType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(367, 92, 129, 27);
		contentPane.add(comboBox);
		
		icon4 = new ImageIcon(Checkout.class.getResource("/FeastFast/ApplicationCore/BackIcon.png"));
		scaledIcon4 = icon4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		newScaledIcon4 = new ImageIcon(scaledIcon4);
		
		JButton btnBack = new JButton(newScaledIcon4);
		btnBack.setText("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnBack.setBounds(135, 392, 129, 56);
		contentPane.add(btnBack);
		setBounds(100, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
