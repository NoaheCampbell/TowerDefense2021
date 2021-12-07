package game;

import java.awt.Graphics;

public class TowerKnightMoving implements Animatable
{
	private GameState state;
	
	public TowerKnightMoving(GameState state)
	{
		this.state = state;
	}
	
	public void update() 
	{
		if(state.getIsButtonPressed())
		{
			state.addGameObject(new TowerKnightPlaced(state.getMouseX() - 19, state.getMouseY() - 19));
			state.removeFromList(this);
		}
	}

	public void draw(Graphics g) 
	{
		g.drawImage(ResourceLoader.getLoader().getImage("resources/TowerKnight.png"), state.getMouseX() - 20,
				state.getMouseY() - 20, 40, 40, null);

	}

}
