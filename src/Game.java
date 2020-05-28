import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application {
	private Pacman pac;
	private Pacworld world;
	private Ghost orange;
	private Wall block_0;
	private Wall block_1;
	public Game() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stg) throws Exception {
		stg.setTitle("Pacman");
		world = new Pacworld();
		BorderPane root = new BorderPane();
		pac = new Pacman();
		world.add(pac);
		root.setCenter(world);
//		System.out.println(world.getHeight());
//		for(int row = 0; row < 100; row++)
//		{
//			for(int col = 0; col < 100; col++)
//			{
//				Pacman dot = new Pacman();
//				dot.setX(col);
//				dot.setY(row);
//				world.add(dot);
//			}
//		}
		pac.setX(51);
		pac.setY(51);
		
//		orange = new Ghost("orange");
//		world.add(orange);
//		orange.setX(49);
//		orange.setY(49);
		
		block_0 = new Wall(Game.class.getClassLoader().getResource("resources/smaller_block.png").toString());
		block_0.setX(80);
		block_0.setY(80);
		world.add(block_0);
		
		block_1 = new Wall(Game.class.getClassLoader().getResource("resources/smaller_block.png").toString());
		block_1.setX(160);
		block_1.setY(80);
		world.add(block_1);
		
		
		
		world.start();
		String back_image = Game.class.getClassLoader().getResource("resources/game_board.png").toString();
		Image test = new Image(back_image);
		BackgroundImage back = new BackgroundImage(new Image(back_image), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		world.setPrefHeight(test.getHeight());
		world.setPrefWidth(test.getWidth());
		root.setBackground(new Background(back));
		Scene scn = new Scene(root);
		stg.setScene(scn);
		stg.show();
		
		world.requestFocus();
		world.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				world.addKey(ke.getCode());
			}});
		world.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				world.removeKey(ke.getCode());
			}});

	}

}
