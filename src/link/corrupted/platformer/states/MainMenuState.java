package link.corrupted.platformer.states;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites;
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
		Resources.getPlayer1Sprite(Sprites.Player1.WALK1).draw(0, 0);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK2).draw(100, 0);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK3).draw(200, 0);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK4).draw(0, 100);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK5).draw(100, 100);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK6).draw(200, 100);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK7).draw(300, 0);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK8).draw(400, 0);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK9).draw(300, 100);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK10).draw(500, 0);
		Resources.getPlayer1Sprite(Sprites.Player1.WALK11).draw(400, 100);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

	}

	@Override
	public void keyPressed(int key, char c) {

	}
}
