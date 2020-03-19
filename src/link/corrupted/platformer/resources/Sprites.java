package link.corrupted.platformer.resources;

public class Sprites {

	/**
	 * Don't ask, just don't
	 * I don't wanna talk about it
	 */

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


	public enum TileSprites implements ISpriteEnum {
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
		STONE(2, 9),
		SNOW_RIGHT(2, 10),
		SNOW_MID(2, 11),
		SNOW_LEFT(2, 12),
		BRICK_WALL(3, 0),
		BRIDGE(3, 1),
		SNOW_HILL_RIGHT2(3, 2),
		SNOW_HILL_RIGHT(3, 3),
		SNOW_HILL_LEFT2(3, 4),
		SNOW_HILL_LEFT(3, 5),
		SNOW_HALF_RIGHT(3, 6),
		SNOW_HALF_MID(3, 7),
		SNOW_HALF_LEFT(3, 8),
		SNOW_HALF(3, 9),
		SNOW_CLIFF_RIGHT_ALT(3, 10),
		SNOW_CLIFF_RIGHT(3, 11),
		SNOW_CLIFF_LEFT_ALT(3, 12),
		SNOW_CLIFF_LEFT(4, 0),
		SNOW_CENTER_ROUNDED(4, 1),
		SNOW(4, 2),
		SIGN_RIGHT(4, 3),
		SIGN_LEFT(4, 4),
		SIGN_EXIT(4, 5),
		SIGN(4, 6),
		SAND_RIGHT(4, 7),
		SAND_MID(4, 8),
		SAND_LEFT(4, 9),
		BRIDE_LOGS(4, 10),
		CASTLE(4, 11),
		SAND_HILL_RIGHT2(4, 12),
		SAND_HILL_RIGHT(5, 0),
		SAND_HILL_LEFT2(5, 1),
		SAND_HILL_LEFT(5, 2),
		SAND_HALF_RIGHT(5, 3),
		SAND_HALF_MID(5, 4),
		SAND_HALF_LEFT(5, 5),
		SAND_HALF(5, 6),
		SAND_CLIFF_RIGHT_ALT(5, 7),
		SAND_CLIFF_RIGHT(5, 8),
		SAND_CLIFF_LEFT_ALT(5, 9),
		SAND_CLIFF_LEFT(5, 10),
		SAND(5, 11),
		ROPE_VERTICAL(5, 12),
		ROPE_HORIZONTAL(6, 0),
		ROPE_ATTACHED(6, 1),
		ROCK_HILL_RIGHT(6, 2),
		ROCK_HILL_LEFT(6, 3),
		LOCK_YELLOW(6, 4),
		LOCK_RED(6, 5),
		BOX_ITEM_ALT_DISABLED(6, 6),
		LOCK_BLUE(6, 7),
		LIQUID_WATER_TOP_MID(6, 8),
		LIQUID_WATER_TOP(6, 9),
		CASTLE_HALF_LEFT(6, 10),
		LIQUID_LAVA_TOP_MID(6, 11),
		LIQUID_LAVA_TOP(6, 12),
		LIQUID_LAVA(7, 0),
		LADDER_TOP(7, 1),
		LADDER_MID(7, 2),
		LIQUID_WATER(7, 3),
		CASTLE_CENTER(7, 4),
		DIRT_MID(7, 5),
		DIRT_LEFT(7, 6),
		GRASS_RIGHT(7, 7),
		GRASS_MID(7, 8),
		GRASS_LEFT(7, 9),
		CASTLE_CENTER_ROUNDED(7, 10),
		CASTLE_CLIFF_LEFT(7, 11),
		GRASS_HILL_RIGHT2(7, 12),
		GRASS_HILL_RIGHT(8, 0),
		GRASS_HILL_LEFT2(8, 1),
		GRASS_HILL_LEFT(8, 2),
		GRASS_HALF_RIGHT(8, 3),
		GRASS_HALF_MID(8, 4),
		GRASS_HALF_LEFT(8, 5),
		GRASS_HALF(8, 6),
		GRASS_CLIFF_RIGHT_ALT(8, 7),
		GRASS_CLIFF_RIGHT(8, 8),
		GRASS_CLIFF_LEFT_ALT(8, 9),
		GRASS_CLIFF_LEFT(8, 10),
		SAND_CENTER_ROUNDED(8, 11),
		GRASS_CENTER(8, 12),
		GRASS(9, 0),
		FENCE_BROKEN(9, 1),
		FENCE(9, 2),
		DOOR_OPEN_TOP(9, 3),
		DOOR_OPEN_MID(9, 4),
		DOOR_CLOSED_TOP(9, 5),
		DOOR_CLOSED_MID(9, 6),
		DIRT_RIGHT(9, 7),
		CASTLE_HILL_LEFT(9, 8),
		CASTLE_HALF_MID(9, 9),
		CASTLE_CLIFF_LEFT_ALT(9, 10),
		CASTLE_CLIFF_RIGHT(9, 11),
		DIRT_HILL_RIGHT2(9, 12),
		DIRT_HILL_RIGHT(10, 0),
		DIRT_HILL_LEFT2(10, 1),
		DIRT_HILL_LEFT(10, 2),
		DIRT_HALF_RIGHT(10, 3),
		DIRT_HALF_MID(10, 4),
		DIRT_HALF_LEFT(10, 5),
		DIRT_HALF(10, 6),
		DIRT_CLIFF_RIGHT_ALT(10, 7),
		DIRT_CLIFF_RIGHT(10, 8),
		DIRT_CLIFF_LEFT_ALT(10, 9),
		DIRT_CLIFF_LEFT(10, 10),
		DIRT_CENTER_ROUNDED(10, 11),
		DIRT_CENTER(10, 12),
		DIRT(11, 0),
		CASTLE_RIGHT(11, 1),
		CASTLE_MID(11, 2),
		CASTLE_LEFT(11, 3),
		CASTLE_CLIFF_RIGHT_ALT(11, 4),
		CASTLE_HALF(11, 5),
		CASTLE_HILL_RIGHT2(11, 6),
		CASTLE_HILL_RIGHT(11, 7),
		CASTLE_HILL_LEFT2(11, 8),
		CASTLE_HALF_RIGHT(11, 9),
		HILL_SMALL_ALT_TOP(11, 10),
		HILL_SMALL_ALT_BOTTOM(11, 11),
		HILL_LARGE_ALT_TOP(12, 0),
		HILL_LARGE_ALT_BOTTOM(12, 1),
		HILL_SMALL_TOP(12, 2),
		HILL_SMALL_BOTTOM(12, 3),
		HILL_LARGE_TOP(12, 4),
		HILL_LARGE_BOTTOM(12, 5);

		private int x;
		private int y;

		TileSprites(int x, int y) {
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

	public enum SmallTileSprites implements ISpriteEnum {
		CASTLE_LEDGE_RIGHT(0, 0),
		CASTLE_LEDGE_LEFT(1, 0),
		GRASS_LEDGE_RIGHT(2, 0),
		GRASS_LEDGE_LEFT(3, 0),
		DIRT_LEDGE_RIGHT(0, 1),
		DIRT_LEDGE_LEFT(1, 1),
		SAND_LEDGE_RIGHT(2, 1),
		SAND_LEDGE_LEFT(3, 1),
		SNOW_LEDGE_RIGHT(0, 2),
		SNOW_LEDGE_LEFT(1, 2),
		STONE_LEDGE_RIGHT(2, 2),
		STONE_LEDGE_LEFT(3, 2);

		private int x;
		private int y;

		SmallTileSprites(int x, int y) {
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
