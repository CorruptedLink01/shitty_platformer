package link.corrupted.platformer.levels;

import com.google.gson.*;
import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static link.corrupted.platformer.resources.Resources.TILE_SIZE;

public class LevelLoader {

	public static final int RENDER_SIZE = (int)(TILE_SIZE * 0.7F);
	public static final float SCALE = (float)TILE_SIZE / (float)RENDER_SIZE;

	private static Image[][] background;
	private static Image[][] solids;
	private static Image[][] foreground;

	private static int height;
	private static int width;

	private boolean isBackgroundEnabled = true;
	private boolean isSolidEnabled = true;
	private boolean isForegroundEnabled = true;

	private int spawnX = 0;
	private int spawnY = 0;

	public LevelLoader(String path) {
		try {
			loadLevel(path);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void render(float xRender, float yRender) {
		int offset = 2;
		int xStart = (int)(xRender / RENDER_SIZE) - offset;
		int yStart = (int)(yRender / RENDER_SIZE) - offset;
		int xEnd = (Window.WIDTH / RENDER_SIZE) + xStart + offset * RENDER_SIZE;
		int yEnd = (Window.HEIGHT / RENDER_SIZE) + yStart + offset * RENDER_SIZE;

		for(int x = xStart; x < xEnd; x++) {
			for(int y = yStart; y < yEnd; y++) {
				if(isTileBackground(x, y) && isBackgroundEnabled) {
					background[x][y].draw(x * RENDER_SIZE, y * RENDER_SIZE, RENDER_SIZE, RENDER_SIZE);
				}
				if(isTileSolid(x, y) && isSolidEnabled) {
					solids[x][y].draw(x * RENDER_SIZE, y * RENDER_SIZE, RENDER_SIZE, RENDER_SIZE);
				}
				if(isTileForeground(x, y) && isForegroundEnabled) {
					foreground[x][y].draw(x * RENDER_SIZE, y * RENDER_SIZE, RENDER_SIZE, RENDER_SIZE);
				}
			}
		}

	}

	//load the level from the json file
	private void loadLevel(String path) throws FileNotFoundException {
		Object obj = JsonParser.parseReader(new FileReader(path));
		JsonObject jsonObj = (JsonObject)obj;

		height = jsonObj.get("height").getAsInt();
		width = jsonObj.get("width").getAsInt();

		JsonArray layers = (JsonArray)jsonObj.get("layers");

		for(int i = 0; i < layers.size(); i++) {
			JsonObject layer = (JsonObject)layers.get(i);
			String type = layer.get("name").getAsString();

			switch(type) {
				case "background":
					background = parseData(layer.getAsJsonArray("data"));
					break;
				case "solids":
					solids = parseData(layer.getAsJsonArray("data"));
					break;
				case "foreground":
					foreground = parseData(layer.getAsJsonArray("data"));
					break;
				case "objects":
					parseObjectData(layer.getAsJsonArray("objects"));
			}
		}
	}

	//parse the useful things from the objects array
	private void parseObjectData(JsonArray arr) {
		int offset = 2;
		for(int i = 0; i < arr.size(); i++) {
			JsonObject object = (JsonObject)arr.get(i);
			String type = object.get("name").getAsString();

			if(type.equals("spawn")) {
				spawnX = object.get("x").getAsInt() - offset;
				spawnY = object.get("y").getAsInt() - offset;
			}
		}
	}

	//parse the sprite data from the json array
	private Image[][] parseData(JsonArray arr) {
		Image[][] layers = new Image[width][height];
		JsonElement index;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if((y * height + x) >= arr.size()) {
					break;
				}
				index = arr.get(y * width + x);
				layers[x][y] = getSprite(index.getAsInt());
			}
		}
		return layers;
	}

	//get the Sprite from the spritesheet index
	private Image getSprite(int index) {
		if(index == 0) {
			return null;
		}
		index -= 1;

		SpriteSheet sheet = Resources.getSpriteSheet("tiles");

		int v = sheet.getVerticalCount();
		int h = sheet.getHorizontalCount();

		int x = (index % h);
		int y = (index / v);

		return Resources.getTileSprite(x, y);
	}

	private static boolean inBounds(int x, int y) {
		return (x >= 0 && y >= 0 && x < width && y < height);
	}

	public static boolean isColliding(float x, float y) {
		int xPoint = (int)((x % SCALE) / TILE_SIZE);
		int yPoint = (int)((y % SCALE) / TILE_SIZE);
		int xTile = (int)(x / RENDER_SIZE);
		int yTile = (int)(y / RENDER_SIZE);

		if(isTileSolid(xTile, yTile)) {
			return solids[xTile][yTile].getColor(xPoint, yPoint).getAlpha() > 0;
		}
		return false;
	}

	private static boolean isTileBackground(int x, int y) {
		return (inBounds(x, y) && background[x][y] != null);
	}

	private static boolean isTileSolid(int x, int y) {
		return (inBounds(x, y) && solids[x][y] != null);
	}

	private static boolean isTileForeground(int x, int y) {
		return (inBounds(x, y) && foreground[x][y] != null);
	}

	public Image[][] getBackground() {
		return background;
	}

	public Image[][] getSolids() {
		return solids;
	}

	public Image[][] getForeground() {
		return foreground;
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

	public void setBackgroundEnabled(boolean backgroundEnabled) {
		isBackgroundEnabled = backgroundEnabled;
	}

	public void setSolidEnabled(boolean areSolidsEnabled) {
		this.isSolidEnabled = areSolidsEnabled;
	}

	public void setForegroundEnabled(boolean foregroundEnabled) {
		isForegroundEnabled = foregroundEnabled;
	}

	public boolean isBackgroundEnabled() {
		return isBackgroundEnabled;
	}

	public boolean isSolidEnabled() {
		return isSolidEnabled;
	}

	public boolean isForegroundEnabled() {
		return isForegroundEnabled;
	}
}
