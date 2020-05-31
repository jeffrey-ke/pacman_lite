import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.Node;

public class Fruit extends Actor {

	public Fruit(String name) {
		String path = Fruit.class.getClassLoader().getResource("resources/" + name + ".png").toString();
		setImage(new Image(path));
	}

	@Override
	public void act() {
		Pacman p = getOneIntersectingObject(Pacman.class);
		if(p != null) {
			p.setIsPowered(true);
			List<Node> nodes = getWorld().getChildren();
			for(Node n : nodes) {
				if(n instanceof Ghost) {
					((Ghost)n).setIsDamaged(true);
				}
			}
		}

	}

}
