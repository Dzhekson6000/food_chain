package screen;

import framework.Pixmap;
import framework.Screen;
import game.MainGame;

public class Logo extends Screen{
	private boolean changes = true;
	private float timeHasPassed = 0;
	
	public Logo(MainGame game) {
		super(game);
	}

	public void update(float deltaTime) {
		timeHasPassed+=deltaTime;
		if(timeHasPassed > 0){
			game.setScreen(new Menu(game));
		}
	}
	
	private void DrawLogo(){
		game.getGraphics().clear(0x00000000);
		Pixmap image = game.images.getImage("studio_korona");
		game.getGraphics().drawPixmap( image ,
				game.getGraphics().getWidth() / 2 - image.getWidth(),
				game.getGraphics().getHeight() / 2 - image.getHeight(),
				image.getWidth(),
				image.getHeight(),
				image.getWidth()*2,
				image.getHeight()*2,
				0
				);
		changes = false;
	}

	public void present(float deltaTime) {
		if( this.changes )
			this.DrawLogo();
	}

	public void pause() {

	}

	public void resume() {

	}

	public void dispose() {

	}

}
