package entity;

import block.Block;

import java.awt.*;

public abstract class Entity extends Rectangle {

    private Color colour;
    private int xVel;
    private int yVel;

    // Blocks surrounding this Entity
    // 0 = TOP
    // 1 = LEFT
    // 2 = DOWN
    // 3 = RIGHT
    private Block[] blocks = new Block[4];

    public Entity() {
        super();
        colour = Color.YELLOW;
        xVel = 0;
        yVel = 0;
    }

    public Entity(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height);
        this.colour = colour;
        xVel = 0;
        yVel = 0;
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

    /* other methods */

    public void updatePosition() {
        setLocation((int)getX() + xVel, (int)getY() + yVel);
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

    public void intersect(Entity entity) {
        intersects(entity);
    }
}
