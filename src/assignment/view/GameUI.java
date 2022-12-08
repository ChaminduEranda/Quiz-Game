package assignment.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

import assignment.model.GameEngine;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.FlowLayout;

/**
 * A Simple Graphical User Interface for the Six Equation Game.
 * 
 * @author Marc Conrad
 *
 */
public class GameUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -107785653906635L;
	
	/**
	 * Method that is called when a button has been pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand());
		boolean correct = myGame.checkSolution(solution);
		int score = myGame.getScore(); 
		int level = myGame.getLevel();
		if (correct) {
			System.out.println("Correct solution entered!");
			currentGame = myGame.nextGame(); 			
			ImageIcon ii = new ImageIcon(currentGame);
			questArea.setIcon(ii);
			infoArea.setText("Good!  Score: "+score);
			//Label to show the score
			lblScore.setText("Score: "+score);
			//Label to show the level
			lblLevel.setText("Level: "+level);
			//Reset timer for 1 minute
			stopTimer();
			countDownTimer();
			timer.start();
			
		} else { 
			System.out.println("Not Correct");
			infoArea.setText("Oops. Try again!  Score: "+score);
		}
	}

	JLabel lblScore = new JLabel("Score: 0");
	JLabel lblLevel = new JLabel("Level: 1");
	JLabel lblTime = new JLabel("Time");
	JLabel questArea = null;
	GameEngine myGame = null;
	BufferedImage currentGame = null;
	JTextArea infoArea = null;
	//For timer
	Timer timer;
	int second = 0;
	int minute = 1;
	String ddSecond, ddMinute;
	DecimalFormat dFormat = new DecimalFormat("00");
	
	
	
/**
 * Initializes the game. 
 * @param player
 */
	private void initGame(String player) {
		setSize(701, 557);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(0, 57, 676, 463);
		panel.setBackground(new Color(0, 0, 139));

		myGame = new GameEngine(player);
		currentGame = myGame.nextGame();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		infoArea = new JTextArea(1, 40);
		
		infoArea.setEditable(false);
		infoArea.setText("What is the missing value?   Score: 0");
		
		JScrollPane infoPane = new JScrollPane(infoArea);
		panel.add(infoPane);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
		JScrollPane questPane = new JScrollPane(questArea);
		panel.add(questPane);

		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
		}
		getContentPane().setLayout(null);

		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(0, 0, 676, 60);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel.repaint();
		
		JButton btnGoBack = new JButton("");
		btnGoBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				timer.stop();
				new HomeUI().setVisible(true);
			}
		});
		Image img= new ImageIcon(this.getClass().getResource("/icons8-go-back.png")).getImage();
		btnGoBack.setIcon(new ImageIcon(img));
		btnGoBack.setBounds(2, 3, 48, 39);
		panel_1.add(btnGoBack);
		
		lblLevel.setForeground(new Color(255, 255, 255));
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblLevel.setBounds(117, 10, 116, 32);
		panel_1.add(lblLevel);
		
		lblTime.setText("01:00");
		lblTime.setForeground(new Color(255, 255, 255));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblTime.setBounds(279, 10, 116, 32);
		panel_1.add(lblTime);
		
		lblScore.setForeground(new Color(255, 255, 255));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblScore.setBounds(474, 10, 116, 32);
		panel_1.add(lblScore);
		
	}
/**
 * Default player is null. 
 */
	public GameUI() {
		super();
		initGame(null);
		countDownTimer();
		timer.start();
	}

	/**
	 * Use this to start GUI, e.g., after login.
	 * 
	 * @param player
	 */
	public GameUI(String player) {
		super();
		initGame(player);
		
	}

	/**
	 * https://www.ryisnow.online/2021/04/java-beginner-code-sample-create-timer.html
	 * This function was developed further with the help from above referenced code.
	 * CountDown timer element used in the GameUI
	 */
	public void countDownTimer() {
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				lblTime.setText(ddMinute+ ":" +ddSecond);
				
				if(second == -1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					lblTime.setText(ddMinute+ ":" +ddSecond);
				}
				if(minute == 0 && second == 0) {
					timer.stop();
					JOptionPane.showMessageDialog(null, "Time's up! \n Try again", "Oops!" , JOptionPane.PLAIN_MESSAGE);
					new HomeUI().setVisible(true);
					dispose();
					
				}
			}
		});
	}
	
	/**
	 * Used to stop the timer and reset values for second and minute
	 */
	public void stopTimer() {
		timer.stop();
		second = 0;
		minute = 1;
		lblTime.setText("01:00");
	}
	
}