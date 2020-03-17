package link.corrupted.platformer.states;

public enum States {
	MENU(0),
	OPTION(1),
	LEVEL_SELECT(2),
	LEVEL(3);

	private int id;

	States(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
