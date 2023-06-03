import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
/**
 * A pellet class which has pellet object that can be eaten by pacman 
 * @author smahajan02
 *
 */
public class Pellet {
	private ImageIcon pellet;
	private int xlocation, ylocation;
	/**
	 * Constructor that initializes the instance data
	 */
	public Pellet() {
		setXlocation((int) (Math.random()*950));
		setYlocation((int) (Math.random()*950));
		pellet= new ImageIcon("./pellet.png");
	}
	/**
	 * Method that returns pellet object
	 * @return pellet, ImageIcon object that is returned
	 */
	public ImageIcon getPellet() {
		return pellet;
	}
	/**
	 * Method that set the pellet in random location
	 * @param pellet, ImageIcon object to be set at the location
	 */
	public void setPellet(ImageIcon pellet) {
		setXlocation((int) (Math.random()*950));
		setYlocation((int) (Math.random()*950));
		this.pellet = pellet;
	}
	/**
	 * Method that gets X coordinate location
	 * @return xLocation, current X location of ImageIcon
	 */
	public int getXlocation() {
		return xlocation;
	}
	/**
	 * 
	 * Method that set X coordinate of ImageIcon object 
	 * @param xlocation, X coordinate to be set 
	 */
	public void setXlocation(int xlocation) {
		this.xlocation = xlocation;
	}
	/**
	 * Method that gets Y coordinate location
	 * @return yLocation, current Y location of ImageIcon
	 */
	public int getYlocation() {
		return ylocation;
	}
	/**
	 * 
	 * Method that set Y coordinate of ImageIcon object 
	 * @param ylocation, Y coordinate to be set 
	 */
	public void setYlocation(int ylocation) {
		this.ylocation = ylocation;
	}

	
	
}
