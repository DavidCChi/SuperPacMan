package entity;

import block.Block;

import java.awt.*;

public abstract class Entity extends Rectangle {

    private Color colour;
    private int xVel;
    private int yVel;
    private int direction;

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
        surroundBlocks = new Block[4];
    }

    public Entity(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height);
        this.colour = colour;
        xVel = 0;
        yVel = 0;
        direction = 0;
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
        direction = 0;
    }

    public void moveLeft() {
        xVel = -1;
        yVel = 0;
        direction = 1;
    }

    public void moveDown() {
        xVel = 0;
        yVel = 1;
        direction = 2;
    }

    public void moveRight() {
        xVel = 1;
        yVel = 0;
        direction = 3;
    }

    public boolean willIntersect(Rectangle rec) {
        // gets next position
        Rectangle next = new Rectangle((int)getX() + getXVel(), (int)getY() + getYVel(), (int)getWidth(), (int)getHeight());
        return next.intersects(rec);
    }
}
