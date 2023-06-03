import javax.swing.ImageIcon;
/**
 * A pacman class for our pacman that just creates a pacman ImageIcon and initializes it 
 * @author Satyam Mahajan
 *
 */
public class Pacman {
	private ImageIcon pacman;
	/**
	 * constructor to initializes intial data 
	 */
	public Pacman() {
		pacman = new ImageIcon("./pacman.png");
		
	}
	/**
	 * Method to get pacman image icon object
	 * @return pacman instance data of pacman class
	 */
	public ImageIcon getPacman() {
		return pacman;
	}
}
