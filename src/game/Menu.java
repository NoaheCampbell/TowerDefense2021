package game;

import java.awt.Graphics;
import java.awt.Color;

public class Menu implements Animatable
{
	private GameState state;
	
	public Menu(GameState state)
	{
		this.state = state;
	}

	public void update()
	{
		
	}

	public void draw(Graphics g)
	{
		g.setColor(new Color(0.9f, 0.8f, 0.7f));
		g.fillRect(600, 0, 300, 600);
				
		g.setColor(Color.BLACK);
		g.drawString("Live(s) left: " + state.getLife(), 650, 300);
		
		g.drawString("Score: " + state.getScore(), 675, 400);
	}

}
