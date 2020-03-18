package link.corrupted.platformer.levels;

import link.corrupted.platformer.resources.Resources;
import org.newdawn.slick.Image;

public class Level {

	private String name;
	private String jsonName;
	private String background;
	private Image backgroundImage;

	private int height;
	private int width;

	private int spawnX;
	private int spawnY;

	private LevelLoader loader;

	public Level(String name, String jsonName, String background) {
		this.name = name;
		this.jsonName = jsonName;
		this.background = background;
	}

	public void init() {
		loader = new LevelLoader(Resources.ResourceFolders.LEVELS + "/" + jsonName + ".json");
		height = loader.getHeight();
		width = loader.getWidth();
		spawnX = loader.getSpawnX();
		spawnY = loader.getSpawnY();
		backgroundImage = Resources.getImage(background);
	}

	public void render() {


		for(int x = 0; x < backgroundImage.getWidth() / width; x++) {
			for(int y = 0; y < backgroundImage.getHeight() / height; y++) {
				backgroundImage.draw(x * backgroundImage.getWidth(), y * backgroundImage.getHeight(), backgroundImage.getWidth(), backgroundImage.getHeight());
			}
		}
		loader.render(0, 0);

	}

	public void update() {

	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}
}
