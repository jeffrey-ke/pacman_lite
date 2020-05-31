import javafx.scene.image.Image;

/**
 * This is a class that displays a game over message.
 * @author jeffreyke
 *
 */
public class Gameover extends Actor {

	public Gameover() {
		setImage(new Image(Gameover.class.getClassLoader().getResource("resources/game_over_message.png").toString()));
	}

	@Override
	public void act() {

	}

}
