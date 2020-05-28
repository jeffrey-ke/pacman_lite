import javafx.scene.image.Image;

/**
 * This is the wall class. It's the walls of the maze of pacman's world.
 * @author jeffreyke
 *
 */
public class Wall extends Actor {

	public Wall(String path) {
		setImage(new Image(path));
	}

	@Override
	public void act() {

	}

}
