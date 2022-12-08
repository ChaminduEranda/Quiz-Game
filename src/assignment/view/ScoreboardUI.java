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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * GUI for displaying score the scoreboard
 * @author Chamindu
 *
 */
public class ScoreboardUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ScoreboardUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblScoreboardTitle = new JLabel("Scoreboard");
		lblScoreboardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreboardTitle.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblScoreboardTitle.setBounds(382, 61, 189, 74);
		contentPane.add(lblScoreboardTitle);

		JButton btnGoBack = new JButton("");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomeUI().setVisible(true);
				dispose();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/icons8-go-back.png")).getImage();
		btnGoBack.setIcon(new ImageIcon(img));
		btnGoBack.setBounds(2, 3, 48, 39);
		contentPane.add(btnGoBack);
	}
}
