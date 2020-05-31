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
	private Wall block_2;
	private Wall block_3;
	private Wall block_4;
	private Wall block_5;
	private Wall block_6;
	private Wall block_7;
	private Wall block_8;
	private Wall block_9;
	private Wall block_10;
	private Wall block_11;
	private Wall block_12;
	private Wall block_13;	
	private Wall block_14;
	private Wall block_15;
	private Wall block_16;
	private Wall block_17;
	private Wall block_18;
	private Wall block_19;
	private Wall block_20;
	private Wall block_21;
	private Wall block_22;
	private Wall block_23;
	private Wall block_24;
	private Wall block_25;
	private Wall block_26;
	private Wall block_27;
	private Wall block_28;
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
		
		orange = new Ghost("orange");
		world.add(orange);
		orange.setX(433);
		orange.setY(49);
		
		block_0 = new Wall(Game.class.getClassLoader().getResource("resources/smaller_block.png").toString());
		block_0.setX(80);
		block_0.setY(80);
		world.add(block_0);
		
		block_1 = new Wall(Game.class.getClassLoader().getResource("resources/small_block.png").toString());
		block_1.setX(160);
		block_1.setY(80);
		world.add(block_1);
		
		block_2 = new Wall(Game.class.getClassLoader().getResource("resources/small_block.png").toString());
		block_2.setX(304);
		block_2.setY(80);
		world.add(block_2);
		
		block_3 = new Wall(Game.class.getClassLoader().getResource("resources/smaller_block.png").toString());
		block_3.setX(400);
		block_3.setY(80);
		world.add(block_3);
		
		block_4 = new Wall(Game.class.getClassLoader().getResource("resources/line_small_hori.png").toString());
		block_4.setX(80);
		block_4.setY(144);
		world.add(block_4);
		
		block_5 = new Wall(Game.class.getClassLoader().getResource("resources/left_tee_vert.png").toString());
		block_5.setX(160);
		block_5.setY(144);
		world.add(block_5);
		
		block_6 = new Wall(Game.class.getClassLoader().getResource("resources/up_tee_hori.png").toString());
		block_6.setX(208);
		block_6.setY(144);
		world.add(block_6);
		
		block_7 = new Wall(Game.class.getClassLoader().getResource("resources/right_tee_vert.png").toString());
		block_7.setX(352);
		block_7.setY(144);
		world.add(block_7);
		
		block_8 = new Wall(Game.class.getClassLoader().getResource("resources/line_small_hori.png").toString());
		block_8.setX(400);
		block_8.setY(144);
		world.add(block_8);
		
		block_9 = new Wall(Game.class.getClassLoader().getResource("resources/left_tee_hori.png").toString());
		block_9.setX(178);
		block_9.setY(192);
		world.add(block_9);
		
		block_10 = new Wall(Game.class.getClassLoader().getResource("resources/up_tee_vert.png").toString());
		block_10.setX(256);
		block_10.setY(162);
		world.add(block_10);
		
		block_11 = new Wall(Game.class.getClassLoader().getResource("resources/right_tee_hori.png").toString());
		block_11.setX(304);
		block_11.setY(192);
		world.add(block_11);
		
		block_12 = new Wall(Game.class.getClassLoader().getResource("resources/holding_box.png").toString());
		block_12.setX(208);
		block_12.setY(240);
		world.add(block_12);
		
		block_13 = new Wall(Game.class.getClassLoader().getResource("resources/line_small_vert.png").toString());
		block_13.setX(160);
		block_13.setY(288);
		world.add(block_13);
		
		block_14 = new Wall(Game.class.getClassLoader().getResource("resources/up_tee_hori.png").toString());
		block_14.setX(208);
		block_14.setY(336);
		world.add(block_14);
		
		block_15 = new Wall(Game.class.getClassLoader().getResource("resources/line_small_vert.png").toString());
		block_15.setX(352);
		block_15.setY(288);
		world.add(block_15);
		
		block_16 = new Wall(Game.class.getClassLoader().getResource("resources/left_L_hori.png").toString());
		block_16.setX(80);
		block_16.setY(384);
		world.add(block_16);
		
		block_17 = new Wall(Game.class.getClassLoader().getResource("resources/left_L_vert.png").toString());
		block_17.setX(112);
		block_17.setY(402);
		world.add(block_17);
		
		block_18 = new Wall(Game.class.getClassLoader().getResource("resources/line_large_hori.png").toString());
		block_18.setX(160);
		block_18.setY(384);
		world.add(block_18);
		
		block_19 = new Wall(Game.class.getClassLoader().getResource("resources/up_tee_vert.png").toString());
		block_19.setX(256);
		block_19.setY(354);
		world.add(block_19);
		
		block_20 = new Wall(Game.class.getClassLoader().getResource("resources/line_large_hori.png").toString());
		block_20.setX(304);
		block_20.setY(384);
		world.add(block_20);
		
		block_21 = new Wall(Game.class.getClassLoader().getResource("resources/right_L_hori.png").toString());
		block_21.setX(400);
		block_21.setY(384);
		world.add(block_21);
		
		block_28 = new Wall(Game.class.getClassLoader().getResource("resources/right_L_vert.png").toString());
		block_28.setX(400);
		block_28.setY(402);
		world.add(block_28);
		
		block_22 = new Wall(Game.class.getClassLoader().getResource("resources/left_tonfa_hori.png").toString());
		block_22.setX(80);
		block_22.setY(480);
		world.add(block_22);
		
		block_23 = new Wall(Game.class.getClassLoader().getResource("resources/right_tonfa_vert.png").toString());
		block_23.setX(160);
		block_23.setY(432);
		world.add(block_23);
		
		block_24 = new Wall(Game.class.getClassLoader().getResource("resources/up_tee_hori.png").toString());
		block_24.setX(208);
		block_24.setY(432);
		world.add(block_24);
		
		block_25 = new Wall(Game.class.getClassLoader().getResource("resources/up_tee_vert.png").toString());
		block_25.setX(256);
		block_25.setY(450);
		world.add(block_25);
		
		block_26 = new Wall(Game.class.getClassLoader().getResource("resources/right_tonfa_hori.png").toString());
		block_26.setX(304);
		block_26.setY(480);
		world.add(block_26);
		
		block_27 = new Wall(Game.class.getClassLoader().getResource("resources/right_tonfa_vert.png").toString());
		block_27.setX(352);
		block_27.setY(432);
		world.add(block_27);
		
		Wall leftTopDivider = new Wall(Game.class.getClassLoader().getResource("resources/left_top_divider.png").toString());
		leftTopDivider.setX(50);
		leftTopDivider.setY(192);
		world.add(leftTopDivider);
		
		Wall leftBottomDivider = new Wall(Game.class.getClassLoader().getResource("resources/left_below_divider.png").toString());
		leftBottomDivider.setX(50);
		leftBottomDivider.setY(288);
		world.add(leftBottomDivider);
		
		Wall rightTopDivider = new Wall(Game.class.getClassLoader().getResource("resources/right_top_divider.png").toString());
		rightTopDivider.setX(400);
		rightTopDivider.setY(192);
		world.add(rightTopDivider);
		
		Wall rightBottomDivider = new Wall(Game.class.getClassLoader().getResource("resources/right_bottom_divider.png").toString());
		rightBottomDivider.setX(400);
		rightBottomDivider.setY(288);
		world.add(rightBottomDivider);
		
		Wall topNub = new Wall(Game.class.getClassLoader().getResource("resources/top_nub.png").toString());
		topNub.setX(256);
		topNub.setY(50);
		world.add(topNub);
		
		Wall leftNub = new Wall(Game.class.getClassLoader().getResource("resources/left_nub.png").toString());
		leftNub.setX(50);
		leftNub.setY(432);
		world.add(leftNub);
		
		Wall rightNub = new Wall(Game.class.getClassLoader().getResource("resources/right_nub.png").toString());
		rightNub.setX(448);
		rightNub.setY(432);
		world.add(rightNub);
		
		
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
