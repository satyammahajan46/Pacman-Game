
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * Class that has main method that run the code
 * @author Satyam Mahajan
 *
 */
public class PacmanTest extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new PacmanTest();

	}
	/**
	 * Constructor to make a JFrame and set required properties to it
	 */
	public PacmanTest() {
		this.setTitle("Pacman Have FUN!!");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new MainPanel());
		this.setMinimumSize(new Dimension(1000,1000));
		this.pack();
		this.setVisible(true);
		
	}

}