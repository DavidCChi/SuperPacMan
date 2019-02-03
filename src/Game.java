import javax.swing.*;

import java.util.concurrent.*;

public class Game {
    /* constants */
    public static final int WIDTH = 510;
    public static final int HEIGHT = 530;
    public static final int FPS = 60;

    /* instance fields */
    private JFrame frame;
    private Screen screen;


    public static void main(String[] args) {
        Game game = new Game();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                game.tick();
            }
        }, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
    }

    public Game() {
        frame = new JFrame("Super Pac-Man");
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen = new Screen();
        screen.requestFocus();
        frame.add(screen);
        frame.setVisible(true);
    }

    /**
     * Moves this Game to the next state.
     */
    public void tick() {
        screen.tick();
    }
}
