package link.corrupted.platformer.levels;

import link.corrupted.platformer.entites.Entity;
import link.corrupted.platformer.entites.Player;
import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.Image;

import java.util.ArrayList;

public abstract class AbstractLevel {

	private String name;
	private String jsonName;
	private String background;
	private Image backgroundImage;
	private ArrayList<Entity> entities = new ArrayList<>();

	private int spawnX;
	private int spawnY;
	private int height;
	private int width;

	private Entity player;

	private LevelLoader loader;

	public AbstractLevel(String name, String jsonName, String background) {
		this.name = name;
		this.jsonName = jsonName;
		this.background = background;
	}

	public void enter() {
		player = new Player(1, getSpawnX(), getSpawnY());
		entities.add(player);
	}

	public void init() {
		loader = new LevelLoader(Resources.ResourceFolders.LEVELS + "/" + jsonName + ".json");
		height = loader.getHeight();
		width = loader.getWidth();
		spawnX = loader.getSpawnX();
		spawnY = loader.getSpawnY();
		backgroundImage = Resources.getImage(background);
	}

	public void render(float playerX, float playerY) {
		for(int x = -backgroundImage.getWidth(); x < backgroundImage.getWidth() / (width * 0.5F); x++) {
			for(int y = 0; y < backgroundImage.getHeight() / height; y++) {
				backgroundImage.draw(x * backgroundImage.getWidth(), y * backgroundImage.getHeight(), backgroundImage.getWidth(), backgroundImage.getHeight());
			}
		}
		loader.render(playerX - Window.WIDTH, playerY - Window.HEIGHT / 2);
	}

	public abstract void update();

	public String getName() {
		return name;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
}
