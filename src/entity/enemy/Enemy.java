package entity.enemy;

import entity.Entity;

import java.awt.*;

public abstract class Enemy extends Entity {

    private EnemyWrapper wrapper;
    private boolean isAlive;

    public Enemy() {
        super();
        wrapper = null;
        isAlive = true;
    }

    public Enemy(EnemyWrapper wrapper, int x, int y, int width, int height, Color colour, boolean isAlive) {
        super(x, y, width, height, colour);
        this.wrapper = wrapper;
        this.isAlive = isAlive;
    }

    /* accessors */

    public EnemyWrapper getWrapper() {
        return wrapper;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    /* mutators */

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
