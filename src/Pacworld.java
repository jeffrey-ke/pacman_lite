import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Pacworld extends World {

	private boolean isGameOver;
	public Pacworld() {
		isGameOver = false;
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(isGameOver) {
			Gameover g = new Gameover();
			g.setX(180);
			g.setY(306);
			add(g);
			getTimer().stop();
		}
	}
	
	public void setGameOver(boolean gameOver) {
		isGameOver = gameOver;
	}

}
