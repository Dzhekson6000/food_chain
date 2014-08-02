package game_tools;

import framework.Pixmap;
import game.MainGame;

public class ObjectGame {
	private boolean destroyed = false;
	public int x;
	public int y;
	public int positionX;
	public int positionY;
	public int width;
	public int height;
	public float rotate;
	public float scaleX = 1;
	public float scaleY = 1;
	public Pixmap image;
	public MainGame game;
	public int strength = 1;
	
	public int positionX_player;
	public int positionY_player;

	public ObjectGame(MainGame game){
		this.game = game;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getRotate() {
		return rotate;
	}

	public void setRotate(float rotate) {
		this.rotate = rotate;
	}

	public float getScaleX() {
		return scaleX;
	}

	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	public void updatePosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getPositionX_player() {
		return positionX_player;
	}

	public void setPositionX_player(int positionX_player) {
		this.positionX_player = positionX_player;
	}

	public int getPositionY_player() {
		return positionY_player;
	}

	public void setPositionY_player(int positionY_player) {
		this.positionY_player = positionY_player;
	}
	
	
	public void update(float deltaTime){
		if(strength <= 0)this.destroyed = true;
	}
	
	public void updateAI(float deltaTime) {
		
	}

	public void draw(){
		if(image == null){
			return;
		}
		if(width == 0){
			width = image.getWidth();
		}
		if(height == 0){
			height = image.getHeight();
		}
		game.getGraphics().drawPixmap(
				image,
				positionX + x,
				positionY + y,
				width,
				height,
				(int)(width*scaleX),
				(int)(height*scaleY),
				rotate
				);
	}
	
}
