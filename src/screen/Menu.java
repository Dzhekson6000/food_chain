package screen;

import java.util.List;

import framework.Input.TouchEvent;
import framework.Pixmap;
import framework.Screen;
import game.MainGame;

public class Menu extends Screen {
	private boolean changes = true;
	private int menu_select = 0;
	
	public Menu(MainGame game) {
		super(game);
		
	}
	
	public void drawMenu() {
		game.getGraphics().clear(0x00000000);//очищаем
		Pixmap image = game.images.getImage("menu_fon");
		game.getGraphics().drawPixmap( image ,
				0,
				0,
				image.getWidth(),
				image.getHeight(),
				game.getGraphics().getWidth(),
				game.getGraphics().getHeight(),
				0
				);
		if(menu_select != 0){
			image = game.images.getImage("menu_button_play");
			game.getGraphics().drawPixmap( image ,
					10,
					610,
					image.getWidth(),
					image.getHeight(),
					100,
					100,
					0
					);
		}
		if(menu_select == 1){
			image = game.images.getImage("island1");
			game.getGraphics().drawPixmap( image,
					0,
					0,
					image.getWidth(),
					image.getHeight(),
					game.getGraphics().getWidth(),
					game.getGraphics().getHeight(),
					0
					);
		} else if(menu_select == 2){
			image = game.images.getImage("island2");
			game.getGraphics().drawPixmap( image,
					0,
					0,
					image.getWidth(),
					image.getHeight(),
					game.getGraphics().getWidth(),
					game.getGraphics().getHeight(),
					0
					);
		} else if(menu_select == 3){
			image = game.images.getImage("island3");
			game.getGraphics().drawPixmap( image,
					0,
					0,
					image.getWidth(),
					image.getHeight(),
					game.getGraphics().getWidth(),
					game.getGraphics().getHeight(),
					0
					);
		}
		
		changes = false;
	}

	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();//получаем событие тачскрина
		game.getInput().getKeyEvents();//обновляем нажатие клавишь
		
		int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
        	TouchEvent event = touchEvents.get(i);
        	if(event.type == TouchEvent.TOUCH_UP) {
        		//проверяем нажатие на острова
        		if(inBounds(event, 200, 295, 550, 205) ) {
        			menu_select = 1;
        			changes = true;//перерисовываем
                }
        		if(inBounds(event, 850, 380, 250, 210) ) {
        			menu_select = 2;
        			changes = true;//перерисовываем
                }
        		if(inBounds(event, 415, 590, 513, 95) ) {
        			menu_select = 3;
        			changes = true;//перерисовываем
                }
        		
        		if(inBounds(event, 10, 610, 100, 100) ) {
                    game.setScreen(new GameScreen(game));
                    return;
                }
        	}
        }
	}
	
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 &&
           event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

	public void present(float deltaTime) {
		if( this.changes )
			this.drawMenu();
	}

	public void pause() {
		
	}

	public void resume() {
		
	}

	public void dispose() {
		
	}

}
