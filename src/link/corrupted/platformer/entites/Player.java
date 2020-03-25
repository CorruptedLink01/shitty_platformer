package link.corrupted.platformer.entites;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites.Player1Sprites;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import static org.newdawn.slick.Input.*;

public class Player extends Entity {

	private PlayerActions action;
	protected PlayerActions lastAction;

	private int health = 20;
	private float speed = 0.4F;
	private int playerId;
	private int jumpHeight = 250;

	int frameIndex = 0;
	int maxImmunity = 120 * 10;
	int immunityFrames = maxImmunity;

	public Player(int playerId, int x, int y) {
		this.playerId = playerId;
		setScaledVariables(getDefaultSprite(), x, y);
		init();
	}

	@Override
	public void init() {
		setAction(PlayerActions.WALKING_RIGHT);
	}

	int updateIndex = 0;
	@Override
	public void update(GameContainer gameContainer, int delta) {
		Input input = gameContainer.getInput();
		if(player.isAlive) {
			movements(input, delta);
			updateImmunityFrames(delta);

			if(updateIndex >= 40) {
				image = getSprite();
				updateIndex = 0;
			}
			updateIndex += delta;

			//reset Action
			if(lastAction == PlayerActions.WALKING_LEFT || lastAction == PlayerActions.JUMP_LEFT) {
				setAction(PlayerActions.STAND_LEFT);
			}else if(lastAction != PlayerActions.STAND_LEFT) {
				setAction(PlayerActions.STAND_RIGHT);
			}

			checkCollision(delta);
		}
	}

	@Override
	public void onDeath() {
		//TODO add game over screen
//		System.out.println("Player is dead");
	}

	private void updateImmunityFrames(int delta) {
		if(immunityFrames >= maxImmunity) {
			immunityFrames = maxImmunity;
		}else {
			immunityFrames += delta;
		}
	}

	private void movements(Input input, int delta) {
		if(input.isKeyDown(KEY_A) || input.isKeyDown(KEY_LEFT)) {
			moveBackward(delta);
		}else if(input.isKeyDown(KEY_D) || input.isKeyDown(KEY_RIGHT)) {
			moveForward(delta);
		}
		if(input.isKeyPressed(KEY_SPACE) || input.isKeyPressed(KEY_W) || input.isKeyPressed(KEY_UP)) {
			if(!hasJumped) {
				jump(delta);
				hasJumped = true;
			}
		}
		if(jumpIndex > 0) {
			jump(delta);
		}
	}

	//add gravity to the player and reset the jump ones you hit the ground
	@Override
	public void applyGravity(int delta) {
		super.applyGravity(delta);
		if(isGravityColliding(getGravity(delta))) {
			hasJumped = false;
		}
	}

	int jumpIndex = 0;
	boolean hasJumped = false;
	private void jump(int delta) {
		if(lastAction == PlayerActions.WALKING_LEFT) {
			setAction(PlayerActions.JUMP_LEFT);
		}else {
			setAction(PlayerActions.JUMP_RIGHT);
		}

		if(jumpIndex >= jumpHeight) {
			jumpIndex = 0;
			applyGravity = true;
		}else {
			applyGravity = false;
			y -= 0.4F * delta;
			jumpIndex += delta;
		}
	}

	private void moveBackward(int delta) {
		x -= speed * delta;
		setAction(PlayerActions.WALKING_LEFT);
	}

	private void moveForward(int delta) {
		x += speed * delta;
		setAction(PlayerActions.WALKING_RIGHT);
	}

	//TODO fix being pushed of the edges
	private void checkCollision(int delta) {
		if(isCollidingLeft()) {
			System.out.println("Collide Left");
			x += speed * delta;
		}
		if(isCollidingRight()) {
			System.out.println("Collide Right");
			x -= speed * delta;
		}
		if(isCollidingUp()) {
			System.out.println("Collide Up");
			y += speed * delta;
	}
		if(isCollidingDown()) {
			y -= speed * delta;
		}
	}


	public void damagePlayer(int amount) {
		if(immunityFrames == maxImmunity) {
			health -= amount;
			if(health <= 0) {
				health = 0;
				isAlive = false;
				System.out.println("death");
			}
			immunityFrames = 0;
			System.out.println("health = " + health);
		}
	}

	private Image getSprite() {
		Image image = null;
		if(playerId == 1) {
			image = getPlayer1Sprite();
		}
		return image;
	}

	//Get the player sprite for the current Action
	private Image getPlayer1Sprite() {
		switch(action) {
			case WALKING_RIGHT:
				return getPlayer1WalkingSprite();
			case WALKING_LEFT:
				return getPlayer1WalkingSprite().getFlippedCopy(true, false);
			case DUCK:
				return Resources.getPlayer1Sprite(Player1Sprites.DUCK);
			case HURT_RIGHT:
				return Resources.getPlayer1Sprite(Player1Sprites.HURT);
			case HURT_LEFT:
				return Resources.getPlayer1Sprite(Player1Sprites.HURT).getFlippedCopy(true, false);
			case JUMP_RIGHT:
				return Resources.getPlayer1Sprite(Player1Sprites.JUMP);
			case JUMP_LEFT:
				return Resources.getPlayer1Sprite(Player1Sprites.JUMP).getFlippedCopy(true, false);
			case FRONT:
				return Resources.getPlayer1Sprite(Player1Sprites.FRONT);
			case STAND_LEFT:
				return Resources.getPlayer1Sprite(Player1Sprites.STAND).getFlippedCopy(true, false);
			case STAND_RIGHT:
			default:
				return Resources.getPlayer1Sprite(Player1Sprites.STAND);
		}
	}

	//cycle through the walking sprites
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

	//get the defaultSprite
	private Image getDefaultSprite() {
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

	public PlayerActions getAction() {
		return action;
	}

	public void setAction(PlayerActions action) {
		this.action = action;
		this.lastAction = action;
	}
}
