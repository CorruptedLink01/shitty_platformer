package link.corrupted.platformer.resources;

public class Sprites {

	public enum Player1 implements ISpriteEnum {
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
		;

		private int x;
		private int y;

		Player1(int x, int y) {
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
