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

	private Image[][] background;
	private Image[][] solids;
	private Image[][] foreground;

	private int height;
	private int width;
	
	private boolean isBackgroundEnabled = true;
	private boolean isSolidEnabled = true;
	private boolean isForegroundEnabled = true;

	public LevelLoader(String path) {
		try {
			loadLevel(path);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void render(float xRender, float yRender) {

		int offset = 2;
		int xStart = (int)(xRender / TILE_SIZE) - offset;
		int yStart = (int)(yRender / TILE_SIZE) - offset;
		int xEnd = (Window.WIDTH / TILE_SIZE) + xStart + offset * 2;
		int yEnd = (Window.HEIGHT / TILE_SIZE) + yStart + offset * 2;

		for(int x = xStart; x < xEnd; x++) {
			for(int y = yStart; y < yEnd; y++) {
				if(isTileBackground(x, y) && isBackgroundEnabled) {
					background[x][y].draw(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
				if(isTileSolid(x, y) && isSolidEnabled) {
					solids[x][y].draw(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
				if(isTileForeground(x, y) && isForegroundEnabled) {
					foreground[x][y].draw(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
			}
		}

	}

	private void loadLevel(String path) throws FileNotFoundException {
		Object obj = JsonParser.parseReader(new FileReader(path));
		JsonObject jsonObj = (JsonObject)obj;

		height = jsonObj.get("height").getAsInt();
		width = jsonObj.get("width").getAsInt();

		JsonArray layers = (JsonArray)jsonObj.get("layers");

		int amount = layers.size();

		for(int i = 0; i < amount; i++) {
			JsonObject layer = (JsonObject)layers.get(i);
			String type = layer.get("name").getAsString();

			switch(type) {
				case "background":
					background = parse(layer.get("data").getAsJsonArray());
					break;
				case "solids":
					solids = parse(layer.get("data").getAsJsonArray());
					break;
				case "foreground":
					foreground = parse(layer.get("data").getAsJsonArray());
					break;
			}

		}

	}

	private Image[][] parse(JsonArray arr) {
		Image[][] layers = new Image[width][height];

		JsonElement index;
		for(int y = 0; y < width; y++) {
			for(int x = 0; x < height; x++) {
				if((y * width + x) >= arr.size()) {
					break;
				}
				index = arr.get(y * width + x);
				layers[x][y] = getSprite(index.getAsInt());
			}
		}
		return layers;
	}


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

		return sheet.getSubImage(x, y);
	}

	private boolean inBounds(int x, int y) {
		return (x >= 0 && y >= 0 && x < width && y < height);
	}

	private boolean isTileBackground(int x, int y) {
		return (inBounds(x, y) && background[x][y] != null);
	}

	private boolean isTileSolid(int x, int y) {
		return (inBounds(x, y) && solids[x][y] != null);
	}

	private boolean isTileForeground(int x, int y) {
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
