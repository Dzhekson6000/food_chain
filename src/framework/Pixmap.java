package framework;

import android.graphics.Bitmap;



public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public void dispose();
    
    public Bitmap getBitmap();
}