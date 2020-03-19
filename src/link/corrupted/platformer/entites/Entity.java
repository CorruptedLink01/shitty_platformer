package link.corrupted.platformer.entites;

import link.corrupted.platformer.levels.LevelLoader;
import link.corrupted.platformer.util.Box;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import static link.corrupted.platformer.levels.LevelLoader.SCALE;

public abstract class Entity extends Box {

	private Actions action;
	protected Actions lastAction;

	public Image image;

	//TODO find better name
	public boolean applyGravity = true;

	public abstract void init();

	public void render(GameContainer gameContainer, Graphics graphics) {
		if(image != null) {
			image.draw(x, y, width, height);
		}
	}

	public abstract void update(GameContainer gameContainer, int delta);

	public void applyGravity(int delta) {
		if(!isCollidingDown() && applyGravity) {
			y += 0.5F * delta;
		}
	}

	public void setScaledVariables(Image defaultSprite, int x, int y) {
		width = defaultSprite.getWidth() / SCALE;
		height = defaultSprite.getHeight() / SCALE;
		this.x = x / SCALE - width;
		this.y = y / SCALE - height;
	}

	public boolean isCollidingLeft() {
		return LevelLoader.isColliding(x - 2, getCenterY());
	}

	public boolean isCollidingRight() {
		return LevelLoader.isColliding(getEndX() + 2, getCenterY());
	}

	public boolean isCollidingUp() {
		return LevelLoader.isColliding(getCenterX(), y - 2);
	}

	public boolean isCollidingDown() {
		return LevelLoader.isColliding(getCenterX(), getEndY() + 2);
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
		this.lastAction = action;
	}

}
