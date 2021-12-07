package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerKnightPlaced implements Animatable
{
	private int x, y;
	
	public TowerKnightPlaced(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void update() 
	{
		
	}

	public void draw(Graphics g) 
	{
		g.drawImage(ResourceLoader.getLoader().getImage("resources/TowerKnight.png"), x, y, 40, 40, null);

	}

	public Point getTowerKnightPos()
	{
		return new Point(x, y);
	}
	
}
