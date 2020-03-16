package link.corrupted.platformer.states;

import org.newdawn.slick.state.BasicGameState;

public abstract class LinksGameState extends BasicGameState {

	private States state;

	public LinksGameState(States state) {
		this.state = state;
	}

	@Override
	public int getID() {
		return state.getId();
	}

}
