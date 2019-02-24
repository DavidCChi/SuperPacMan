package entity.player;

import block.Block;
import entity.BlockVisitable;
import entity.enemy.Enemy;
import java.awt.*;

public class PlayerWrapper implements BlockVisitable {
    private Player player;

    public PlayerWrapper() {
        player = null;
    }

    public PlayerWrapper(int x, int y, int width, int height, Color colour, boolean alive, int score, int lifeCount) {
        player = new DefaultPlayer(this, x, y, width, height, colour, alive, score, lifeCount);
    }

    public PlayerWrapper(Player player) {
        this.player = player;
    }

    /* accessors */

    public Player getPlayer() {
        return player;
    }

    /* mutators */

    public void setPlayer(Player player) {
        this.player = player;
    }

    /* implement Player methods */

    /* from Rectangle */
    public int getX() { return (int) player.getX(); }

    public int getY() { return (int) player.getY(); }

    public void setLocation(int x, int y) { player.setLocation(x, y); }

    /* from Entity */
    public Color getColour() { return player.getColour(); }

    public int getXVel() { return player.getXVel(); }

    public int getYVel() {return player.getYVel(); }

    public int getDirection() { return player.getDirection(); }

    public int getNextDirection() { return player.getNextDirection(); }

    public boolean isAlive() { return player.isAlive(); }

    public Block getSurroundBlocks(int x) { return player.getSurroundBlocks(x); }

    public void setColour(Color colour) { player.setColour(colour); }

    public void setXVel(int xVel) { player.setXVel(xVel); }

    public void setYVel(int yVel) { player.setYVel(yVel); }

    public void setDirection(int direction) { player.setDirection(direction); }

    public void setNextDirection(int nextDirection) { player.setNextDirection(nextDirection); }

    public void setAlive(boolean alive) { player.setAlive(alive); }

    public void setSurroundBlocks(int x, Block block) { player.setSurroundBlocks(x, block); }

    public void updatePosition() { player.updatePosition(); }

    public void moveUp() { player.moveUp(); }

    public void moveLeft() { player.moveLeft(); }

    public void moveDown() { player.moveDown(); }

    public void moveRight() { player.moveRight(); }

    /* from Player */
    public int getScore() { return player.getScore(); }

    public int getLifeCount() { return player.getLifeCount(); }

    public void setScore(int score) { player.setScore(score); }

    public void setLifeCount(int lifeCount) { player.setLifeCount(lifeCount); }

    public void incrementScore(int increment) { player.incrementScore(increment); }

    public boolean respawn(int x, int y) { return player.respawn(x, y); }

    /* from BlockVisitable */
    public void collide(Block block) { player.collide(block); }

    public void collide(Enemy enemy) { player.collide(enemy); }
}
