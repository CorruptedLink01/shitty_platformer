package link.corrupted.platformer.states;

import link.corrupted.platformer.levels.AbstractLevel;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import static link.corrupted.platformer.levels.Levels.*;
import static link.corrupted.platformer.states.States.*;
import static org.newdawn.slick.Input.*;

public class LevelSelectState extends LinksGameState {

	public LevelSelectState() {
		super(LEVEL_SELECT);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		graphics.drawString("LEVEL SELECT", Window.WIDTH / 2 - 50, Window.HEIGHT / 2);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		if(gameContainer.getInput().isKeyPressed(KEY_1)) {
			enterLevel(LEVEL1, stateBasedGame);
		}
		if(gameContainer.getInput().isKeyPressed(KEY_2)) {
			enterLevel(LEVEL2, stateBasedGame);
		}
		if(gameContainer.getInput().isKeyPressed(KEY_T)) {
			enterLevel(TEST_LEVEL, stateBasedGame);
		}
	}

	private void enterLevel(AbstractLevel level, StateBasedGame stateBasedGame) {
		LevelState.setLevel(level);
		stateBasedGame.enterState(LEVEL.getId());
		LevelState.getLevel().init();
	}
}
