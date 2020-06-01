import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
public class Pacman extends Actor {

	private boolean isClosed;
	private boolean isPowered;
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
	
	public static final int POWERED_TIME = 1200;
	/** How much time pac-man has left being able to eat ghosts */
	private int timeLeft;
	
	private KeyCode movement;
	/**
	 * Creates a pac-man object with all the sprites in each direction.
	 */
	public Pacman() {
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
		isPowered = false;
		timeLeft = POWERED_TIME;
	}
	/**
	 * Sets whether pac-man can eat ghosts or not.
	 * @param val whether pac-man can eat ghosts.
	 */
	public void setIsPowered(boolean val) {
		isPowered = val;
	}
	
	/**
	 * Sets how much time pac-man has left.
	 * @param timeLeft how much time he has left.
	 */
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}
	
	@Override
	public void act() {
		
		// If pac-man is out of time, he can't eat ghosts anymore
		if(timeLeft <= 0) {
			isPowered = false;
		}
		
		//if pac-man is still invulnerable, he loses a frme of time
		if(isPowered) {
			timeLeft--;
		}
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
		
		//basic key commands to move pac-man. 
		boolean canMove = false;
		if(getWorld().isKeyDown(KeyCode.LEFT))
		{
			movement = KeyCode.LEFT;
		}
		else if(getWorld().isKeyDown(KeyCode.RIGHT))
		{
			movement = KeyCode.RIGHT;
		}
		else if(getWorld().isKeyDown(KeyCode.UP))
		{
			movement = KeyCode.UP;			
		}
		else if(getWorld().isKeyDown(KeyCode.DOWN))
		{
			movement = KeyCode.DOWN;
		}
		
		if(movement == KeyCode.LEFT)
		{
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
		
		if(getOneIntersectingObject(Ghost.class) != null) {
			if(isPowered) getWorld().remove(getOneIntersectingObject(Ghost.class));
			else {
				((Pacworld)getWorld()).setGameOver(true);
			}
			
		}
	
		
	}

}
