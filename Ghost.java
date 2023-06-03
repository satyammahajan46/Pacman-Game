
import java.awt.Point;

import javax.swing.ImageIcon;
/**
 * Ghost class that creates ghost for panel so that ghost can exits on panel
 * @author Satyam Mahajan
 *
 */
public class Ghost {
	private ImageIcon ghost;
	private Point location;
	private String url;
	private int x = 10, y = 5;
	/**
	 * Constructor that initialize initial data
	 */
	public Ghost(){
		location = new Point(500,500);
		url = "./inky.png";
		setGhost(new ImageIcon(url, "Inky ghost"));
	}
	/**
	 * Method that returns ghost ImageIcon object 
	 * @return ghost current ImageIcon of instance ghost
	 */
	
	public ImageIcon getGhost() {
		return ghost;
	}
	/**
	 * Set ghost to New ghost image icon
	 * @param ghost type to set to ghost
	 */
	public void setGhost(ImageIcon ghost) {
		this.ghost = ghost;
	}
	/**
	 * Method that returns point where ghost is right now
	 * @return location current location of ghost
	 *
	 */
	public Point getLocation() {
		return location;
	}
	/**
	 * Method that sets new location for ghost also make sure that ghost remains in bounds
	 * this method just change the instance data;
	 */
	public void setLocation() {
		
		if(location.getX()>=910 || location.getX()<=0) {
			x *= -1;
		}
		if(location.getY()>=910 || location.getY()<=0) {
			y *= -1;
		}
		
		location.x += x;
		location.y += y;
	}
	
	
}
