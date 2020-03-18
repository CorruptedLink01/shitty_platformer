package link.corrupted.platformer.entites;

import link.corrupted.platformer.levels.LevelLoader;
import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites.Player1Sprites;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public class Player extends Entity {

	private final int MAX_SPEED = 50;
	private int playerId;

	public Player(int playerId, int x, int y) {
		this.playerId = playerId;
		init();
		//fixme
		this.x = (x * LevelLoader.SCALE) - width;
		this.y = (y * LevelLoader.SCALE) - height;
	}

	@Override
	public void init() {
		width = getFirstSprite().getWidth() * LevelLoader.SCALE;
		height = getFirstSprite().getHeight() * LevelLoader.SCALE;
		setAction(Actions.WALKING);
	}

	int speed = 0;
	@Override
	public void update(GameContainer gameContainer, int delta) {

		System.out.println(delta);

		if(speed >= MAX_SPEED) {
			image = getSprite();
			speed = 0;
			//x += 10 + delta;
		}
		speed+=delta;
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
			case DUCK:
				return Resources.getPlayer1Sprite(Player1Sprites.DUCK);
			case HURT:
				return Resources.getPlayer1Sprite(Player1Sprites.HURT);
			case JUMP:
				return Resources.getPlayer1Sprite(Player1Sprites.JUMP);
			case FRONT:
				return Resources.getPlayer1Sprite(Player1Sprites.FRONT);
			case STAND:
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
}
