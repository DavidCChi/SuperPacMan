import javax.swing.*;

public class Game {
    /* constants */
    public static final int WIDTH = 1005;
    public static final int HEIGHT = 1005;

    /* instance fields */
    private JFrame frame;


    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }

    public Game() {
        frame = new JFrame("Super Pac-Man");
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Initializes the Game with a Screen.
     */
    public void init() {
        frame.add(new Screen());
    }

    /**
     * Moves this Game to the next state.
     */
    public void tick() {

    }
}
