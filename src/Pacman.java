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
		
		setImage(leftClosed);
		direction = LEFT;
		
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
		
		
		if(getWorld().isKeyDown(KeyCode.LEFT))
		{
			move(-3, 0);
			direction = LEFT;
			if(getOneIntersectingObject(Wall.class) != null)
			{
				move(3, 0);
			}
		}
		else if(getWorld().isKeyDown(KeyCode.RIGHT))
		{
			move(3, 0);
			direction = RIGHT;
			if(getOneIntersectingObject(Wall.class) != null)
			{
				move(-3, 0);
			}
		}
		else if(getWorld().isKeyDown(KeyCode.UP))
		{
			move(0, -3);
			direction = UP;
			if(getOneIntersectingObject(Wall.class) != null)
			{
				move(0, 3);
			}
		}
		else if(getWorld().isKeyDown(KeyCode.DOWN))
		{
			move(0, 3);
			direction = DOWN;
			if(getOneIntersectingObject(Wall.class) != null)
			{
				move(0, -3);
			}
		}
	
		
	}

}
