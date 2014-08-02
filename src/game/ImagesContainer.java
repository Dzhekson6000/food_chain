package game;

import java.util.HashMap;
import java.util.Map;

import com.example.foodchain.R;

import framework.Animation;
import framework.Pixmap;


public class ImagesContainer {
	MainGame game;
	Map<String, Pixmap> Images = new HashMap<String, Pixmap>();
	Map<String, Animation> ImagesAnimation = new HashMap<String, Animation>();
	
	public ImagesContainer(MainGame game){
		this.game = game;
		loadImages();
	}
	
	public Pixmap getImage(String key){//получаем изображение
		if(!Images.containsKey(key)) return null;
		return Images.get(key);
	}
	
	public Pixmap getImage(String key, int id_frame){//получаем анимированое изображение
		if(!ImagesAnimation.containsKey(key)) return null;
		return ImagesAnimation.get(key).getPixmapAnim(id_frame);
	}
	
	private void loadImages(){//загружаем все изображения
		NewImage("studio_korona",R.drawable.studio_korona);
		NewImage("menu_fon",R.drawable.menu_fon);
		NewImage("menu_button_play",R.drawable.menu_button_play);
		NewImage("fon_herb",R.drawable.fon_herb);
		NewImage("plant",R.drawable.plant);
		NewImage("plant1",R.drawable.plant1);
		NewImage("plant2",R.drawable.plant2);
		NewImage("food",R.drawable.food);
		NewImage("island1",R.drawable.island1);
		NewImage("island2",R.drawable.island2);
		NewImage("island3",R.drawable.island3);
		
		NewAnimation("player", R.drawable.player, 7, 2);
		NewAnimation("barbel", R.drawable.barbel, 3, 1);
	}
	
	private void NewImage(String key, int id){
		Images.put(key, game.getGraphics().newPixmap(id));
	}
	
	private void NewAnimation(String key, int id,int a,int b){
		ImagesAnimation.put(key, new Animation(game, game.getGraphics().newPixmap(id), a, b));
	}
}
