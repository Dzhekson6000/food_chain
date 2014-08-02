package game_tools;

import java.util.List;

import android.graphics.Color;
import framework.Input.TouchEvent;
import game.MainGame;

public class Joystick {
	MainGame game;
	int xPostion, yPostion, radius, buttonRadius, centerX, centerY;
	boolean status_click = false;
	int pointer_click = -1;
	int deviationX = 0;
	int deviationY = 0;
	
	int buttonAttackRadius, xPositionAttack, yPositionAttack;
	boolean status_click_attack = false;
	int pointer_click_attack = -1;
	
	public Joystick(MainGame game){
		this.game = game;
		radius = 100;
		buttonRadius = 20;
		centerX = radius + 10;
		centerY = game.getGraphics().getHeight()-radius-10;
		xPostion = radius + 10;
		yPostion = game.getGraphics().getHeight()-radius-10;
		
		buttonAttackRadius = 50;
		xPositionAttack = 1220;
		yPositionAttack = 400;
		
	}
	
	public void draw(){
		game.getGraphics().drawCircle(centerX, centerY, radius, Color.BLUE);
		game.getGraphics().drawCircle(xPostion, yPostion, buttonRadius, Color.GRAY);
		game.getGraphics().drawCircle(xPositionAttack, yPositionAttack, buttonAttackRadius, Color.RED);
	}
	
	public void update(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		TouchEvent event;
		
        for(int i = 0; i < len; i++) {
        	event = touchEvents.get(i);
        	if(event.type == TouchEvent.TOUCH_DOWN && pointer_click == -1) {//нажатие
        		if(distance(event.x, event.y, centerX, centerY) < radius){
        			status_click = true;
        			pointer_click = event.pointer;
        		}
        		
        	}
        	if(event.type == TouchEvent.TOUCH_UP && event.pointer == pointer_click) {//отпускание
        		status_click = false;
        		xPostion = centerX;
        		yPostion = centerY;
        		deviationX = 0;
        		deviationY = 0;
        		pointer_click = -1;
        	}
        	
        	if(status_click && event.pointer == pointer_click){
        		if(distance(event.x, event.y, centerX, centerY) > radius){
        			xPostion = (int) ((event.x - centerX) * radius /
        					distance(event.x, event.y, centerX, centerY) + centerX);
        			yPostion = (int) ((event.y - centerY) * radius /
        					distance(event.x, event.y, centerX, centerY) + centerY);
        		} else {
        			xPostion = event.x;
        			yPostion = event.y;
        		}
        		deviationX = xPostion - centerX;
        		deviationY = yPostion - centerY;
        	} else if(event.pointer == pointer_click){
        		deviationX = 0;
        		deviationY = 0;
        	}
        }
        
        for(int i = 0; i < len; i++) {
        	event = touchEvents.get(i);
        	if(event.type == TouchEvent.TOUCH_DOWN && pointer_click_attack == -1) {//нажатие
        		if(distance(event.x, event.y, xPositionAttack, yPositionAttack) < buttonAttackRadius){
        			//нажатие на кнопку
        			status_click_attack = true;
        			pointer_click_attack = event.pointer;
        		}
        	}
        	
        	if(event.type == TouchEvent.TOUCH_UP && event.pointer == pointer_click_attack) {//отпускание
        		status_click_attack = false;
        		pointer_click_attack = -1;
        	}
        	
        }
	}
	
	public int getStatusX(){
		return deviationX;
	}
	
	public int getStatusY(){
		return deviationY;
	}
	
	public boolean getStatusAttack(){
		return status_click_attack;
	}
	
	private double distance(int x, int y, int centerX, int centerY){
		return Math.sqrt((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY));
		
	}
}
