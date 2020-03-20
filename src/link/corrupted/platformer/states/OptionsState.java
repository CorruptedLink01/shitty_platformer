package link.corrupted.platformer.states;

import link.corrupted.platformer.levels.Levels;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class OptionsState extends LinksGameState {

	private StateBasedGame game;

	public OptionsState() {
		super(States.OPTION);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.game = game;
		Levels.LEVEL1.init();
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

		Levels.LEVEL1.render(600, 600);

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		if(gameContainer.getInput().isKeyPressed(Input.KEY_1)) {
			stateBasedGame.enterState(States.LEVEL_SELECT.getId());
		}
	}

	@Override
	public void keyPressed(int key, char c) {

	}
}
