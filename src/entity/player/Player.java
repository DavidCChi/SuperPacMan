package entity.player;

import entity.Entity;

import java.awt.*;

public abstract class Player extends Entity {

    private int score;
    private int lifeCount;
    private boolean isAlive;

    public Player() {
        super();
        lifeCount = 3;
        isAlive = true;
    }

    public Player(int x, int y, int width, int height, Color colour, int score, int lifeCount, boolean isAlive) {
        super(x, y, width, height, colour);
        this.lifeCount = lifeCount;
        this.isAlive = true;
    }

    /* accessors */

    public int getScore() {
        return score;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    /* mutators */

    public void setScore(int score) {
        this.score = score;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /* other methods */

    public void incrementScore(int increment) {
        score += increment;
    }
}
