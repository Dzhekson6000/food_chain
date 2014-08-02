package game;

import framework.Graphics;
import framework.Input;
import framework.Screen;
import framework.Game;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainGame extends Activity implements Game{
	public ImagesContainer images;
	
	Screen screen;
	Graphics graphics;
	RenderView renderView;
	Input input;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        int frameBufferWidth = isLandscape ? 1280 : 720;
        int frameBufferHeight = isLandscape ? 720 : 1280;
        
        @SuppressWarnings({ "deprecation" })
		float scaleX = (float) frameBufferWidth
                / getWindowManager().getDefaultDisplay().getWidth();
        @SuppressWarnings({ "deprecation" })
		float scaleY = (float) frameBufferHeight
                / getWindowManager().getDefaultDisplay().getHeight();
        
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Config.ARGB_8888);
        renderView = new RenderView(this, frameBuffer);
        graphics = new GraphicsGame(this.getApplicationContext(), frameBuffer);
        
        input = new InputGame(this, renderView, scaleX, scaleY);
        
        images = new ImagesContainer(this);
        
        screen = getStartScreen();
        
        setContentView(renderView);
	}
	
	public Screen getCurrentScreen() {
        return screen;
    }

	public Graphics getGraphics() {
		return graphics;
	}

	public void setScreen(Screen screen) {
		this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;		
	}

	public Screen getStartScreen() {
		return null;
	}

	public Activity getActivity() {
		return (Activity) this;
	}
	
	public void onResume() {
        super.onResume();
        screen.resume();
        renderView.resume();
    }
	
	public void onPause() {
        super.onPause();
        renderView.pause();
        screen.pause();

        if (isFinishing())
            screen.dispose();
    }
	
	public Input getInput() {
        return input;
    }
}
