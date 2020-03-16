package link.corrupted.platformer.resources;

public class Sprites {

	public enum Player1Sprites implements ISpriteEnum {
		WALK1(0, 0),
		WALK2(1, 0),
		WALK3(2, 0),
		WALK4(0, 1),
		WALK5(1, 1),
		WALK6(2, 1),
		WALK7(3, 0),
		WALK8(4, 0),
		WALK9(3, 1),
		WALK10(5, 0),
		WALK11(4, 1),
		DUCK(5, 1),
		FRONT(0, 2),
		HURT(6, 0),
		JUMP(6, 1),
		STAND(1, 2);


		private int x;
		private int y;

		Player1Sprites(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int getX() {
			return x;
		}

		@Override
		public int getY() {
			return y;
		}
	}


	public enum TilesSprites implements ISpriteEnum {
		BOX_ITEM_ALT(0, 0),
		BOX_ITEM_DISABLED(0, 1),
		BOX_ITEM(0, 2),
		BOX_EXPLOSIVE_ALT(0, 3),
		BOX_EXPLOSIVE_DISABLED(0, 4),
		BOX_EXPLOSIVE(0, 5),
		BOX_EMPTY(0, 6),
		BOX_COIN_ALT_DISABLED(0, 7),
		BOX_COIN_ALT(0, 8),
		BOX_COIN_DISABLED(0, 9),
		BOX_COIN(0, 10),
		BOX_ALT(0, 11),
		BOX(0, 12),
		WINDOW(1, 0),
		TORCH(1, 1),
		TORCH_LIT2(1, 2),
		TORCH_LIT1(1, 3),
		STONE_WALL(1, 4),
		STONE_RIGHT(1, 5),
		STONE_MID(1, 6),
		STONE_LEFT(1, 7),
		LOCK_GREEN(1, 8),
		BOX_WARNING(1, 9),
		STONE_HILL_RIGHT2(1, 10),
		STONE_HILL_LEFT2(1, 11),
		STONE_HALF_RIGHT(1, 12),
		STONE_HALF_MID(2, 0),
		STONE_HALF_LEFT(2, 1),
		STONE_HALF(2, 2),
		STONE_CLIFF_RIGHT_ALT(2, 3),
		STONE_CLIFF_RIGHT(2, 4),
		STONE_CLIFF_LEFT_ALT(2, 5),
		STONE_CLIFF_LEFT(2, 6),
		STONE_CENTER_ROUNDED(2, 7),
		STONE_CENTER(2, 8),
		STONE(2, 9)

		;

		//0 72 144 216 288 360 432 504 576 648 720 792 864
		//0  1  2   3   4   5   6   7   8   9  10  11  12

		private int x;
		private int y;

		TilesSprites(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int getX() {
			return x;
		}

		@Override
		public int getY() {
			return y;
		}
	}



	private interface ISpriteEnum {
		int getX();
		int getY();
	}

}
