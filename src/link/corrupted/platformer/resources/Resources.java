package link.corrupted.platformer.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;
import java.util.Map;

import static link.corrupted.platformer.resources.Resources.ResourceFolders.*;

public class Resources {

	private static Map<String, SpriteSheet> sprites;
	private static Map<String, Image> images;

	public Resources() {
		sprites = new HashMap<>();
		images = new HashMap<>();

		try {
			images.put("background", loadImage(RESOURCE.getPath() + "/bg.png"));
			images.put("castleBackground", loadImage(RESOURCE.getPath() + "/bg_castle.png"));

			sprites.put("player1", loadSprite(PLAYER.getPath() + "/p1_spritesheet.png", 72, 97));
			sprites.put("tiles", loadSprite(TILES.getPath() + "/tiles_spritesheet.png", 72, 72));
			sprites.put("small_tiles", loadSprite(TILES.getPath() + "/small_tiles_spritesheet.png", 5, 24));
		}catch(SlickException e) {
			e.printStackTrace();
		}

	}

	private Image loadImage(String path) throws SlickException {
		return new Image(path, false, Image.FILTER_NEAREST);
	}

	private SpriteSheet loadSprite(String path, int width, int heigth) throws SlickException {
		return new SpriteSheet(loadImage(path), width, heigth);
	}

	public static Image getImage(String name) {
		return images.get(name);
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

	protected enum ResourceFolders {
		RESOURCE("resources"),
		PLAYER("resources/Player"),
		ENEMIES("resources/Enemies"),
		TILES("resources/Tiles"),
		ITEMS("resources/Items");

		private String path;

		ResourceFolders(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}
	}

}
