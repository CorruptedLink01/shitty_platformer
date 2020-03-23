package link.corrupted.platformer.states;

import link.corrupted.platformer.entites.Entity;
import link.corrupted.platformer.entites.Player;
import link.corrupted.platformer.levels.AbstractLevel;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class LevelState extends LinksGameState {

	private ArrayList<Entity> entities;

	private static AbstractLevel level;
	private static Entity player;

	public LevelState() {
		super(States.LEVEL);
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		level.enter();
		entities = level.getEntities();
		player = entities.get(entities.size() - 1);
		System.out.println(player);
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

		//TODO to translate
		float translateX = (level.getSpawnX() - player.x) * ((Player)player).getSpeed();
//		graphics.translate(translateX, 0);
		graphics.translate(level.getSpawnX() - player.x, 0);
		level.render(player.x, player.y);

		for(Entity e : entities) {
			e.render();
		}

		graphics.setColor(Color.black);
		graphics.drawString(level.getName(), 100, 100);

		graphics.resetTransform();

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

	public static void setLevel(AbstractLevel level) {
		LevelState.level = level;
	}

	public static AbstractLevel getLevel() {
		return level;
	}
}
