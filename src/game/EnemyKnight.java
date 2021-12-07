package game;

import java.awt.Point;

public class EnemyKnight extends Enemy
{
	public EnemyKnight(Point enemyPos, double percentage, GameState state, 
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
		if(enemySpawnTimeCounter >= state.getEnemySpawnTime())
		{
		  	state.addGameObject(new EnemyKnight(new Point(0 ,0), 0.02, state, 
		  			"resources/EnemyKnight.png", 100, 100, 0, 3, -3, 0.0004));
		   	enemySpawnTimeCounter = 0;
		}
		
		percentage += percentageIncreased;
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
		percentage = 0.0004;
	}

}
