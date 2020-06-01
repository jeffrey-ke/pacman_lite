import javafx.scene.Node;
/**
 * This is the Pacworld class. It extends the World class. 
 * It keeps track of whether the game has ended by keeping track
 * of how many fruits are left in the world that haven't been eaten
 * @author jeffreyke
 *
 */
public class Pacworld extends World {
	/**The boolean instance variable that keeps track of whether the game is over */
	private boolean isGameOver;
	/**
	 * Default constructor. Sets isGameOver to false.
	 */
	public Pacworld() {
		isGameOver = false;
	}
	
	@Override
	/**
	 * 
	 * Postcondition: if the game is over, the game will generate a game over message in the center of the screen.
	 * Else, it will count the number of fruits. If the number of fruits is zero, the isGameOver value is set to 
	 * true.
	 */
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
	
	/**
	 *  Sets whether the game is over or not.
	 * @param gameOver the desired boolean value for isGameOver
	 */
	public void setGameOver(boolean gameOver) {
		isGameOver = gameOver;
	}

}
