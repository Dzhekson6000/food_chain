package framework;

import android.app.Activity;

public interface Game {

    public Graphics getGraphics();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();
    
    public Activity getActivity();
    
    public Screen getStartScreen();
    
    public Input getInput();
}
