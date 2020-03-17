package link.corrupted.platformer.states;

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
		graphics.drawString("LEVEL SELECT", Window.WIDTH / 2, Window.HEIGHT / 2);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		if(gameContainer.getInput().isKeyPressed(KEY_1)) {
			LevelState.setLevel(LEVEL1);
			enterLevel(stateBasedGame);
			LevelState.getLevel().init();
		}
		if(gameContainer.getInput().isKeyPressed(KEY_2)) {
			LevelState.setLevel(LEVEL2);
			enterLevel(stateBasedGame);
			LevelState.getLevel().init();
		}
	}

	private void enterLevel(StateBasedGame stateBasedGame) {
			stateBasedGame.enterState(LEVEL.getId());
	}
}
