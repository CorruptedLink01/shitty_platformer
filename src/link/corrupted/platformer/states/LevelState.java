package link.corrupted.platformer.states;

import link.corrupted.platformer.levels.Level;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class LevelState extends LinksGameState {

	private static Level level;

	public LevelState() {
		super(States.LEVEL);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		level.render();
		graphics.drawString(level.getName(), 100, 100);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		level.update();
		if(gameContainer.getInput().isKeyPressed(Input.KEY_1)) {
			stateBasedGame.enterState(States.LEVEL_SELECT.getId());
		}
	}

	public static void setLevel(Level level) {
		LevelState.level = level;
	}

	public static Level getLevel() {
		return level;
	}
}
