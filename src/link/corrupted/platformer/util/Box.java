package link.corrupted.platformer.util;

public class Box {

	public float x;
	public float y;
	public float width;
	public float height;

	public Box() {
	}

	public Box(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public float getEndX() {
		return x + width;
	}

	public float getEndY() {
		return y + height;
	}

	public float getHalfWidth() {
		return width / 2;
	}

	public float getHalfHeight() {
		return height / 2;
	}

	public float getCenterX() {
		return x + getHalfWidth();
	}

	public float getCenterY() {
		return y + getHalfHeight();
	}

	public boolean isCollidingWithBox(Box box) {
		return box.getEndX() >= x && box.getEndY() >= y && getEndX() >= box.x && getEndY() >= box.y;
	}
}
