package link.corrupted.platformer.levels;

import link.corrupted.platformer.resources.Resources;
import link.corrupted.platformer.resources.Resources.ResourceFolders;
import link.corrupted.platformer.util.Window;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Level1 {

	private TiledMap level;

	private String foreground;
	private String solids;
	private String background;

	public void init() throws SlickException {
		LevelLoader loader = new LevelLoader(ResourceFolders.LEVELS + "/level1.tmx", ResourceFolders.TILES);
		foreground = loader.getForeground();
		solids = loader.getSolids();
		background = loader.getBackground();
		level = loader.getLevel();
	}

	public void renderLevel(Graphics graphics) {
		Resources.getImage("background").draw(0, 0, Window.WIDTH, Window.HEIGHT);
		graphics.scale(0.8F, 0.8F);
		level.render(0, 0);
		graphics.resetTransform();
	}
}
