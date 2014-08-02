package screen;

import framework.Screen;
import game.MainGame;

public class main extends MainGame {
	public Screen getStartScreen() {
        return new Logo( this );
    }
}
