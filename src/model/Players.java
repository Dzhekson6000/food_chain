package model;

import java.util.ArrayList;

import mob.*;

import object.Player;
import game.MainGame;

public class Players {
	MainGame game;
	ArrayList<Player> players = new ArrayList<Player>();
	public Player MainPlayer;
	
	//местонахождение игрока
	int positionX;
	int positionY;
	
	public Players(MainGame game){
		this.game = game;
		MainPlayer = new Barbel(game);
		MainPlayer.AI = false;
		MainPlayer.setX(game.getGraphics().getWidth()/2);
		MainPlayer.setY(game.getGraphics().getHeight()/2);
	}
	
	public void NewPlayer(int x, int y){
		Barbel newBarbel = new Barbel(game);
		newBarbel.setX(x);
		newBarbel.setY(y);
		players.add(newBarbel);
	}
	
	public void draw(){
		for(int i = 0; i < players.size(); i++){
			players.get(i).draw();
		}
		MainPlayer.draw();
	}
	
	public void update(float deltaTime) {
		for(int i = 0; i < players.size(); i++){
			players.get(i).update(deltaTime);
		}
		MainPlayer.update(deltaTime);
	}
	
	public void updatePosition(int positionX, int positionY) {
		this.positionX = positionX - 640;
		this.positionY = positionY - 360;
		
		for(int i = 0; i < players.size(); i++){
			players.get(i).updatePosition(positionX, positionY);
			players.get(i).setPositionX_player(this.positionX);
			players.get(i).setPositionY_player(this.positionY);
		}
	}
}
