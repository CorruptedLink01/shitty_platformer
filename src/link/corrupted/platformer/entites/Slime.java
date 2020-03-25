package link.corrupted.platformer.entites;

import link.corrupted.platformer.levels.LevelLoader;
import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Sprites;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public class Slime extends Entity {

	private SLimeActions action;

	private float startX;
	private float maxMoveLength = 0.7F;

	public Slime(int x, int y) {
		setScaledVariables(getDefaultImage(), x, y);
		init();
	}

	@Override
	public void init() {
		image = getImage();
		action = SLimeActions.WALK_RIGHT;
		startX = x;
	}

	@Override
	public void update(GameContainer gameContainer, int delta) {
		image = getImage();
//		if(isCollidingWithBox(player)) {
//			action = SLimeActions.DYING;
//		}
		if(player.isCollidingWithBox(this)) {
			if(player.lastAction == PlayerActions.JUMP_LEFT || player.lastAction == PlayerActions.WALKING_LEFT || player.lastAction == PlayerActions.STAND_LEFT) {
				player.setAction(PlayerActions.HURT_LEFT);
			}else {
				player.setAction(PlayerActions.HURT_RIGHT);
			}
			player.damagePlayer(2);
		}

		if(isAlive) {
			move(delta);
		}
	}

	private boolean goLeft = true;
	private void move(int delta) {
		if(goLeft) {
			action = SLimeActions.WALK_LEFT;

			x += 0.1F * delta;

			if(x >= startX + LevelLoader.RENDER_SIZE * maxMoveLength) {
				goLeft = false;
			}
		}else {
			action = SLimeActions.WALK_RIGHT;

			x -= 0.1F * delta;

			if(x <= startX - LevelLoader.RENDER_SIZE * maxMoveLength) {
				goLeft = true;
			}
		}
	}

	@Override
	public void onDeath() {
		x = -1000;
		y = -1000;
	}

	int frameIndex = 0;
	int dyingIndex = 0;
	private Image getImage() {
		Image image = null;
		if(action == SLimeActions.WALK_RIGHT) {
			if(frameIndex <= 10) {
				image = Resources.getEnemyImage(Sprites.EnemySprites.SLIME_WALK1);
				frameIndex++;
			}else if(frameIndex <= 19) {
				image = Resources.getEnemyImage(Sprites.EnemySprites.SLIME_WALK2);
				frameIndex++;
			}else if(frameIndex == 20) {
				image = Resources.getEnemyImage(Sprites.EnemySprites.SLIME_WALK2);
				frameIndex = 0;
			}
		}else if(action == SLimeActions.WALK_LEFT) {
			if(frameIndex <= 10) {
				image = Resources.getEnemyImage(Sprites.EnemySprites.SLIME_WALK1).getFlippedCopy(true, false);
				frameIndex++;
			}else if(frameIndex <= 19) {
				image = Resources.getEnemyImage(Sprites.EnemySprites.SLIME_WALK2).getFlippedCopy(true, false);
				frameIndex++;
			}else if(frameIndex == 20) {
				image = Resources.getEnemyImage(Sprites.EnemySprites.SLIME_WALK2).getFlippedCopy(true, false);
				frameIndex = 0;
			}
		}else if(action == SLimeActions.DYING) {
			image = Resources.getEnemyImage(Sprites.EnemySprites.SLIME_DEAD);
			dyingIndex++;
			if(dyingIndex == 20) {
				isAlive = false;
				dyingIndex = 0;
			}
		}
		return image;
	}

	private Image getDefaultImage() {
		return Resources.getEnemyImage(Sprites.EnemySprites.SLIME_WALK1);
	}

	protected enum SLimeActions {
		WALK_LEFT,
		WALK_RIGHT,
		DYING;
	}
}
