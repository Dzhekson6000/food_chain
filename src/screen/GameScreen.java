package screen;

import java.util.List;

import model.Herbs;
import model.Players;
import model.World;
import framework.Screen;
import framework.Input.TouchEvent;
import game.MainGame;
import game_tools.Joystick;

public class GameScreen extends Screen {
	World world;
	Players players;
	Joystick joystick;
	Herbs herbs;
	
	float xPosition = 640;
	float yPosition = 360;
	
	public GameScreen(MainGame game) {
		super(game);
		world = new World(game);
		joystick = new Joystick(game);
		
		herbs = new Herbs(game);
		herbs.NewHerb(0, 0);
		
		players = new Players(game);
		players.NewPlayer(0, -300);
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();//получаем событие тачскрина
		game.getInput().getKeyEvents();//обновляем нажатие клавишь
        
        joystick.update(touchEvents);// обновляем джостик
        move(deltaTime);//функция движения
        
        players.update(deltaTime);
		world.updatePosition((int)xPosition, (int)yPosition);
		herbs.updatePosition((int)xPosition, (int)yPosition);
		players.updatePosition((int)xPosition, (int)yPosition);
	}

	@Override
	public void present(float deltaTime) {
		game.getGraphics().clear(0x00000000);//очищаем
		
		//рисуем
		world.draw();
		herbs.draw();
		
		players.draw();
		
		joystick.draw();
	}

	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void dispose() {	}
	
	private void move(float deltaTime){	
		//координаты перемещения
		xPosition = xPosition - ((float)joystick.getStatusX()/100 * players.MainPlayer.getSpeed()*deltaTime);
		yPosition = yPosition - ((float)joystick.getStatusY()/100 * players.MainPlayer.getSpeed()*deltaTime);
		
		//устанавливаем угол поворота
		if(joystick.getStatusX() != 0 || joystick.getStatusY() != 0)
		players.MainPlayer.setRotate( (float)(Math.atan2(joystick.getStatusY(), joystick.getStatusX())*(180/3.14)) +90 );
	}

}
