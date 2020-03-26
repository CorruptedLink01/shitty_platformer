package link.corrupted.platformer.states;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

//TODO make the main menu
public class MainMenuState extends LinksGameState implements ComponentListener {


	private MouseOverArea startButton;
	private MouseOverArea optionButton;
	private MouseOverArea exitButton;

	private StateBasedGame game;

	public MainMenuState() {
		super(States.MENU);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.game = stateBasedGame;

		Image buttonImage = Resources.getImage("button1").getScaledCopy(1.3F);
		startButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, Window.HEIGHT / 2, buttonImage.getWidth(), buttonImage.getHeight(), this);
		startButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		startButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));

		optionButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, startButton.getY() + buttonImage.getHeight() + 20, buttonImage.getWidth(), buttonImage.getHeight(), this);
		optionButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		optionButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));

		exitButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, optionButton.getY() + buttonImage.getHeight() + 20, buttonImage.getWidth(), buttonImage.getHeight(), this);
		exitButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		exitButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));

	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		Image backgroundImage = Resources.getImage("background");
		backgroundImage.draw(0, 0, Window.WIDTH, Window.HEIGHT);
		startButton.render(gameContainer, graphics);
		optionButton.render(gameContainer, graphics);
		exitButton.render(gameContainer, graphics);

		float scale = 1.5F;
		graphics.scale(scale, scale);
		gameContainer.getDefaultFont().drawString(startButton.getX() / scale + ((startButton.getWidth() / 4F) / scale), startButton.getY() / scale + (startButton.getHeight() / 3.5F) / scale, "Start Game", Color.black);
		gameContainer.getDefaultFont().drawString(optionButton.getX() / scale + ((optionButton.getWidth() / 3F) / scale), optionButton.getY() / scale + (optionButton.getHeight() / 3.5F) / scale, "Options", Color.black);
		gameContainer.getDefaultFont().drawString(exitButton.getX() / scale + ((exitButton.getWidth() / 2.5F) / scale), exitButton.getY() / scale + (exitButton.getHeight() / 3.5F) / scale, "Exit", Color.black);
		graphics.resetTransform();

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

	}

	@Override
	public void keyPressed(int key, char c) {

	}

	@Override
	public void componentActivated(AbstractComponent abstractComponent) {
		if(abstractComponent == startButton) {
			game.enterState(States.LEVEL_SELECT.getId());
		}
		if(abstractComponent == optionButton) {
			game.enterState(States.OPTION.getId());
		}
		if(abstractComponent == exitButton) {
			System.exit(0);
		}
	}
}
