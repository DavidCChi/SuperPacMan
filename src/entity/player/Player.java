package entity.player;

import entity.Entity;

import java.awt.*;

public abstract class Player extends Entity {

    private int lifeCount;
    private boolean isAlive;

    public Player() {
        super();
        lifeCount = 3;
        isAlive = true;
    }

    public Player(int x, int y, int width, int height, Color colour, int lifeCount, boolean isAlive) {
        super(x, y, width, height, colour);
        this.lifeCount = lifeCount;
        this.isAlive = true;
    }
}
