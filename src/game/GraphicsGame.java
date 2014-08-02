package game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import framework.Graphics;
import framework.Pixmap;

public class GraphicsGame implements Graphics {
	private Bitmap frameBuffer;
	private Canvas canvas;
	private Context context;
	Matrix matrix = new Matrix();
	Paint paint = new Paint();
	
	
	public GraphicsGame(Context context, Bitmap frameBuffer){
		this.frameBuffer = frameBuffer;
		this.canvas = new Canvas(frameBuffer);
		this.context = context;
	}
	
	//создаём пиксмам из ресурсов игры
	public Pixmap newPixmap(int id) {
		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), id);
		return new PixmapGame(bmp);
	}
	
	//создаём пиксмам из каритнки
	public Pixmap newPixmap(Bitmap bmp) {
		return new PixmapGame(bmp);
	}

	public void clear(int color) {
		canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,(color & 0xff));
	}
	
	//рисуем с поворотом
	public void drawPixmap(Pixmap pixmap, int x, int y, int Width, int Height, int newWidth, int newHeight, float rotate) {
		float scaleX = (float) newWidth / (float) Width;
	    float scaleY = (float) newHeight / (float) Height;

	    matrix.reset();
	    
		matrix.postScale(scaleX, scaleY);//масштабируем
		matrix.postTranslate(x, y);//задаём координаты
		
		if(rotate != 0)matrix.preRotate(rotate, Width/2, Height/2);//поворачиваем относительно цетра
		
		
        canvas.drawBitmap( ((PixmapGame) pixmap).getBitmap(), matrix, null);
    }
	
	public void drawCircle(int x, int y, int radius, int color) {
        Paint paint = new Paint();
		paint.setColor(color);
        canvas.drawCircle(x, y, radius, paint);
    }
	
	public void drawRect(Rect r, int color){
		paint.reset();
		paint.setColor(color);
		canvas.drawRect(r, paint);
	}
	
	//получаем ширину экрана
	public int getWidth() {
		return frameBuffer.getWidth();
	}
	
	//получаем высоту экрана
	public int getHeight() {
		return frameBuffer.getHeight();
	}

}
