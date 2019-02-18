package entity.player;

import entity.Entity;
import entity.enemy.Enemy;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Player extends Entity {
    private PlayerWrapper wrapper;
    private int score;
    private int lifeCount;
    private boolean isAlive;

    private boolean respawning;

    public Player() {
        super();
        wrapper = null;
        score = 0;
        lifeCount = 3;
        isAlive = true;
    }

    public Player(PlayerWrapper wrapper, int x, int y, int width, int height, Color colour, int score, int lifeCount, boolean isAlive) {
        super(x, y, width, height, colour);
        this.wrapper = wrapper;
        this.score = score;
        this.lifeCount = lifeCount;
        this.isAlive = isAlive;
    }

    public Player(Player player) {
        setLocation((int) player.getX(), (int) player.getY());
        setSize((int) player.getWidth(), (int) player.getHeight());
        setColour(player.getColour());
        setXVel(player.getXVel());
        setYVel(player.getYVel());
        setDirection(player.getDirection());
        setNextDirection(player.getNextDirection());
        this.wrapper = player.getWrapper();
        setScore(player.getScore());
        setLifeCount(player.getLifeCount());
        setIsAlive(player.getIsAlive());
    }

    /* accessors */

    public PlayerWrapper getWrapper() { return wrapper; }

    public int getScore() {
        return score;
    }

    public int getLifeCount() { return lifeCount; }

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
        if (!isAlive) {
            setColour(Color.BLACK);
        } else {
            setColour(getDefaultColour());
        }
    }

    /* other methods */

    public void incrementScore(int increment) {
        score += increment;
    }

    public boolean respawn(int x, int y) {
        if (respawning) return true;
        if (lifeCount > 0) {
            Timer timer = new Timer("Respawn");
            timer.schedule(new TimerTask() {
                public void run() {
                    setLocation(x, y);
                    setNextDirection(Entity.STOP);
                    setIsAlive(true);
                    respawning = false;
                }
            }, 3000);
            respawning = true;
            return true;
        } else {
            return false;
        }
    }

    public abstract void collide(Enemy enemy);
}
