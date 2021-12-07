/**
 * Students will need to supply their own header comments.
 */
package game;

import java.awt.Graphics;

public class Backdrop implements Animatable 
{
	
	private String filename;
	
	public Backdrop(String filename)
	{
		this.filename = filename;
	}

	/**
	 * It is customary to put a contract on every function; however,
	 * students may refer back to the contract in the interface (since
	 * this method was declared there.
	 * 
	 * (Students are responsible for all contracts.)
	 */

	/**
	 * It is customary to put a contract on every function; however,
	 * students may refer back to the contract in the interface (since
	 * this method was declared there.
	 * 
	 * (Students are responsible for all contracts.)
	 */
	public void draw(Graphics g) 
	{
		// Draw the backdrop.
    	
    	g.drawImage(ResourceLoader.getLoader().getImage(filename), 0, 0, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
