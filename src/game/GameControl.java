
/**
 * You will eventually need to add header comments to this file.
 */
package game;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;

public class GameControl implements Runnable, ActionListener
{
	GameView view;
	Timer timer;
	
	private GameState state;
	
    public GameControl ()
    {
     // I moved all the code into a function named 'run' below.
    }
    
    
    public void run ()
    {    
     // Build a view.  Note that the view builds it's own frame, etc.  All the work is there.
    
    	state = new GameState();
    	view = new GameView(state);
    	state.addGameObject(new Backdrop("resources/path.jpg"));
    	state.addGameObject(new Menu(state));
    	
    	if(state.getIsGameStarted())
    	{
    		state.addGameObject(new TowerKnightMenu(state, 675, 450));
        	
        	state.addGameObject(new EnemyTrainee(new Point(0, 0), 0, state,
        			"resources/EnemyTrainee.png", 30, 30, 0, 1, -1, 0.0011));
        	
        	state.addGameObject(new EnemyKnight(new Point(0 ,0), 0.3, state,
        			"resources/EnemyKnight.png", 100, 100, 0, 3, -3, 0.0004));
    	}
    	
     // Start the animation loop.
    	timer = new Timer(17, this);
		timer.start();
    }


	
	public void actionPerformed(ActionEvent e) 
	{
		state.updateAll();
		
		state.changeButtonPressed(false);
		
		view.repaint();
	}
}
