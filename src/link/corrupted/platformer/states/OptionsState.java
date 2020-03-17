package link.corrupted.platformer.states;

import link.corrupted.platformer.levels.Level1;
import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class OptionsState extends LinksGameState {

	private StateBasedGame game;

	private Level1 level1;

	public OptionsState() {
		super(States.OPTION);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.game = game;
		level1 = new Level1();
		level1.init();
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
//		float scale = 0.8F;
//		for(Sprites.Player1Sprites s : Sprites.Player1Sprites.values()) {
//			Resources.getPlayer1Sprite(s).getScaledCopy(scale).draw((72 * scale) * s.getX(), (97 * scale) * s.getY());
//		}
//
//		for(Sprites.SmallTileSprites s : Sprites.SmallTileSprites.values()) {
//			Resources.getSmallTileSprite(s).getScaledCopy(scale).draw((5 * scale) * s.getX(), 300 +(24 * scale) * s.getY());
//		}

		level1.renderLevel(graphics);

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		if(gameContainer.getInput().isKeyPressed(Input.KEY_1)) {
			stateBasedGame.enterState(States.MENU.getId());
		}
	}

	@Override
	public void keyPressed(int key, char c) {

	}
}
