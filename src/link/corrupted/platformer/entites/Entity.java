package link.corrupted.platformer.entites;

import link.corrupted.platformer.levels.LevelLoader;
import link.corrupted.platformer.util.Box;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import static link.corrupted.platformer.levels.LevelLoader.RENDER_SIZE;
import static link.corrupted.platformer.levels.LevelLoader.SCALE;

public abstract class Entity extends Box {

	public Image image;

	public boolean isAlive = true;

	public boolean applyGravity = true;

	public Player player;

	public abstract void init();

	public void render() {
		if(image != null) {
			image.draw(x, y, width, height);
		}
	}

	public abstract void update(GameContainer gameContainer, int delta);

	public abstract void onDeath();

	//get the amount of Gravity the entity should be affected by
	public float getGravity(int delta) {
		return 0.4F * delta;
	}

	public float getSmallGravity(int delta) {
		return 0.17F * delta;
	}

	//applyGravity to the entity
	public void applyGravity(int delta) {
		float gravity = getGravity(delta);
		float smallGravity = getSmallGravity(delta);
		if(!isGravityColliding(gravity) && applyGravity) {
			y += gravity;
		}else if(!isGravityColliding(smallGravity) && applyGravity) {
			y += smallGravity;
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

	//TODO make slopes work
	//region collision detection
	public boolean isCollidingLeft() {
		return LevelLoader.isColliding(x + RENDER_SIZE / 2, getEndY());
	}

	public boolean isCollidingRight() {
		return LevelLoader.isColliding(getEndX() + RENDER_SIZE / 2, getEndY());
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

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean alive) {
		isAlive = alive;
	}
}
