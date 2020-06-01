
import java.util.Random;

import javafx.scene.image.Image;

/**
 * This is the Ghost class. It's the ghost enemy from the pac-man game. 
 * It moves randomly without regards to obstacles in the board (because it's
 * a ghost and can phase through objects). It acts as the main obstacle for 
 * pac-man.
 * @author jeffreyke
 *
 */
public class Ghost extends Actor {
	/** Whether the ghost will appear blue and vulnerable*/
	private boolean isDamaged;
	/**What direction the ghost is in */
	private int direction;
	
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	
	private Image up;
	private Image right;
	private Image down;
	private Image left;
	
	private Image damaged;
	
	public static final int TIME_DAMAGED = 1200;
	
	/** How much time the ghost has left while it's vulnerable */
	private int timeLeft;
	/**
	 * Creates a ghost with all the necessary frames and sprites
	 * @param colour what colour the ghost is (only pink or orange).
	 */
	public Ghost(String colour) {
		String _left = Ghost.class.getClassLoader().getResource("resources/" + colour + "_left.png").toString();
		left = new Image(_left);
		
		String _up = Ghost.class.getClassLoader().getResource("resources/" + colour + "_up.png").toString();
		up = new Image(_up);
		
		String _right = Ghost.class.getClassLoader().getResource("resources/" + colour + "_right.png").toString();
		right = new Image(_right);
		
		String _down = Ghost.class.getClassLoader().getResource("resources/" + colour + "_down.png").toString();
		down = new Image(_down);
		
		damaged = new Image(Ghost.class.getClassLoader().getResource("resources/ghost_damaged.png").toString());
		setImage(left);
		direction = LEFT;
		isDamaged = false;
		timeLeft = TIME_DAMAGED;
	}
	
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	@Override
	public void act() {
		
		if(timeLeft <= 0) {
			isDamaged = false;
		}
		if(isDamaged) {
			timeLeft--;
		}
		
		Random r = new Random();
		direction = r.nextInt(4);
		if(direction == LEFT) setImage(left);
		else if(direction == RIGHT) setImage(right);
		else if(direction == UP) setImage(up);
		else setImage(down);
		
		if(isDamaged) {
			setImage(damaged);
		}
		
		Random rand = new Random();
		//chooses a random movement direction
		direction = rand.nextInt(4);
		
		
		if(direction == LEFT) {
			move(-1, 0);
			if(getX() < 49 || getX() > 451)
			{
				move(1, 0);
			}
		}
		else if(direction == RIGHT) {
			move(1, 0);
			if(getX() < 49 || getX() > 451)
			{
				move(-1, 0);
			}
		}
		else if(direction == UP) { 
			move(0, -1);
			if(getX() < 49 || getX() > 451)
			{
				move(0, -1);
			}
		}
		else if(direction == DOWN) { 
			move(0, 1);
			if(getX() < 49 || getX() > 451)
			{
				move(0, -1);
			}
		}
		

	}
	
	/**
	 * Gets the direction of the ghost.
	 * @return the direction of the ghost, a number between 0 to 3, inclusive.
	 */
	public int getDirection() {
		return direction;
	}

	/*
	 * Sets whether the ghost is damaged or not.
	 */
	public void setIsDamaged(boolean val) {
		isDamaged = val;
	}
}
