package link.corrupted.platformer.entites;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites;
import org.newdawn.slick.GameContainer;

public class Mob extends Entity {

	private int x;
	private int y;

	public Mob(int x, int y) {
		setScaledVariables(Resources.getTileSprite(Sprites.TileSprites.ROPE_ATTACHED), x, y);
		init();
	}

	@Override
	public void init() {
		image = Resources.getTileSprite(Sprites.TileSprites.ROPE_ATTACHED);
	}

	@Override
	public void update(GameContainer gameContainer, int delta) {

	}
}
