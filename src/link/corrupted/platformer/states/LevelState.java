package link.corrupted.platformer.states;

import link.corrupted.platformer.entites.Entity;
import link.corrupted.platformer.entites.Player;
import link.corrupted.platformer.levels.ILevel;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class LevelState extends LinksGameState {

	private ArrayList<Entity> entities;

	private static ILevel level;

	public LevelState() {
		super(States.LEVEL);
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		entities = new ArrayList<>();

		entities.add(new Player(1, level.getSpawnX(), level.getSpawnY()));

	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

		level.render();

		for(Entity e : entities) {
			e.render();
		}

		graphics.setColor(Color.black);
		graphics.drawString(level.getName(), 100, 100);

	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
		level.update();
		for(Entity e : entities) {
			if(e.applyGravity) {
				e.applyGravity(delta);
			}
			e.update(gameContainer, delta);
		}

		if(gameContainer.getInput().isKeyPressed(Input.KEY_1)) {
			stateBasedGame.enterState(States.LEVEL_SELECT.getId());
		}
	}

	public static void setLevel(ILevel level) {
		LevelState.level = level;
	}

	public static ILevel getLevel() {
		return level;
	}
}
