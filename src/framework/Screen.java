package framework;

import game.MainGame;

public abstract class Screen {
	protected final MainGame game;

    public Screen(MainGame game) {
        this.game = game;
    }

    public abstract void update(float deltaTime);

    public abstract void present(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();
}
