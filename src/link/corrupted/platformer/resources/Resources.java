package link.corrupted.platformer.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;
import java.util.Map;

import static link.corrupted.platformer.resources.Resources.ResourceFolders.*;

public class Resources {

	public static final int TILE_SIZE = 70;

	private static Map<String, SpriteSheet> sprites;
	private static Map<String, Image> images;

	public Resources() {
		sprites = new HashMap<>();
		images = new HashMap<>();

		try {
			images.put("background", loadImage(RESOURCE + "/bg.png"));
			images.put("castleBackground", loadImage(RESOURCE + "/bg_castle.png"));

			sprites.put("player1", loadSprite(PLAYER + "/p1_spritesheet.png", 72, 97));
			sprites.put("tiles", loadSprite(TILES + "/tiles_spritesheet.png", TILE_SIZE, TILE_SIZE));
			sprites.put("small_tiles", loadSprite(TILES + "/small_tiles_spritesheet.png", 5, 24));
		}catch(SlickException e) {
			e.printStackTrace();
		}

	}

	private Image loadImage(String path) throws SlickException {
		return new Image(path, false, Image.FILTER_NEAREST);
	}

	private SpriteSheet loadSprite(String path, int width, int height) throws SlickException {
		return new SpriteSheet(loadImage(path), width, height);
	}

	public static Image getImage(String name) {
		return images.get(name);
	}

	public static SpriteSheet getSpriteSheet(String name) {
		return sprites.get(name);
	}

	public static Image getPlayer1Sprite(Sprites.Player1Sprites sprite) {
		return getSprite("player1", sprite.getX(), sprite.getY());
	}

	public static Image getTileSprite(Sprites.TileSprites sprite) {
		return getSprite("tiles", sprite.getX(), sprite.getY());
	}

	public static Image getSmallTileSprite(Sprites.SmallTileSprites sprite) {
		return getSprite("small_tiles", sprite.getX(), sprite.getY());
	}

	public static Image getSprite(String name, int x, int y) {
		return sprites.get(name).getSubImage(x, y);
	}

	public static class ResourceFolders {
		public static final String RESOURCE ="resources";
		public static final String PLAYER = "resources/player";
		public static final String ENEMIES = "resources/enemies";
		public static final String TILES = "resources/tiles";
		public static final String ITEMS = "resources/items";
		public static final String LEVELS = "resources/levels";

	}

}
