package mob;

import game.MainGame;
import object.Player;

public class Clam extends Player{
	
	boolean rot = false;
	int rot_direction = 1;
	int count = 0;
	
	public Clam(MainGame game) {
		super(game);
		this.ImageUrl = "player";
		status = "move";
		this.speed = 100;
	}
	
	public void next_frame(){
		if(status.equals("move")){
			if(count == 0){
				rot_direction = 1;
			} else
			if(count == 1){
				if(rot && rot_direction == 1){
					count = 4;
				}
			} else
			if(count == 3){
				if(rot){
					rot_direction = 1;
					count = 0;
					rot = false;
				} else {
					rot = true;
					rot_direction = -1;
				}
				
			} else
			if(count == 6){
				rot_direction = -1;
			}
			
			image = game.images.getImage(ImageUrl, count);
			count+=rot_direction;
		}
	}
}
