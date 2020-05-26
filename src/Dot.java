import javafx.scene.image.Image;

/**
 * This is a dot class. It represents a coordinate point on the scene.
 * @author jeffreyke
 *
 */
public class Dot extends Actor {

	public Dot() {
		String path = Dot.class.getClassLoader().getResource("resources/dot.png").toString();
		Image dotImage = new Image(path);
		setImage(dotImage);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

}
