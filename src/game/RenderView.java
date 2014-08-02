package game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class RenderView extends SurfaceView implements Runnable {
	private MainGame game;
	private SurfaceHolder holder;
	private boolean running = false;
	Thread renderThread = null;
	Bitmap framebuffer;
	
	public RenderView(Context context) {
	    super(context);
	}
	
	public RenderView(MainGame game, Bitmap framebuffer) {
		super(game);
        this.game = game;
        this.holder = getHolder();
        this.framebuffer = framebuffer;
	}

	public void run() {
		Rect dstRect = new Rect();
		long startTime = System.nanoTime();
		while(running) {
            if(!holder.getSurface().isValid())
                continue;
            
            float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;
            startTime = System.nanoTime();

            game.getCurrentScreen().update(deltaTime);
            game.getCurrentScreen().present(deltaTime);
            
            Canvas canvas = holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(framebuffer, null, dstRect, null); 
            holder.unlockCanvasAndPost(canvas);
        }
	}
	
	
	public void resume() {
        running = true;
        renderThread = new Thread(this);
        renderThread.start();
    }
	
	public void pause() {
        running = false;
        while(true) {
            try {
                renderThread.join();
                break;
            } catch (InterruptedException e) {
                // retry
            }
        }
    }
}
