package link.corrupted.platformer.entites;

import link.corrupted.platformer.util.Box;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Entity extends Box {

	private Actions action;

	public Image image;
	public float scale = 1;

	public abstract void init();

	public void render(GameContainer gameContainer, Graphics graphics) {
		if(image != null) {
			//graphics.scale(scale, scale);
			image.getScaledCopy(scale).draw(x, y, width, height);
		}
	}

	public abstract void update(GameContainer gameContainer, int delta);

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}
}
