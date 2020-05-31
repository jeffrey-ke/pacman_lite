import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;


public class Ghost extends Actor {
	
	private int movement;
	 
	public boolean isAlive;
	
	private int direction;
	
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int[] directions = new int[4];
	private Image up;
	private Image right;
	private Image down;
	private Image left;
	public Ghost(String colour) {
		String _left = Ghost.class.getClassLoader().getResource("resources/" + colour + "_left.png").toString();
		left = new Image(_left);
		
		String _up = Ghost.class.getClassLoader().getResource("resources/" + colour + "_up.png").toString();
		up = new Image(_up);
		
		String _right = Ghost.class.getClassLoader().getResource("resources/" + colour + "_right.png").toString();
		right = new Image(_right);
		
		String _down = Ghost.class.getClassLoader().getResource("resources/" + colour + "_down.png").toString();
		down = new Image(_down);
		
		isAlive = true;
		setImage(down);
		direction = DOWN;
	}

	@Override
	public void act() {
		if(direction == LEFT) setImage(left);
		else if(direction == RIGHT) setImage(right);
		else if(direction == UP) setImage(up);
		else setImage(down);
		
		Random rand = new Random();
		boolean canMove = false;
//		System.out.println("X: " + (int)getX());
//		System.out.println("Y: " + (int)getY());
//		System.out.println();
		if((15 + (int)getX()) % 16 == 0 && (15 + (int)getY()) % 16 == 0)
		{
			canMove = true;
		}
		//chooses a random movement direction
		movement = rand.nextInt(4);
		directions[direction]++;
		System.out.println(Arrays.toString(directions));
		if(canMove)
		{
			if(movement == LEFT)
			{
				direction = LEFT;
				move(-1, 0);
				if(getX() < 49 || getX() > 451 ||getOneIntersectingObject(Wall.class) != null)
				{
					move(1, 0);
				}
			}
			else if(movement == RIGHT)
			{
				direction = RIGHT;
				move(1, 0);
				if(getX() < 49 || getX() > 451 ||getOneIntersectingObject(Wall.class) != null)
				{
					move(-1, 0);
				}
			}
			else if(movement == UP)
			{
				direction = UP;
				move(0, -1);
				if(getY() < 49 || getY() > 499|| getOneIntersectingObject(Wall.class) != null)
				{
					move(0, 1);
				}
			}
			else if(movement == DOWN)
			{
				direction = DOWN;
				move(0, 1);
				if(getY() < 49 || getY() > 499|| getOneIntersectingObject(Wall.class) != null)
				{
					move(0, -1);
				}
			}
		}
		else
		{
			if(direction == LEFT) {
				move(-1, 0);
				if(getX() < 49 || getX() > 451 || getOneIntersectingObject(Wall.class) != null)
				{
					move(1, 0);
				}
			}
			else if(direction == RIGHT) {
				move(1, 0);
				if(getX() < 49 || getX() > 451 || getOneIntersectingObject(Wall.class) != null)
				{
					move(1, 0);
				}
			}
			else if(direction == UP) {
				move(0, -1);
				if(getY() < 49 || getY() > 499|| getOneIntersectingObject(Wall.class) != null)
				{
					move(0, 1);
				}
			}
			else if(direction == DOWN) {
				move(0, 1);
				if(getY() < 49 || getY() > 499|| getOneIntersectingObject(Wall.class) != null)
				{
					move(0, -1);
				}
			}
		}
	}
	
	public int getDirection() {
		return direction;
	}

}
