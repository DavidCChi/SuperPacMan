package entity.player;

import block.Block;
import entity.BlockVisitable;
import java.awt.*;

public class PlayerWrapper implements BlockVisitable {
    private Player player;

    public PlayerWrapper() {
        player = null;
    }

    public PlayerWrapper(int x, int y, int width, int height, Color colour, int score, int lifeCount, boolean isAlive) {
        player = new DefaultPlayer(this, x, y, width, height, colour, score, lifeCount, isAlive);
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

    /* from Entity */
    public Color getColour() { return player.getColour(); }

    public int getXVel() { return player.getXVel(); }

    public int getYVel() {return player.getYVel(); }

    public int getDirection() { return player.getDirection(); }

    public int getNextDirection() { return player.getNextDirection(); }

    public Block getSurroundBlocks(int x) { return player.getSurroundBlocks(x); }

    public void setColour(Color colour) { player.setColour(colour); }

    public void setXVel(int xVel) { player.setXVel(xVel); }

    public void setYVel(int yVel) { player.setYVel(yVel); }

    public void setDirection(int direction) { player.setDirection(direction); }

    public void setNextDirection(int nextDirection) { player.setNextDirection(nextDirection); }

    public void setSurroundBlocks(int x, Block block) { player.setSurroundBlocks(x, block); }

    public void updatePosition() { player.updatePosition(); }

    public void moveUp() { player.moveUp(); }

    public void moveLeft() { player.moveLeft(); }

    public void moveDown() { player.moveDown(); }

    public void moveRight() { player.moveRight(); }

    /* from Player */
    public int getScore() { return player.getScore(); }

    public int getLifeCount() { return player.getLifeCount(); }

    public boolean getIsAlive() { return player.getIsAlive(); }

    public void setScore(int score) { player.setScore(score); }

    public void setLifeCount(int lifeCount) { player.setLifeCount(lifeCount); }

    public void setIsAlive(boolean isAlive) { player.setIsAlive(isAlive); }

    public void incrementScore(int increment) { player.incrementScore(increment); }

    /* from BlockVisitable */
    public void collide(Block block) { player.collide(block); }
}
