package model;

import java.util.ArrayList;

import object.Herb;

import game.MainGame;

public class Herbs {
	MainGame game;
	ArrayList<Herb> herbs = new ArrayList<Herb>();
	
	public Herbs(MainGame game){
		this.game = game;
	}
	
	public void NewHerb(int x, int y){
		herbs.add(new Herb(game, x, y));
	}
	
	public void draw(){
		for(int i = 0; i < herbs.size(); i++){
			herbs.get(i).draw();
		}
	}
	
	public void updatePosition(int positionX, int positionY) {
		for(int i = 0; i < herbs.size(); i++){
			herbs.get(i).updatePosition(positionX, positionY);
		}
	}
}
