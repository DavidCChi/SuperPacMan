package entity.enemy;

import entity.Entity;

import java.awt.*;

public abstract class Enemy extends Entity {

    private EnemyWrapper wrapper;

    public Enemy() {
        super();
        wrapper = null;
    }

    public Enemy(EnemyWrapper wrapper, int x, int y, int width, int height, Color colour, boolean alive) {
        super(x, y, width, height, colour, alive);
        this.wrapper = wrapper;
    }

    /* accessors */

    public EnemyWrapper getWrapper() {
        return wrapper;
    }

    /* mutators */

}
