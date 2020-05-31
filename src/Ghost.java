import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;


public class Ghost extends Actor {
	
	private int movement;
	 
	private boolean isAlive;
	private boolean isDamaged;
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
		isAlive = true;
		setImage(left);
		direction = LEFT;
		isDamaged = false;
	}

	@Override
	public void act() {
		Random r = new Random();
		direction = r.nextInt(4);
		if(direction == LEFT) setImage(left);
		else if(direction == RIGHT) setImage(right);
		else if(direction == UP) setImage(up);
		else setImage(down);
		
		if(isDamaged) {
			setImage(damaged);
		}
	}
	
	public int getDirection() {
		return direction;
	}

	
	public void setIsDamaged(boolean val) {
		isDamaged = val;
	}
}
