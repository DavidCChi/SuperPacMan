package block;

import entity.player.DefaultPlayer;
import entity.enemy.DefaultEnemy;

import java.awt.Rectangle;
import java.awt.Color;

interface EntityVisitor {
    void collide(DefaultPlayer player);
    void collide(DefaultEnemy enemy);
}

public abstract class Block extends Rectangle implements EntityVisitor {
    private Color colour;

    public Block() {
        super();
        colour = Color.BLUE;
    }
    public Block(int x, int y, int width, int height, Color colour) {
        super(x, y, width, height);
        this.colour = colour;
    }

    /* accessors */
    public Color getColour() {
        return colour;
    }

    /* mutators */
    public void setColour(Color colour) {
        this.colour = colour;
    }
}
