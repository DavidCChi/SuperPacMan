package block;

import java.awt.Rectangle;
import java.awt.Color;

public abstract class Block extends Rectangle {
    private Color colour;

    public Block() {
        super();
        colour = Color.BLUE;
    }
    public Block(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height);
        this.colour = colour;
    }

    /**
     * Gets the colour of this Block.
     * @return the colour of this block
     */
    public Color getColour() {
        return colour;
    }
}
