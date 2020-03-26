package link.corrupted.platformer.states;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

//TODO make the options menu
public class OptionsState extends LinksGameState implements ComponentListener {

	private AppGameContainer container;
	private StateBasedGame game;

	private MouseOverArea vSyncButton;
	private MouseOverArea fullscreenButton;

	private boolean vSync = true;
	private boolean fullscreen = false;

	public OptionsState() {
		super(States.OPTION);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.game = stateBasedGame;
		this.container = (AppGameContainer)gameContainer;

		Image buttonImage = Resources.getImage("button1").getScaledCopy(1.3F);
		vSyncButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, Window.HEIGHT / 2, buttonImage.getWidth(), buttonImage.getHeight(), this);
		vSyncButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		vSyncButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));

		fullscreenButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, vSyncButton.getY() + buttonImage.getHeight() + 20, buttonImage.getWidth(), buttonImage.getHeight(), this);
		fullscreenButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		fullscreenButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		graphics.setBackground(Color.cyan);
		vSyncButton.render(gameContainer, graphics);
		fullscreenButton.render(gameContainer, graphics);

		graphics.drawString("Vsync: " + gameContainer.isVSyncRequested(), 0, 0);
		graphics.drawString("Vsync: " + vSync, 0, 20);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		if(gameContainer.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			stateBasedGame.enterState(States.MENU.getId());
		}
	}

	@Override
	public void componentActivated(AbstractComponent abstractComponent) {

		if(abstractComponent == vSyncButton) {
			container.setVSync(vSync = !vSync);
		}
		if(abstractComponent == fullscreenButton) {
			try {
				container.setFullscreen(fullscreen = !fullscreen);
			}catch(SlickException e) {
				e.printStackTrace();
			}
		}

	}
}
