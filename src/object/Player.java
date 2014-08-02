package object;

import android.util.Log;
import game.MainGame;
import game_tools.ObjectGame;

public class Player extends ObjectGame {
	float Time = 0;
	
	public int speed = 100;//скорость пикселей в секунду.
	public String ImageUrl;
	public String status;
	public boolean AI = true;
	
	public Player(MainGame game) {
		super(game);
		this.ImageUrl = "player";
		setWidth(57);
		setHeight(85);
		image = game.images.getImage(ImageUrl, 0);
	}
	
	public void updateAI(float deltaTime){
		if(!AI)return;
		//пытаемся убить игрока
		
		//находим растояние до игрока что бы атаковать
		
		//подходим к игроку ближе
		
		double angle = Math.atan2(positionY_player - y, positionX_player - x);
		
		x= x + (int)((speed)*deltaTime * Math.cos(angle));
		y= y + (int)((speed)*deltaTime * Math.sin(angle));
	}
	
	public void next_frame(){
		image = game.images.getImage(ImageUrl, 0);
	}
	
	public void update(float deltaTime) {
		Time+= deltaTime;
		if(Time > 0.2)
		{
			next_frame();
			Time = 0;
		}
		
		updateAI(deltaTime);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
