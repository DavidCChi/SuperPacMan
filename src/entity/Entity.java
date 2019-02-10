package entity;

import block.Block;

import java.awt.*;

public abstract class Entity extends Rectangle implements BlockVisitable {

    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int STOP = -1;

    private Color colour;
    private int xVel;
    private int yVel;
    private int direction;
    private int nextDirection;

    // Blocks surrounding this Entity
    // 0 = TOP
    // 1 = LEFT
    // 2 = DOWN
    // 3 = RIGHT
    private Block[] surroundBlocks;

    public Entity() {
        super();
        colour = Color.YELLOW;
        xVel = 0;
        yVel = 0;
        direction = 0;
        nextDirection = STOP;
        surroundBlocks = new Block[4];
    }

    public Entity(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height);
        this.colour = colour;
        xVel = 0;
        yVel = 0;
        direction = 0;
        nextDirection = STOP;
        surroundBlocks = new Block[4];
    }

    /* accessors */

    public Color getColour() {
        return colour;
    }

    public int getXVel() {
        return xVel;
    }

    public int getYVel() {
        return yVel;
    }

    public int getDirection() {
        return direction;
    }

    public int getNextDirection() {
        return nextDirection;
    }

    public Block getSurroundBlocks(int x) {
        return surroundBlocks[x];
    }

    /* mutators */

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setXVel(int xVel) {
        this.xVel = xVel;
    }

    public void setYVel(int yVel) {
        this.yVel = yVel;
    }

    public void setDirection(int direction) {
        this.direction = direction;
        switch (direction) {
            case UP:
                moveUp();
                break;
            case LEFT:
                moveLeft();
                break;
            case DOWN:
                moveDown();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    public void setNextDirection(int nextDirection) {
        this.nextDirection = nextDirection;
        if (nextDirection == STOP) {
            setXVel(0);
            setYVel(0);
        }
    }

    public void setSurroundBlocks(int x, Block block) {
        surroundBlocks[x] = block;
    }

    /* other methods */

    public void updatePosition() {
        int newX = (int)getX() + xVel;
        int newY = (int)getY() + yVel;
        if (newX < 0) newX = 0;
        if (newY < 0) newY = 0;
        setLocation(newX, newY);
    }

    public void moveUp() {
        xVel = 0;
        yVel = -1;
    }

    public void moveLeft() {
        xVel = -1;
        yVel = 0;
    }

    public void moveDown() {
        xVel = 0;
        yVel = 1;
    }

    public void moveRight() {
        xVel = 1;
        yVel = 0;
    }
}
