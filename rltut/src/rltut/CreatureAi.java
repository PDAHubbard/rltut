package rltut;

public class CreatureAi {

	protected Creature creature;
	
	public CreatureAi(Creature creature) {
		this.creature=creature;
		this.creature.setCreatureAi(this);
	}
	
	
	public void onEnter(int x, int y, Tile tile) {}


	public void onUpdate() {}


	public boolean canEnter(int x2, int y2) {
		return true;
	}
}
