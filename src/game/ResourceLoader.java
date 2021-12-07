/**
 * Students will need to supply their own header comments.
 */
package game;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ResourceLoader
{
	Map<String,BufferedImage> imageMap;
	Map<String, Path> pathMap;
	
	private static ResourceLoader singleInstance; 
	
	public static ResourceLoader getLoader ()
	{
		if (singleInstance == null)	
		    singleInstance = new ResourceLoader();
		
		return singleInstance;
	}
	
    private ResourceLoader ()
    {
    	// Set up anything this resource loader needs.
    	
    	imageMap = new HashMap<String,BufferedImage>();
    	pathMap  = new HashMap<String,Path>();
    }
    
    public Path getPath (String pathName)
    {
    	if (pathMap.containsKey(pathName))
    		return pathMap.get(pathName);
    	
    	ClassLoader myLoader = this.getClass().getClassLoader();
        InputStream pointStream = myLoader.getResourceAsStream(pathName);
        
        Path path = new Path(new Scanner(pointStream));
        pathMap.put(pathName, path);
        return path;
    }
    
    
    public BufferedImage getImage (String imageName)
    {
    	
    	if (imageMap.containsKey(imageName))
    		return imageMap.get(imageName);
    	
    	BufferedImage result;
    	
    	try
    	{
    		System.out.println("Loading " + imageName);
    		
	    	ClassLoader myLoader = this.getClass().getClassLoader();
	        InputStream imageStream = myLoader.getResourceAsStream(imageName);
	        result = javax.imageio.ImageIO.read(imageStream);  // A handy helper method
	        
	        imageMap.put(imageName, result);
	        
	        return result;
    	}
    	catch (Exception e)
        {
            // On error, just print a message and exit.  
            //   (You should make sure the files are in the correct place.)
            
            System.err.println ("Could not load one of the files: " + imageName);
            System.exit(0);  // Bail out.
            return null;  // Never executes
        }    
    	
       
    }
}
