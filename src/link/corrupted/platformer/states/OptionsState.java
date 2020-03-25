package link.corrupted.platformer.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;

//TODO make the options menu
public class OptionsState extends LinksGameState implements ComponentListener {

	private StateBasedGame game;

	public OptionsState() {
		super(States.OPTION);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.game = stateBasedGame;


	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		if(gameContainer.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			stateBasedGame.enterState(States.MENU.getId());
		}
	}

	@Override
	public void keyPressed(int key, char c) {

	}

	@Override
	public void componentActivated(AbstractComponent abstractComponent) {

	}
}
