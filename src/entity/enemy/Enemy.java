package entity.enemy;

import entity.Entity;

import java.awt.*;

public abstract class Enemy extends Entity {

    private boolean isAlive;

    public Enemy() {
        super();
    }

    public Enemy(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height, colour);
    }
}
