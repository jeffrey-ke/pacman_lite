import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
public class Pacman extends Actor {

	private boolean isClosed;
	private boolean isAlive;
	/*
	 * The following instant variables are images for 
	 * when pacman moves up, down, left, and right
	 */
	private Image upOpen;
	private Image upClosed;
	private Image leftOpen;
	private Image leftClosed;
	private Image downOpen;
	private Image downClosed;
	private Image rightOpen;
	private Image rightClosed;
	/*
	 * 0 = up
	 * 1 = right
	 * 2 = down
	 * 3 = left
	 */
	private int direction;
	
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	
	private KeyCode movement;
	public Pacman() {
//		String path = Pacman.class.getClassLoader().getResource("resources/pacman_closed.png").toString();
//		Image img = new Image(path);
		String upO = Pacman.class.getClassLoader().getResource("resources/pac_up_open.png").toString();
		upOpen = new Image(upO);
		String upC = Pacman.class.getClassLoader().getResource("resources/pac_up_closed.png").toString();
		upClosed = new Image(upC);
		
		String leftO = Pacman.class.getClassLoader().getResource("resources/pac_left_open.png").toString();
		leftOpen = new Image(leftO);
		String leftC = Pacman.class.getClassLoader().getResource("resources/pac_left_closed.png").toString();
		leftClosed = new Image(leftC);
		
		String downO = Pacman.class.getClassLoader().getResource("resources/pac_down_open.png").toString();
		downOpen = new Image(downO);
		String downC = Pacman.class.getClassLoader().getResource("resources/pac_down_closed.png").toString();
		downClosed = new Image(downC);
		
		String rightO = Pacman.class.getClassLoader().getResource("resources/pac_right_open.png").toString();
		rightOpen = new Image(rightO);
		String rightC = Pacman.class.getClassLoader().getResource("resources/pac_right_closed.png").toString();
		rightClosed = new Image(rightC);
		
		setImage(rightClosed);
		direction = RIGHT;
		
		isClosed = true;
		isAlive = true;
	}

	
	@Override
	public void act() {
		// Making pac-man open and close with each animation frame.
		if(direction == LEFT)
		{
			setImage((isClosed) ? leftOpen : leftClosed);
		}
		else if(direction == RIGHT)
		{
			setImage((isClosed) ? rightOpen : rightClosed);
		}
		else if(direction == UP)
		{
			setImage((isClosed) ? upOpen : upClosed);
		}
		else
		{
			setImage((isClosed) ? downOpen : downClosed);
		}
		isClosed = !isClosed;
		
		//basic key commands to move pac-man. I'll have to 
		//adjust it to account for the walls in pac-man
		boolean canMove = false;
//		System.out.println();
//		System.out.println("X: " + (int)getX());
//		System.out.println("Y: " + (int)getY());
//		System.out.println("Center: " + ((int)getX() + 13) + ", " + ((int)getY() + 13));
		
//		if(((int)getX() + 13)%16 == 0 && ((int)getY() + 13)%16==0)
//		{
//			//when pacman is at an integer grid point
//			canMove = true;
//		}
		if(getWorld().isKeyDown(KeyCode.LEFT))
		{
			movement = KeyCode.LEFT;
//			if(((int)getY() + 13)%16 == 0)
//			{
//				canMove = true;
//			}
//			move(-1, 0);
//			if(getOneIntersectingObject(Wall.class) != null)
//			{
//				System.out.println("Hit a wall!");
//				canMove = false;
//			}
//			move(1, 0);
		}
		else if(getWorld().isKeyDown(KeyCode.RIGHT))
		{
			movement = KeyCode.RIGHT;
//			if(((int)getY() + 13)%16 == 0)
//			{
//				canMove = true;
//			}
//			move(1, 0);
//			if(getOneIntersectingObject(Wall.class) != null)
//			{
//				System.out.println("Hit a wall!");
//				canMove = false;
//			}
//			move(-1, 0);
			
		}
		else if(getWorld().isKeyDown(KeyCode.UP))
		{
			movement = KeyCode.UP;
//			if(((int)getX() + 13)%16==0) 
//			{
//				canMove = true;
//			}
//			move(0, -1);
//			if(getOneIntersectingObject(Wall.class) != null)
//			{
//				System.out.println("Hit a wall!");
//				canMove = false;
//			}
//			move(0, 1);
			
		}
		else if(getWorld().isKeyDown(KeyCode.DOWN))
		{
			movement = KeyCode.DOWN;
//			if(((int)getX() + 13)%16==0) 
//			{
//				canMove = true;
//			}
//			move(0, 1);
//			if(getOneIntersectingObject(Wall.class) != null)
//			{
//				System.out.println("Hit a wall!");
//				canMove = false;
//			}
//			move(0, -1);
		}
//		System.out.print("Movement: ");
		if(movement == KeyCode.LEFT)
		{
//			System.out.println("LEFT");
			if(((int)getY() + 13)%16 == 0)
			{
				canMove = true;
			}
			move(-1, 0);
			if(getOneIntersectingObject(Wall.class) != null)
			{
				canMove = false;
			}
			move(1, 0);
		}
		else if(movement == KeyCode.RIGHT)
		{
//			System.out.println("RIGHT");
			if(((int)getY() + 13)%16 == 0)
			{
				canMove = true;
			}
			move(1, 0);
			if(getOneIntersectingObject(Wall.class) != null)
			{
				canMove = false;
			}
			move(-1, 0);
		}
		else if(movement == KeyCode.UP)
		{
//			System.out.println("UP");
			if(((int)getX() + 13)%16==0) 
			{
				canMove = true;
			}
			move(0, -1);
			if(getOneIntersectingObject(Wall.class) != null)
			{
				canMove = false;
			}
			move(0, 1);
		}
		else if(movement == KeyCode.DOWN)
		{
//			System.out.println("DOWN");
			if(((int)getX() + 13)%16==0) 
			{
				canMove = true;
			}
			move(0, 1);
			if(getOneIntersectingObject(Wall.class) != null)
			{
				canMove = false;
			}
			move(0, -1);
		}
//		System.out.print("Direction: ");
//		if(direction == UP) System.out.println("UP");
//		else if(direction == DOWN) System.out.println("DOWN");
//		else if(direction == LEFT) System.out.println("LEFT");
//		else if(direction == RIGHT) System.out.println("RIGHT");
//		
//		System.out.println("Can Move: " + canMove);
		
		if(canMove)
		{
			if(movement == KeyCode.LEFT) {
				direction = LEFT;
				move(-1, 0);
				if(getX() < 51 || getX() > 451 || getOneIntersectingObject(Wall.class) != null)
				{
					move(1, 0);
				}
			}
			else if(movement == KeyCode.RIGHT) {
				direction = RIGHT;
				move(1, 0);
				if(getX() < 51 || getX() > 451 || getOneIntersectingObject(Wall.class) != null)
				{
					move(-1, 0);
				}
			}
			else if (movement == KeyCode.UP) {
				direction = UP;
				move(0, -1);
				if(getY() < 51 || getY() > 499 || getOneIntersectingObject(Wall.class) != null)
				{
					move(0, 1);
				}
			}
			else if(movement == KeyCode.DOWN) {
				direction = DOWN;
				move(0, 1);
				if(getY() < 51 || getY() > 499 || getOneIntersectingObject(Wall.class) != null)
				{
					move(0, -1);
				}
			}
		}
		else
		{
			if(direction == LEFT) {
				move(-1, 0);
				if(getX() < 51 || getX() > 451 || getOneIntersectingObject(Wall.class) != null)
				{
					move(1, 0);
				}
			}
			else if(direction == RIGHT) {
				move(1, 0);
				if(getX() < 51 || getX() > 451 || getOneIntersectingObject(Wall.class) != null)
				{
					move(-1, 0);
				}
			}
			else if(direction == UP) {
				move(0, -1);
				if(getY() < 51 || getY() > 502 || getOneIntersectingObject(Wall.class) != null)
				{
					move(0, 1);
				}
			}
			else if(direction == DOWN) { 
				move(0, 1);
				if(getY() < 51 || getY() > 502 || getOneIntersectingObject(Wall.class) != null)
				{
					move(0, -1);
				}
			}
			
		}
	
		
	}

}
