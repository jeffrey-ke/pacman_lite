import javafx.scene.Node;

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
		else {
			int numFruits = 0;
			for(int i = 0; i < getChildren().size();) {
				Node n = getChildren().get(i);
				if(n instanceof Fruit && ((Fruit) n).isEaten) {
					getChildren().remove(n);
				}
				i++;
				
			}
			for(Node n : getChildren()) {
				if(n instanceof Fruit) {
					numFruits++;
				}
			}
			if(numFruits == 0) {
				setGameOver(true);
			}
		}
	}
	
	public void setGameOver(boolean gameOver) {
		isGameOver = gameOver;
	}

}
