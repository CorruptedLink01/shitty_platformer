package link.corrupted.platformer.states;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.*;
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
		//graphics.setBackground(new Color(100, 242, 255));
		Resources.getImage("background").draw(0, 0, Window.WIDTH, Window.HEIGHT);

		float scale = 0.8F;

		for(Sprites.TileSprites s : Sprites.TileSprites.values()) {
			Resources.getTileSprite(s).getScaledCopy(scale).draw((70 * scale) * s.getX(), (70 * scale) * s.getY());
		}
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		if(gameContainer.getInput().isKeyPressed(Input.KEY_1)) {
			stateBasedGame.enterState(States.OPTION.getId());
		}
	}

	@Override
	public void keyPressed(int key, char c) {

	}
}
