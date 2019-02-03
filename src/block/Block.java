package block;

import entity.player.DefaultPlayer;

import java.awt.Rectangle;
import java.awt.Color;

interface EntityVisitor {
    void collide(DefaultPlayer player);
}

public abstract class Block extends Rectangle implements EntityVisitor {
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

    /* accessors */
    public Color getColour() {
        return colour;
    }

    public boolean getIsSolid() {
        return isSolid;
    }

    /* mutators */
    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void setIsSolid(boolean isSolid) {
        this.isSolid = isSolid;
    }
}
