package block;

import java.awt.Color;

public class Wall extends Block {

    public static final Color colour = Color.BLUE;

    public Wall() {
        super();
    }

    public Wall(int x, int y, int width, int height) {
        super(x, y, width,  height, colour);
    }
}
