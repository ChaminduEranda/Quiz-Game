package assignment.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import assignment.controller.Main;

/**
 * GUI for player registration
 * @author Chamindu
 *
 */
public class RegisterUI extends JFrame {

	private JPanel contentPane;
	/**
	 * text field for user input name
	 */
	private JTextField txtName = new JTextField("");
	/**
	 * text field for user input username
	 */
	private JTextField txtUsername = new JTextField("");
	/**
	 * text field for user input new password
	 */
	private JPasswordField pwNewPassword;
	/**
	 * text field for user input confirm password
	 */
	private JPasswordField pwConfirmPassword;
	/**
	 * Button for the 'register'
	 */
	private JButton btnRegister = new JButton("Register");

	/**
	 * Create the frame.
	 */
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(376, 55, 246, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(208, 148, 213, 40);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Username :");
		lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(208, 212, 213, 40);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("New Password :");
		lblNewLabel_1_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(208, 274, 213, 40);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Confirm Password :");
		lblNewLabel_1_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1_3.setBounds(208, 336, 213, 40);
		contentPane.add(lblNewLabel_1_3);

		txtName.setBackground(new Color(255, 255, 255));
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtName.setBounds(452, 148, 264, 40);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtUsername.setColumns(10);
		txtUsername.setBounds(452, 212, 264, 40);
		contentPane.add(txtUsername);

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPlayer();
			}
		});
		btnRegister.setBackground(new Color(100, 149, 237));
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnRegister.setBounds(595, 404, 122, 35);
		contentPane.add(btnRegister);
		btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JButton btnGoBack = new JButton("");
		btnGoBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.main(null);
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/icons8-go-back.png")).getImage();
		btnGoBack.setIcon(new ImageIcon(img));
		btnGoBack.setBounds(2, 3, 48, 39);
		contentPane.add(btnGoBack);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.setBackground(new Color(100, 149, 237));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.main(null);
			}
		});
		btnLogIn.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnLogIn.setBounds(208, 404, 122, 35);
		contentPane.add(btnLogIn);

		JLabel lblNewLabel_2 = new JLabel("Already a user?");
		lblNewLabel_2.setForeground(new Color(255, 245, 238));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(208, 449, 164, 35);
		contentPane.add(lblNewLabel_2);

		pwNewPassword = new JPasswordField();
		pwNewPassword.setBackground(new Color(255, 255, 255));
		pwNewPassword.setBounds(452, 274, 264, 40);
		contentPane.add(pwNewPassword);

		pwConfirmPassword = new JPasswordField();
		pwConfirmPassword.setBackground(new Color(255, 255, 255));
		pwConfirmPassword.setBounds(452, 336, 264, 40);
		contentPane.add(pwConfirmPassword);

		JLabel lblNewLabel_3 = new JLabel("");
		Image imgBg = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(imgBg));
		lblNewLabel_3.setBounds(0, 0, 199, 513);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setIcon(new ImageIcon(imgBg));
		lblNewLabel_4.setBounds(731, 0, 233, 513);
		contentPane.add(lblNewLabel_4);
	}

	/**
	 * 
	 */
	public void registerPlayer() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_game?useSSL=false", "root",
					"");

			Statement stm = con.createStatement();

			String query = "insert into player (username, password) values ('" + txtUsername.getText() + "','"
					+ String.valueOf(pwNewPassword.getPassword()) + "');";

			int x = stm.executeUpdate(query);

			if (x == 0) {
				JOptionPane.showMessageDialog(null, "User already exists.. Change username", "Try Again",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Welcome, Successfully registered", "Welcome",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e1) {
			System.out.println(e1);
		}

	}

	/**
	 * @return the txtName user input
	 */
	public String getTxtName() {
		return txtName.getText();
	}

	/**
	 * @return the txtUsername user input
	 */
	public String getTxtUsername() {
		return txtUsername.getText();
	}

	/**
	 * @return the pwNewPassword user input
	 */
	public String getPwNewPassword() {
		return String.valueOf(pwNewPassword.getPassword());
	}

	/**
	 * @return the pwConfirmPassword user input
	 */
	public String getPwConfirmPassword() {
		return String.valueOf(pwConfirmPassword.getPassword());
	}

	/**
	 * @param listenForRegisterButton
	 * Button event listener for 'register' button
	 */
	public void addRegisterListener(ActionListener listenForRegisterButton) {
		btnRegister.addActionListener(listenForRegisterButton);
	}

}
