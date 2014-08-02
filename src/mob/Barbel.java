package mob;

import game.MainGame;
import object.Player;

public class Barbel extends Player{
	
	boolean rot = false;
	int rot_direction = 1;
	int count = 0;
	
	public Barbel(MainGame game) {
		super(game);
		this.ImageUrl = "barbel";
		status = "move";
		image = game.images.getImage(ImageUrl, count);
	}
	
	public void next_frame(){
		if(status.equals("move")){
			count = 0;
			image = game.images.getImage(ImageUrl, count);
		}
		if(status.equals("attack")){
			if(count != 1 || count != 2)count = 1;else
			if(count == 1){
				if(rot)
				{
					status = "move";
					rot = false;
				}
				else
				{
					count = 2;
				}
			}else{
			if(count == 2)
				if(rot){
					count = 1;
				} else {
					rot = false;
				}
			}
			image = game.images.getImage(ImageUrl, count);
		}
	}

}
