import block.*;
import entity.player.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Screen extends JPanel {

    public static final int DIM = 20;

    private Block[][] grid = new Block[25][25];
    private Player player = new DefaultPlayer(50, 50, DIM, DIM, Color.YELLOW, 3, true);

    public Screen() {
        super();
        setFocusable(true);
        addKeyListener(new KeyListen());
        init();
    }

    /**
     * Populates this screen.
     */
    public void init() {
        for (int y = 0; y < 25; ++y) {
            for (int x = 0; x < 25; ++x) {
                if (x == 0 || x == 24 || y == 0 || y == 24) {
                    grid[y][x] = new Wall(x * DIM, y * DIM, DIM, DIM);
                } else {
                    grid[y][x] = new Empty(x * DIM, y * DIM, DIM, DIM);
                }
            }
        }
    }

    /**
     * Paints this Screen.
     * @param g
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        for (int y = 0; y < 25; ++y) {
            for (int x = 0; x < 25; ++x) {
                g2d.setColor(grid[y][x].getColour());
                g2d.fill(grid[y][x]);
            }
        }
        player.updatePosition();
        g2d.setColor(player.getColour());
        g2d.fill(player);
    }

    private class KeyListen implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                player.moveUp();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                player.moveLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                player.moveDown();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.moveRight();
            }
        }

        public void keyReleased(KeyEvent e) {
            // do nothing
        }

        public void keyTyped(KeyEvent e) {
            // do nothing
        }
    }
}
