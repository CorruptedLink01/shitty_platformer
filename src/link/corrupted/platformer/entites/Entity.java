package link.corrupted.platformer.entites;

import link.corrupted.platformer.levels.LevelLoader;
import link.corrupted.platformer.util.Box;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import static link.corrupted.platformer.levels.LevelLoader.SCALE;

public abstract class Entity extends Box {

	private Actions action;
	protected Actions lastAction;

	public Image image;

	public boolean applyGravity = true;

	public abstract void init();

	public void render() {
		if(image != null) {
			image.draw(x, y, width, height);
		}
	}

	public abstract void update(GameContainer gameContainer, int delta);

	//get the amount of Gravity the entity should be affected by
	public float getGravity(int delta) {
		return 0.5F * delta;
	}

	//applyGravity to the entity
	public void applyGravity(int delta) {
		float gravity = getGravity(delta);
		if(!isGravityColliding(gravity) && applyGravity) {
			y += gravity;
		}
	}

	//Scale the entity to the level scale
	//And scale the entity position
	public void setScaledVariables(Image defaultSprite, int x, int y) {
		width = defaultSprite.getWidth() / SCALE;
		height = defaultSprite.getHeight() / SCALE;
		this.x = x / SCALE;
		this.y = y / SCALE - height - 10;
	}

	//region collision detection
	public boolean isCollidingLeft() {
		return LevelLoader.isColliding(x - 1, getEndY());
	}

	public boolean isCollidingRight() {
		return LevelLoader.isColliding(getEndX() + 1, getEndY());
	}

	public boolean isCollidingUp() {
		return LevelLoader.isColliding(getCenterX(), y - 1);
	}

	public boolean isCollidingDown() {
		return LevelLoader.isColliding(getCenterX(), getEndY() + 1);
	}

	//detect if entity would collide after being affected by gravity
	public boolean isGravityColliding(float gravity) {
		return LevelLoader.isColliding(getCenterX(), getEndY() + gravity);
	}
	//endregion

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
		this.lastAction = action;
	}

}
