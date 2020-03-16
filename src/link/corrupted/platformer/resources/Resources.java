package link.corrupted.platformer.resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;
import java.util.Map;

import static link.corrupted.platformer.resources.Resources.ResourceFolders.*;

public class Resources {

	private static Map<String, SpriteSheet> sprites;

	public Resources() {
		sprites = new HashMap<>();


		try {
			sprites.put("player1", loadSprite(PLAYER.getPath() + "/p1_spritesheet.png", 72, 97));
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

	public static Image getPlayer1Sprite(Sprites.Player1 sprite) {
		return getSprite("player1", sprite.getX(), sprite.getY());
	}

	public static Image getSprite(String name, int x, int y) {
		return sprites.get(name).getSubImage(x, y);
	}

	protected enum ResourceFolders {
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
