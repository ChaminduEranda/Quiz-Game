package assignment.model;

import java.awt.image.BufferedImage;

import assignment.controller.GameServer;


/**
 * Main class where the games are coming from.
 *
 */
public class GameEngine {
	String thePlayer = null;

	/**
	 * Each player has their own game engine.
	 * 
	 * @param player
	 */
	public GameEngine(String player) {
		thePlayer = player;
	}

	int counter = 0;
	int score = 0;
	int level = 1;
	GameServer theGames = new GameServer();
	Game current = null;

	/**
	 * Retrieves a game. This basic version only has two games that alternate.
	 */
	public BufferedImage nextGame() {
		current = theGames.getRandomGame();
		return current.getImage();

	}

	/**
	 * Checks if the parameter i is a solution to the game URL. If so, score is
	 * increased by ten.
	 * 
	 * @param game
	 * @param i
	 * @return
	 */
	public boolean checkSolution( int i) {
		if (i == current.getSolution()) {
			//For every correct answer in the quiz add 10 to score
			score = score + 10;
			level = level + 1;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retrieves the score.
	 * 
	 * @param player
	 * @return
	 */
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}

}