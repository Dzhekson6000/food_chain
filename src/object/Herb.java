package object;

import game.MainGame;
import game_tools.ObjectGame;

public class Herb extends ObjectGame{	
	
	public Herb(MainGame game, int x, int y) {
		super(game);
		this.x = x;
		this.y = y;
		image = game.images.getImage("plant1");		
	}
}
