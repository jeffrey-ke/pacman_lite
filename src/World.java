import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

import java.util.*;

public abstract class World extends javafx.scene.layout.Pane {

	private AnimationTimer timer;
	private HashSet<KeyCode>down;
	
	public World() {
		timer=new AnimationTimer() {
			@Override
			public void handle(long t) {
				act(t);
				for(Node a : getChildren()) {
					if (a instanceof Actor) {
						((Actor)a).act();
					}
				}
			}
		};
		down=new HashSet<>();
	}

	public abstract void act(long now);
	
	public void add(Actor actor) {
		getChildren().add(actor);
	}
	
	public <A extends Actor>java.util.List<A> getObjects(java.lang.Class<A> cls) {
		ArrayList<A>list=new ArrayList<>();
		for(Node n : getChildren()) {
			if(cls.isInstance(n)) {
				list.add(cls.cast(n));
			}
		}
		return list;
	}
	
	public void remove(Actor actor) {
		getChildren().remove(actor);
	}
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void addKey(KeyCode kc) {
		down.add(kc);
	}
	
	public void removeKey(KeyCode kc) {
		down.remove(kc);
	}
	
	public boolean isKeyDown(KeyCode kc) {
		for(KeyCode code : down) {
			if(code==kc) {
				return true;
			}
		}
		return false;
	}
}

