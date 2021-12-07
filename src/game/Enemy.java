package game;

import java.awt.Point;
import java.awt.Graphics;

abstract public class Enemy implements Animatable
{

	protected Point enemyPos;
	protected double percentage;
	protected GameState state;
	protected String filename;
	protected int enemyHeight;
	protected int enemyWidth;
	protected int enemySpawnTimeCounter;
	protected int enemyHealth;
	protected int damage;
	protected double percentageIncreased;
	
	public Enemy(Point enemyPos, double percentage, GameState state, 
			String filename, int enemyHeight, int enemyWidth, int spawnTime,
			int enemyHealth, int damage, double percentageIncreased)
	{
		this.enemyPos = enemyPos;
		this.percentage = percentage;
		this.state = state;
		this.filename = filename;
		this.enemyHeight = enemyHeight;
		this.enemyWidth = enemyWidth;
		this.enemyHealth = enemyHealth;
		this.damage = damage;
		this.percentageIncreased = percentageIncreased;
	}
	
	public Point getLocation()
	{
		return enemyPos;
	}
	
	public void update()
	{
		if(state.getLife() <= 0)
		{
			state.changeIsGameOver(true);
		}
		
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(ResourceLoader.getLoader().getImage(filename), 
				enemyPos.x - enemyHeight/2, enemyPos.y - enemyHeight/2, enemyWidth, 
				enemyHeight, null);
		
		if(state.getIsGameOver())
		{
			g.drawImage(ResourceLoader.getLoader().getImage("resources/game_over.png"), 0, 0, null);
		}

	}
}
