package link.corrupted.platformer.main;

import link.corrupted.platformer.util.Window;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Engine("Platformer"));
			container.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
			container.start();
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
