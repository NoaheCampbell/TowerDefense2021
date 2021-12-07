package game;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Point;

public class GameState 
{
	private List<Animatable> gameObjects; 
	private List<Animatable> objectsToRemove;
	private List<Animatable> objectsToAdd;
	private boolean gameOver;
	private int score;
	private int life;
	private int mouseX;
	private int mouseY;
	private boolean buttonPressed;
	private int enemySpawnTimer;
	private boolean gameStarted;
	
	public GameState()
	{
		gameObjects = new ArrayList<Animatable>();
		objectsToRemove = new ArrayList<Animatable>();
		objectsToAdd = new ArrayList<Animatable>();
		gameOver = false;
		score = 0;
		life = 1;
		mouseX = 0;
		mouseY = 0;
		buttonPressed = false;
		enemySpawnTimer = 260;
		gameStarted = false;
	}
	
	/**
	 * Draws every object inside of an Array List
	 * 
	 * @param Graphics g
	 */
	public void drawAll(Graphics g)
	{
		for(Animatable a : gameObjects)
			a.draw(g);
	}
	
	/**
	 * Adds an Animatable object to a List that will be added to
	 * the gameObjects ArrayList after the next update
	 * 
	 * @param Animatable a
	 */
	public void addGameObject(Animatable a)
	{
		objectsToAdd.add(a);
	}
	
	/**
	 * Adds an Animatable object to an ArrayList that will be removed 
	 * from the gameObjects ArrayList after the next update
	 * 
	 * @param Animatable a
	 */
	public void removeFromList(Animatable a)
	{
		objectsToRemove.add(a);
	}
	
	/**
	 * As long as the game isn't over, loops through the gameObjects ArrayList
	 * and calls the update method in each object
	 */
	public void updateAll()
	{
		if(!getIsGameOver())
		{
			for(Animatable a : gameObjects)
			{
				a.update();
			}
					
			gameObjects.removeAll(objectsToRemove);
			objectsToRemove.clear();
			
			gameObjects.addAll(objectsToAdd);
			objectsToAdd.clear();
			
		}
	}
	
	/**
	 * Returns the player's score
	 * 
	 * @return int score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Changes the player score
	 * 
	 * @param int amount
	 */
	public void changeScore(int amount)
	{
		score += amount;
	}
	
	/**
	 * Returns the player's life
	 * 
	 * @return int life
	 */
	public int getLife()
	{
		return life;
	}
	
	/**
	 * Changes the player's life
	 * 
	 * @param int amount
	 */
	public void changeLife(int amount)
	{
		life += amount;
	}
	
	/**
	 * Returns the x coordinate of the mouse
	 * 
	 * @return int mouseX
	 */
	public int getMouseX()
	{
		return mouseX;
	}
	
	/**
	 * Returns the y coordinate of the mouse
	 * 
	 * @return int mouseY
	 */
	public int getMouseY()
	{
		return mouseY;
	}
	
	/**
	 * Updates the mouseX and mouseY fields to be the current x and y
	 * coordinates of the mouse
	 * 
	 * @param int newMouseX
	 * @param int newMouseY
	 */
	public void setMouseLocation(int newMouseX, int newMouseY)
	{
		mouseX = newMouseX;
		mouseY = newMouseY;
	}
	
	/**
	 * Returns the count that determines when a new enemy is spawned
	 * 
	 * @return int enemySpawnTimer
	 */
	public int getEnemySpawnTime()
	{
		return enemySpawnTimer;
	}
	
	/**
	 * Changes the enemySpawnTimer field to a new timer(measured in seconds)
	 * based on the parameter sent in
	 * 
	 * @param int seconds
	 */
	public void changeEnemySpawnTime(int seconds)
	{
		enemySpawnTimer = seconds;
	}
	
	/**
	 * Returns whether the mouse is pressed currently or not
	 * 
	 * @return boolean buttonPressed
	 */
	public boolean getIsButtonPressed()
	{
		return buttonPressed;
	}
	
	/**
	 * Changes whether the mouse is pressed or not
	 * @param boolean isClicked
	 */
	public void changeButtonPressed(boolean isClicked)
	{
		buttonPressed = isClicked;
	}
	
	/**
	 * Returns if the game is over or not
	 * 
	 * @return boolean gameOver
	 */
	public boolean getIsGameOver()
	{
		return gameOver;
	}
	
	/**
	 * Changes whether the game is over or not
	 * 
	 * @param boolean newState
	 */
	public void changeIsGameOver(boolean newState)
	{
		gameOver = newState;
	}
	
	/**
	 * Returns whether the game has started or not
	 * 
	 * @return boolean gameStarted
	 */
	public boolean getIsGameStarted()
	{
		return gameStarted;
	}
	
	/**
	 * Changes the gameStarted field 
	 * 
	 * @param boolean newGameStarted
	 */
	public void changeGameStarted(boolean newGameStarted)
	{
		gameStarted = newGameStarted;
	}
	
	public boolean isNear(Point a, Point b)
	{
		if(a.x >= b.x - 5 && a.y >= b.y - 5)
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
	
	
}
