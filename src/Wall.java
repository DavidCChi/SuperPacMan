import java.awt.Color;

public class Wall extends Block {
    public Wall() {
        super();
    }

    public Wall(int x, int y, int width, int height) {
        super(x, y, width,  height, Color.BLUE);
    }
}
