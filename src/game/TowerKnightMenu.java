package game;

import java.awt.Graphics;

public class TowerKnightMenu implements Animatable
{
	private GameState state;
	private int x, y;
	
	public TowerKnightMenu(GameState state, int x, int y)
	{
		this.state = state;
		this.x = x;
		this.y = y;
	}
	
	public void update() 
	{
		if(state.getMouseX() >= x && state.getMouseX() < x + 40 &&
		   state.getMouseY() >= y && state.getMouseY() < y + 40 &&
		   state.getIsButtonPressed())
		{
			state.addGameObject(new TowerKnightMoving(state));
		}
	}

	public void draw(Graphics g) 
	{
		g.drawImage(ResourceLoader.getLoader().getImage("resources/TowerKnight.png"), x, y, 40, 40, null);

	}

}
