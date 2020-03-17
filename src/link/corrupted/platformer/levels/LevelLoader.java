package link.corrupted.platformer.levels;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class LevelLoader {

	private TiledMap level;

	private String foreground;
	private String solids;
	private String background;

	public LevelLoader(String levelPath, String tilePath) throws SlickException {
		this.level = loadLevel(levelPath, tilePath);
		setLevelContent();
	}

	private void setLevelContent() {
		foreground = level.getLayerProperty(0, "foreground", "foreground");
		solids = level.getLayerProperty(1, "solids", "solids");
		background = level.getLayerProperty(2, "background", "background");
	}

	private TiledMap loadLevel(String levelPath, String tilePath) throws SlickException {
		return new TiledMap(levelPath, tilePath);
	}

	public TiledMap getLevel() {
		return level;
	}

	public String getForeground() {
		return foreground;
	}

	public String getSolids() {
		return solids;
	}

	public String getBackground() {
		return background;
	}
}
