package link.corrupted.platformer.entites;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites.Player1Sprites;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import static org.newdawn.slick.Input.*;

public class Player extends Entity {

	private final int MAX_SPEED = 50;
	private float speed = 0.3F;
	private int playerId;
	private int jumpHeight = 250;

	public Player(int playerId, int x, int y) {
		this.playerId = playerId;
		setScaledVariables(getFirstSprite(), x, y);
		init();
	}

	@Override
	public void init() {
		setAction(Actions.WALKING);
	}

	int updateIndex = 0;
	int jumpIndex = 0;
	boolean jumpKeyWasPressed = false;
	@Override
	public void update(GameContainer gameContainer, int delta) {

		Input input = gameContainer.getInput();

		move(input, delta);
		jump(input);

		if(jumpKeyWasPressed) {
			if(jumpIndex >= jumpHeight) {
				jumpIndex = 0;
				jumpKeyWasPressed = false;
				applyGravity = true;
			}else {
				y -= 0.4F * delta;
				jumpIndex += delta;
			}
		}


		if(updateIndex >= 40) {
			image = getSprite();
			updateIndex = 0;
		}
		updateIndex+=delta;

		if(lastAction == Actions.WALKING_BACK) {
			setAction(Actions.STAND_LEFT);
		}else if(lastAction != Actions.STAND_LEFT){
			setAction(Actions.STAND_RIGHT);
		}

		checkCollision(delta);
	}

	private void move(Input input, int delta) {
		if(input.isKeyDown(KEY_A) || input.isKeyDown(KEY_LEFT)) {
			x -= speed * delta;
			setAction(Actions.WALKING_BACK);
		}else if(input.isKeyDown(KEY_D) || input.isKeyDown(KEY_RIGHT)) {
			x += speed * delta;
			setAction(Actions.WALKING);
		}
	}

	boolean hasJumped = false;
	private void jump(Input input) {
		if(isCollidingDown()) {
			hasJumped = false;
		}
		if(!hasJumped) {
			if(input.isKeyPressed(KEY_SPACE) || input.isKeyPressed(KEY_W)) {
				setAction(Actions.JUMP);
				jumpKeyWasPressed = true;
				applyGravity = false;
				hasJumped = true;
			}
		}
	}

	private void checkCollision(int delta) {
		if(isCollidingLeft()) {
			x += speed * delta;
		}
		if(isCollidingRight()) {
			x -= speed * delta;
		}
		if(isCollidingUp()) {
			y += speed * delta;
		}
		if(isCollidingDown()) {
			y -= speed * delta;
		}
	}

	private Image getSprite() {
		Image image = null;
		if(playerId == 1) {
			image = getPlayer1Sprite();
		}
		return image;
	}

	private Image getPlayer1Sprite() {
		switch(getAction()) {
			case WALKING:
				return getPlayer1WalkingSprite();
			case WALKING_BACK:
				return getPlayer1WalkingSprite().getFlippedCopy(true, false);
			case DUCK:
				return Resources.getPlayer1Sprite(Player1Sprites.DUCK);
			case HURT:
				return Resources.getPlayer1Sprite(Player1Sprites.HURT);
			case JUMP:
				return Resources.getPlayer1Sprite(Player1Sprites.JUMP);
			case FRONT:
				return Resources.getPlayer1Sprite(Player1Sprites.FRONT);
			case STAND_LEFT:
				return Resources.getPlayer1Sprite(Player1Sprites.STAND).getFlippedCopy(true, false);
			case STAND_RIGHT:
			default:
				return Resources.getPlayer1Sprite(Player1Sprites.STAND);
		}
	}

	int frameIndex = 0;
	private Image getPlayer1WalkingSprite() {
		Image image = null;
		switch(frameIndex) {
			case 0:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK9);
				frameIndex++;
				break;
			case 1:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK10);
				frameIndex++;
				break;
			case 2:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK11);
				frameIndex++;
				break;
			case 3:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK1);
				frameIndex++;
				break;
			case 4:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK2);
				frameIndex++;
				break;
			case 5:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK3);
				frameIndex++;
				break;
			case 6:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK4);
				frameIndex++;
				break;
			case 7:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK5);
				frameIndex++;
				break;
			case 8:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK6);
				frameIndex++;
				break;
			case 9:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK7);
				frameIndex++;
				break;
			case 10:
				image = Resources.getPlayer1Sprite(Player1Sprites.WALK8);
				frameIndex = 0;
				break;
		}
		return image;
	}

	private Image getFirstSprite() {
		Image image = null;
		if(playerId == 1) {
			image = Resources.getPlayer1Sprite(Player1Sprites.STAND);
		}
		return image;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}
}
