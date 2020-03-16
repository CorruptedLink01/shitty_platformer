package link.corrupted.platformer.states;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends LinksGameState {

	private String[] options = new String[]{"Start", "Options"};

	private StateBasedGame game;

	public MainMenuState() {
		super(States.MENU);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.game = game;
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		graphics.setBackground(new Color(100, 242, 255));
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK1).draw(0, 0);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK2).draw(100, 0);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK3).draw(200, 0);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK4).draw(0, 100);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK5).draw(100, 100);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK6).draw(200, 100);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK7).draw(300, 0);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK8).draw(400, 0);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK9).draw(300, 100);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK10).draw(500, 0);
//		Resources.getPlayer1Sprite(Sprites.Player1.WALK11).draw(400, 100);
//		Resources.getPlayer1Sprite(Sprites.Player1.DUCK).draw(500, 100);
//		Resources.getPlayer1Sprite(Sprites.Player1.FRONT).draw(0, 200);
//		Resources.getPlayer1Sprite(Sprites.Player1.HURT).draw(600, 0);
//		Resources.getPlayer1Sprite(Sprites.Player1.JUMP).draw(600, 100);
//		Resources.getPlayer1Sprite(Sprites.Player1.STAND).draw(100, 200);

		//Resources.getSprite("tiles", 0, 0).draw(0, 0);

		float scale = 0.8F;

		for(Sprites.TilesSprites s : Sprites.TilesSprites.values()) {
			Resources.getSprite("tiles", s.getX(), s.getY()).getScaledCopy(scale).draw((74 * scale) * s.getX(), (74 * scale) * s.getY());
		}

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

	}

	@Override
	public void keyPressed(int key, char c) {

	}
}
