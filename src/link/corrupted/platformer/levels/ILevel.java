package link.corrupted.platformer.levels;

public interface ILevel {

	void init();
	void render();
	void update();

	String getName();
	int getSpawnX();
	int getSpawnY();

}
