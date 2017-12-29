package rltut;

import java.util.logging.*;

public class PlayerAi extends CreatureAi {
	
	private static Logger logger = Logger.getLogger("rltut.PlayerAi");
	
	public PlayerAi(Creature creature){
		super(creature);
	}
	
	public void onEnter(int x, int y, Tile tile) {
		if (tile.isGround()) {
			logger.fine("Moving to ground tile "+x+":"+y);
			creature.x=x;
			creature.y=y;
		} else if (tile.isDiggable()) {
			logger.fine("Digging "+x+":"+y);
			creature.dig(x, y);
		}
	}

}
