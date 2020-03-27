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

	private MouseOverArea resolutionButton;
	private MouseOverArea vSyncButton;
	private MouseOverArea fullscreenButton;

	private boolean vSync = true;
	private boolean fullscreen = false;
	private int resolutionIndex = 1;

	private int[][] resolutions = {{720, 480}, {1280, 720}, {1920, 1080}};

	public OptionsState() {
		super(States.OPTION);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.game = stateBasedGame;
		this.container = (AppGameContainer)gameContainer;

		Image buttonImage = Resources.getImage("button1").getScaledCopy(1.3F);
		resolutionButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, Window.HEIGHT / 2, buttonImage.getWidth(), buttonImage.getHeight(), this);
		resolutionButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		resolutionButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));

		vSyncButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, resolutionButton.getY() + buttonImage.getHeight() + 20, buttonImage.getWidth(), buttonImage.getHeight(), this);
		vSyncButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		vSyncButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));

		fullscreenButton = new MouseOverArea(gameContainer, buttonImage, Window.WIDTH / 2 - buttonImage.getWidth() / 2, vSyncButton.getY() + buttonImage.getHeight() + 20, buttonImage.getWidth(), buttonImage.getHeight(), this);
		fullscreenButton.setNormalColor(new Color(1, 1, 1, 0.8f));
		fullscreenButton.setMouseOverColor(new Color(1, 1, 1, 0.9f));
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		graphics.setBackground(Color.cyan);
		resolutionButton.render(gameContainer, graphics);
		vSyncButton.render(gameContainer, graphics);
		fullscreenButton.render(gameContainer, graphics);

		float scale = 1.5F;
		graphics.scale(scale, scale);

		String resolutionString = Window.WIDTH + " x " + Window.HEIGHT;
		String vSyncString = vSync ? "Vsync: on" : "Vsync: off";
		String fullscreenString = fullscreen ? "Windowed" : "Fullscreen";

		gameContainer.getDefaultFont().drawString(resolutionButton.getX() / scale + ((resolutionButton.getWidth() / 4F) / scale), resolutionButton.getY() / scale + (resolutionButton.getHeight() / 3.5F) / scale, resolutionString, Color.black);
		gameContainer.getDefaultFont().drawString(vSyncButton.getX() / scale + ((vSyncButton.getWidth() / 4F) / scale), vSyncButton.getY() / scale + (vSyncButton.getHeight() / 3.5F) / scale, vSyncString, Color.black);
		gameContainer.getDefaultFont().drawString(fullscreenButton.getX() / scale + ((fullscreenButton.getWidth() / 4F) / scale), fullscreenButton.getY() / scale + (fullscreenButton.getHeight() / 3.5F) / scale, fullscreenString, Color.black);

		graphics.resetTransform();
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

		if(abstractComponent == resolutionButton) {
			resolutionIndex++;
			if(resolutionIndex >= resolutions.length) {
				resolutionIndex = 0;
			}
			int width = resolutions[resolutionIndex][0];
			int height = resolutions[resolutionIndex][1];

			Window.WIDTH = width;
			Window.HEIGHT = height;

			try {
				container.setDisplayMode(Window.WIDTH, Window.HEIGHT, fullscreen);
			}catch(SlickException e) {
				e.printStackTrace();
			}
		}
	}
}
