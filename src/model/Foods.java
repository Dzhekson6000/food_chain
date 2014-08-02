package model;

import game.MainGame;

import java.util.ArrayList;

import object.Food;

public class Foods {
	MainGame game;
	ArrayList<Food> food = new ArrayList<Food>();
	int xPostion, yPostion = 0;
	
	public Foods(MainGame game){
		this.game = game;
	}
	
	public void NewFood(int x, int y, int tip){
		//food.add(new Food(x, y, tip, game.images.getImage(tip).getWidth(), game.images.getImage(tip).getHeight()));
	}
	
	public void draw(){
		for(int i = 0; i < food.size(); i++){
			food.get(i).Draw(game);
		}
	}
	
	public void updatePostion(int xPostion, int yPostion) {
		this.xPostion = xPostion;
		this.yPostion = yPostion;
		
		for(int i = 0; i < food.size(); i++){
			food.get(i).updatePostion(xPostion, yPostion);
		}
		
		for(int i = 0; i < food.size(); i++){
			if(food.get(i).destroyed){
				food.remove(i);
			}
		}
	}
}
