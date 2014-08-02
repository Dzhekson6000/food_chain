package model;

import game.MainGame;
import game_tools.ObjectGame;

public class World extends ObjectGame {
	
	public World(MainGame game){
		super(game);
		image = game.images.getImage("fon_herb");
		this.width = image.getWidth();
		this.height = image.getHeight();
	}
	
	@Override
	public void draw(){
		
		int xConteiner = (int) (positionX - (width * Math.floor(positionX/ width)));
		int yConteiner = (int) (positionY - (height * Math.floor(positionY/ height)));

		for(int i = -1; i <= game.getGraphics().getWidth()/width+1; i++){
			for(int j = -1; j <= game.getGraphics().getHeight()/height+1; j++){
				game.getGraphics().drawPixmap( image,
						width*i + xConteiner,
						height*j + yConteiner,
						image.getWidth(),
						image.getHeight(),
						image.getWidth(),
						image.getHeight(),
						0
						);
			}
		}
	}
	
	

}
