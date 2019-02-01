package block;

import java.awt.Rectangle;
import java.awt.Color;

public abstract class Block extends Rectangle {
    private Color colour;
    private boolean isSolid;

    public Block() {
        super();
        colour = Color.BLUE;
        isSolid = false;
    }
    public Block(int x, int y, int width, int height, Color colour, boolean isSolid) {
        super(x, y, width, height);
        this.colour = colour;
        this.isSolid = isSolid;
    }

    /**
     * Gets the colour of this Block.
     * @return the colour of this block
     */
    public Color getColour() {
        return colour;
    }

    public boolean getIsSolid() {
        return isSolid;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setIsSolid(boolean isSolid) {
        this.isSolid = isSolid;
    }
}
