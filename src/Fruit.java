import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.Node;
/**
 * This is the fruit class. It is the thing that pac-man has to eat to beat the game and eat the ghosts.
 * @author jeffreyke
 *
 */
public class Fruit extends Actor {

	/** Whether the fruit has been eaten */
	public boolean isEaten;
	/**
	 * Creates a fruit object and sets isEaten to false.
	 * @param name the name of the fruit you want (currently only 'apple', 'cherry', and 'strawberry'.)
	 */
	public Fruit(String name) {
		String path = Fruit.class.getClassLoader().getResource("resources/" + name + ".png").toString();
		setImage(new Image(path));
		isEaten = false;
	}

	@Override
	/**
	 * If it's eaten by pac-man, it starts a timer for how long pac-man invulnerable and for how long the ghosts can be eaten.
	 * It also sets its isEaten instance variable to true.
	 */
	public void act() {
		Pacman p = getOneIntersectingObject(Pacman.class);
		if(p != null) {
			p.setIsPowered(true);
			p.setTimeLeft(Pacman.POWERED_TIME);
			List<Node> nodes = getWorld().getChildren();
			for(Node n : nodes) {
				if(n instanceof Ghost) {
					((Ghost)n).setIsDamaged(true);
					((Ghost)n).setTimeLeft(Ghost.TIME_DAMAGED);
				}
			}
			isEaten = true;
		}

	}
	
	public boolean getIsEaten() {
		// TODO Auto-generated method stub
		return isEaten;
	}

}
