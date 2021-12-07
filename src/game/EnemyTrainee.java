package game;

import java.awt.Point;

public class EnemyTrainee extends Enemy
{
	
	public EnemyTrainee(Point enemyPos, double percentage, GameState state, 
			String filename, int enemyHeight, int enemyWidth, int enemySpawnTimeCounter, 
			int enemyHealth, int damage, double percentageIncreased)
	{
		super(enemyPos, percentage, state, filename, enemyHeight, enemyWidth, 
				enemySpawnTimeCounter, enemyHealth, damage, percentageIncreased);
	}

	public void update()
	{
		super.update();
		enemySpawnTimeCounter++;
		if(enemySpawnTimeCounter >= state.getEnemySpawnTime() / 2)
		{
	    	state.addGameObject(new EnemyTrainee(new Point(0, 0), 0.03, state,
	    			"resources/EnemyTrainee.png", 30, 30, 0, 1, -1, 0.0011));
	    	
			state.addGameObject(new EnemyTrainee(new Point(0, 0), 0.01, state,
					"resources/EnemyTrainee.png", 30, 30, 0, 1, -1, 0.0011));
			enemySpawnTimeCounter = 0;
		}
		
		percentage += .0011;
		
		if(percentage > 1)
		{
			percentage = 0;
			state.removeFromList(this);
			state.changeLife(damage);
		}
		
		enemyPos = ResourceLoader.getLoader().getPath("resources/path.txt").getPathPosition(percentage);

		
	}
	
	public void resetPercentage()
	{
		percentage = 0.0011;
	}
}
