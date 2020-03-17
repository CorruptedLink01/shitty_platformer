package link.corrupted.platformer.main;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.states.LevelSelectState;
import link.corrupted.platformer.states.LevelState;
import link.corrupted.platformer.states.MainMenuState;
import link.corrupted.platformer.states.OptionsState;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Engine extends StateBasedGame {

	public Engine(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer gameContainer) {
		gameContainer.setMaximumLogicUpdateInterval(Window.FPS);
		gameContainer.setTargetFrameRate(Window.FPS);

		//TODO make these ingame options
		gameContainer.setShowFPS(false);
//		gameContainer.setVSync(true);

		new Resources();

		addState(new MainMenuState());
		addState(new OptionsState());
		addState(new LevelSelectState());
		addState(new LevelState());

	}
}
