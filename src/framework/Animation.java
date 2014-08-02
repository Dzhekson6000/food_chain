package framework;

import game.MainGame;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;

public class Animation {
	ArrayList<Pixmap> Images = new ArrayList<Pixmap>();
	MainGame game;
	
	public Animation(MainGame game, Pixmap pixmap, int a, int b) {
		this.game = game;
		
		int Width = pixmap.getWidth()/a;
		int Height = pixmap.getHeight()/b;
		
		Bitmap image = pixmap.getBitmap();
		
		Bitmap FrameImage = Bitmap.createBitmap(Width, Height, Config.ARGB_8888);
		Rect src = new Rect();
	    Rect dst = new Rect();
	    
        dst.left = 0;
        dst.top = 0;
        dst.right = Width-1;
        dst.bottom = Height-1;
        
        for(int i=0; i < b; i++){
        	for(int j=0; j < a; j++){
        	int x = Width * j;
        	int y = Height * i;
        	src.left = x;
        	src.top = y;
        	src.right = x + Width - 1;
        	src.bottom = y + Height - 1;
        	
        	Canvas canvas = new Canvas(FrameImage);
        	canvas.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
    		canvas.drawBitmap(image , src, dst, new Paint());
    		AddImages(FrameImage);
        	}
        }
        FrameImage.recycle();
        image.recycle();
	}
	
	public Pixmap getPixmapAnim(int id){
		return Images.get(id);
	}
	
	private void AddImages(Bitmap bmp){
		Images.add(game.getGraphics().newPixmap(Bitmap.createBitmap(bmp)));
	}

	
	
	
	
}
