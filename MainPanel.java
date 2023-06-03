import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Class That is main panel on which all stuff is drawn
 * all the action listener is also in it
 * @author smahajan02
 *
 */
public class MainPanel extends JPanel {
	//Required instance data
	private Ghost ghost;
	private Pellet pellet;
	private Timer t;
	private ImageIcon ghostUrl;
	private MoveGhost move;
	private Pacman pacman;
	private Point mousePoint;
	private boolean isGhostEatable, isTiming;
	private int time;
	/**
	 * Constructor that initializes instance data
	 */
	public MainPanel() {
		//setting panel properties
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(1000, 1000));
		//instance data initialization
		ghost = new Ghost();
		pellet = new Pellet();
		move = new MoveGhost();
		pacman = new Pacman();
		mousePoint = null;
		isTiming = false;
		time = 0;
		ghostUrl = new ImageIcon("./inky.png");
		isGhostEatable = false;
		//initializing and starting timer
		t = new Timer(50, move);
		t.start();
		//Adding mouse and key listener
		addMouseMotionListener(move);
		addKeyListener(move);
		setFocusable(true);

	}
	/**
	 * Method that paint component on the main panel
	 * @param g, graphics required object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ghost.getGhost().paintIcon(this, g, ghost.getLocation().x, ghost.getLocation().y);
		if (pellet != null && pellet.getPellet() != null) {
			pellet.getPellet().paintIcon(this, g, pellet.getXlocation(), pellet.getYlocation());
		}
		int width = pacman.getPacman().getIconWidth() / 2;
		int height = pacman.getPacman().getIconHeight() / 2;
		if (mousePoint != null) {
			pacman.getPacman().paintIcon(this, g, mousePoint.x - width, mousePoint.y - height);
		}
	}
	/**
	 * Class that has all action listener and Mouse listener 
	 * @author smahajan02
	 *
	 */
	private class MoveGhost extends KeyAdapter implements ActionListener, MouseMotionListener {
		/**
		 * Method that runs when mouse is moved
		 * and stores new point
		 */
		public void mouseMoved(MouseEvent e) {
			mousePoint = new Point(e.getX(), e.getY());
		}
		/**
		 * Method that runs when mouse is dragged
		 * and stores new point
		 */
		public void mouseDragged(MouseEvent e) {
			mouseMoved(e);
		}
		/**
		 * Method that runs when a action is performed
		 */
		public void actionPerformed(ActionEvent e) {
			ghost.setLocation();
			if (isTiming) {
				time += 50;
			}
			if (isPelletCollision()) {
				pellet.setPellet(null);
				ghostUrl = new ImageIcon("./blue.png");
				ghost.setGhost(ghostUrl);
				isGhostEatable = true;
				isTiming = true;
				time = 0;
			}
			if (isGhostCollision()) {
				if (isGhostEatable) {
					t.stop();
					JOptionPane.showMessageDialog(null, "You Won!");
				} else {
					t.stop();
					JOptionPane.showMessageDialog(null, "You Lose!");
				}
			}
			if (time > 5000) {
				pellet.setPellet(new ImageIcon("./pellet.png"));
				ghostUrl = new ImageIcon("./blinky.png");
				ghost.setGhost(ghostUrl);
				isGhostEatable = false;
				isTiming = false;
				time = 0;
			}
			repaint();
		}
		/**
		 * Method that runs when a key event is happened
		 */
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {

			case KeyEvent.VK_P:
				ghostUrl = new ImageIcon("./pinky.png");
				ghost.setGhost(ghostUrl);
				break;

			case KeyEvent.VK_B:
				ghostUrl = new ImageIcon("./blinky.png");
				ghost.setGhost(ghostUrl);
				break;

			case KeyEvent.VK_I:
				ghostUrl = new ImageIcon("./inky.png");
				ghost.setGhost(ghostUrl);
				break;

			case KeyEvent.VK_C:
				ghostUrl = new ImageIcon("./clyde.png");
				ghost.setGhost(ghostUrl);
				break;
			}
			repaint();

		}

	}
	/**
	 * Method that check if ghost is collied with pacman or not
	 * @return true if ghost collides with pacman, otherwise false
	 */
	public boolean isGhostCollision() {
		if (mousePoint != null && mousePoint.x > 0 && mousePoint.y > 0) {
			int x1, x2, y1, y2;
			x1 = ghost.getLocation().x + (ghost.getGhost().getIconWidth() / 2);
			y1 = ghost.getLocation().y + (ghost.getGhost().getIconHeight() / 2);
			x2 = mousePoint.x;
			y2 = mousePoint.y;
			int x3 = (x2 - x1);
			int y3 = (y2 - y1);
			double dist = Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2));
			double rad = pacman.getPacman().getIconHeight() / 2;
			if (dist < rad)
				return true;
		}
		return false;
	}
	/**
	 * Method that check if pellet is collied with pacman or not
	 * @return true if pellet collides with pacman, otherwise false
	 */
	public boolean isPelletCollision() {
		if (pellet.getPellet() != null && mousePoint != null) {
			int x1, x2, y1, y2;
			x1 = pellet.getXlocation() + (pellet.getPellet().getIconWidth() / 2);
			y1 = pellet.getYlocation() + (pellet.getPellet().getIconHeight() / 2);
			x2 = mousePoint.x;
			y2 = mousePoint.y;
			int x3 = (x2 - x1);
			int y3 = (y2 - y1);
			double dist = Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2));
			double rad = pacman.getPacman().getIconHeight() / 2;
			if (dist < rad)
				return true;
		}
		return false;
	}

}
