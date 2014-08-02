package object;

import game.MainGame;

public class Food {
	public int positionX;
	public int positionY;
	
	int xPostion, yPostion = 0;
	
	public boolean destroyed = false;
	
	int Width;
	int Height;
	
	public int tip;
	
	public Food(int positionX, int positionY, int tip, int Width, int Height){
		this.positionX = positionX;
		this.positionY = positionY;
		
		this.Width = Width;
		this.Height = Height;
		
		this.tip = tip;
	}
	
	public void Draw(MainGame game){
		//game.getGraphics().drawPixmap( game.images.getImage(tip), positionX + xPostion , positionY + yPostion);
	}
	
	public void updatePostion(int xPostion, int yPostion) {
		this.xPostion = xPostion;
		this.yPostion = yPostion;
		if(inBounds()){
			destroyed = true;
		}
	}
	
	private boolean inBounds() {
        if(1280/2 > positionX + xPostion && 1280/2 < positionX + xPostion + Width - 1 &&
        		720/2 > positionY + yPostion && 720/2 < positionY + yPostion + Height - 1)
            return true;
        else
            return false;
    }
}
