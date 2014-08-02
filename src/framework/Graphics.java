package framework;

import android.graphics.Bitmap;
import android.graphics.Rect;

public interface Graphics {
	public static enum PixmapFormat {
        ARGB8888, ARGB4444, RGB565
    }

    public Pixmap newPixmap(int id);
    
    public Pixmap newPixmap(Bitmap bmp);

    public void clear(int color);

    public void drawPixmap(Pixmap pixmap, int x, int y, int Width, int Height, int newWidth, int newHeight, float rotate);
    
    public void drawCircle(int x, int y, int radius, int color);
    
    public void drawRect(Rect r, int color);
    
    public int getWidth();

    public int getHeight();

    
}
