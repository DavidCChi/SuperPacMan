package entity.enemy;

import block.Block;

import java.awt.Color;

public class EnemyWrapper {

    private Enemy enemy;

    public EnemyWrapper() {
        enemy = null;
    }

    public EnemyWrapper(int x, int y, int width, int height, Color colour, boolean isAlive) {
        enemy = new DefaultEnemy(this, x, y , width, height, colour, isAlive);
    }

    public EnemyWrapper(Enemy enemy) {
        this.enemy = enemy;
    }

    /* accessors */

    public Enemy getEnemy() {
        return enemy;
    }

    /* mutators */

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    /* implement Enemy methods */

    /* from Rectangle */
    public int getX() { return (int) enemy.getX(); }

    public int getY() { return (int) enemy.getY(); }

    /* from Entity */
    public Color getColour() { return enemy.getColour(); }

    public int getXVel() { return enemy.getXVel(); }

    public int getYVel() {return enemy.getYVel(); }

    public int getDirection() { return enemy.getDirection(); }

    public int getNextDirection() { return enemy.getNextDirection(); }

    public Block getSurroundBlocks(int x) { return enemy.getSurroundBlocks(x); }

    public void setColour(Color colour) { enemy.setColour(colour); }

    public void setXVel(int xVel) { enemy.setXVel(xVel); }

    public void setYVel(int yVel) { enemy.setYVel(yVel); }

    public void setDirection(int direction) { enemy.setDirection(direction); }

    public void setNextDirection(int nextDirection) { enemy.setNextDirection(nextDirection); }

    public void setSurroundBlocks(int x, Block block) { enemy.setSurroundBlocks(x, block); }

    public void updatePosition() { enemy.updatePosition(); }

    public void moveUp() { enemy.moveUp(); }

    public void moveLeft() { enemy.moveLeft(); }

    public void moveDown() { enemy.moveDown(); }

    public void moveRight() { enemy.moveRight(); }

    /* from Enemy */
    public EnemyWrapper getWrapper() { return enemy.getWrapper(); }

    public boolean getIsAlive() { return enemy.getIsAlive(); }

    public void setIsAlive(boolean isAlive) { enemy.setIsAlive(isAlive); }
}
