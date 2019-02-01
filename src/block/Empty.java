package block;

import block.Block;

import java.awt.*;

public class Empty extends Block {

    public static final Color colour = Color.BLACK;

    public Empty() {
        super();
    }

    public Empty(int x, int y, int width, int height) {
        super(x, y, width,  height, colour, false);
    }

}
