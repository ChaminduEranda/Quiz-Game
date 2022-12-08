package assignment.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * GUI for Sign in interface
 * @author Chamindu
 *
 */
public class SignInUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUname = new JTextField("");
	private JPasswordField pwPassword;
	private JButton btnSignIn = new JButton("Sign in");

	/**
	 * Create the frame.
	 */
	public SignInUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign In");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(397, 77, 203, 58);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(282, 178, 126, 29);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(282, 239, 126, 29);
		contentPane.add(lblNewLabel_1_1);

		txtUname.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtUname.setBounds(411, 172, 224, 35);
		contentPane.add(txtUname);
		txtUname.setColumns(10);

		JButton btnRegisterUI = new JButton("New user? Register");
		btnRegisterUI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegisterUI.setBackground(new Color(100, 149, 237));
		btnRegisterUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterUI().setVisible(true);
				dispose();
			}
		});
		btnRegisterUI.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnRegisterUI.setBounds(282, 393, 234, 35);
		contentPane.add(btnRegisterUI);

		btnSignIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignIn.setBackground(new Color(100, 149, 237));
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnSignIn.setBounds(490, 307, 145, 35);
		contentPane.add(btnSignIn);

		pwPassword = new JPasswordField();
		pwPassword.setBounds(411, 231, 224, 35);
		contentPane.add(pwPassword);

		JLabel lblNewLabel_2 = new JLabel("");
		Image imgBg = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(imgBg));
		lblNewLabel_2.setBounds(0, 0, 255, 513);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setIcon(new ImageIcon(imgBg));
		lblNewLabel_2_1.setBounds(671, 0, 293, 513);
		contentPane.add(lblNewLabel_2_1);

	}

	/**
	 * @return the txtUname
	 */
	public String getTxtUname() {
		return txtUname.getText();
	}

	/**
	 * @return the pwPassword
	 */
	public String getPwPassword() {
		return String.valueOf(pwPassword.getPassword());
	}

	/**
	 * set empty string for password
	 */
	public void setPwPassword() {
		pwPassword.setText("");
	}

	// Button listener event for btnSignIn
	public void addSignInListener(ActionListener listenForSignInButton) {
		btnSignIn.addActionListener(listenForSignInButton);
	}

}
