package assignment.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * GUI for Home page. Appears only after successful login
 * @author Chamindu
 *
 */
public class HomeUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HomeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHomeTitle = new JLabel("Mathematics Quiz Game");
		lblHomeTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblHomeTitle.setForeground(new Color(255, 255, 255));
		lblHomeTitle.setBounds(263, 55, 446, 75);
		contentPane.add(lblHomeTitle);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameUI().setVisible(true);
				dispose();
			}
		});
		btnNewGame.setForeground(new Color(255, 255, 255));
		btnNewGame.setBackground(new Color(0, 0, 139));
		btnNewGame.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewGame.setBounds(368, 170, 202, 37);
		contentPane.add(btnNewGame);

		JButton btnContinueGame = new JButton("Continue Game");
		btnContinueGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameUI().setVisible(true);
				dispose();
			}
		});
		btnContinueGame.setForeground(new Color(255, 255, 255));
		btnContinueGame.setBackground(new Color(0, 0, 139));
		btnContinueGame.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnContinueGame.setBounds(368, 228, 202, 37);
		contentPane.add(btnContinueGame);

		JButton btnScoreboard = new JButton("Scoreboard");
		btnScoreboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ScoreboardUI().setVisible(true);
				dispose();
			}
		});
		btnScoreboard.setForeground(new Color(255, 255, 255));
		btnScoreboard.setBackground(new Color(0, 0, 139));
		btnScoreboard.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnScoreboard.setBounds(368, 286, 202, 37);
		contentPane.add(btnScoreboard);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(0, 0, 139));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnExit.setBounds(368, 344, 202, 37);
		contentPane.add(btnExit);

		JLabel lblHomeBg = new JLabel("");
		// https://youtu.be/tFwp589MAFk
		// Adding an image using label
		Image img = new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		lblHomeBg.setIcon(new ImageIcon(img));
		lblHomeBg.setBounds(0, 0, 964, 513);
		contentPane.add(lblHomeBg);
	}
}
