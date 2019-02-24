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

    private boolean respawning;

    public Player() {
        super();
        wrapper = null;
        score = 0;
        lifeCount = 3;
    }

    public Player(PlayerWrapper wrapper, int x, int y, int width, int height, Color colour, boolean alive, int score, int lifeCount) {
        super(x, y, width, height, colour, alive);
        this.wrapper = wrapper;
        this.score = score;
        this.lifeCount = lifeCount;
    }

    public Player(Player player) {
        setLocation((int) player.getX(), (int) player.getY());
        setSize((int) player.getWidth(), (int) player.getHeight());
        setColour(player.getColour());
        setXVel(player.getXVel());
        setYVel(player.getYVel());
        setDirection(player.getDirection());
        setNextDirection(player.getNextDirection());
        setAlive(player.isAlive());
        this.wrapper = player.getWrapper();
        setScore(player.getScore());
        setLifeCount(player.getLifeCount());
    }

    /* accessors */

    public PlayerWrapper getWrapper() { return wrapper; }

    public int getScore() {
        return score;
    }

    public int getLifeCount() { return lifeCount; }

    /* mutators */

    public void setScore(int score) {
        this.score = score;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
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
                    setAlive(true);
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
