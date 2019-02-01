import block.*;
import entity.*;
import entity.player.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Screen extends JPanel {

    public static final int DIM = 20;

    private Block[][] grid;
    private Player player;

    public Screen() {
        super();
        grid = new Block[25][25];
        player = new DefaultPlayer(50, 50, DIM, DIM, Color.YELLOW, 3, true);
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
        updateSurroundingBlocks(player);
    }

    public void tick() {
        update();
        repaint();
    }

    public void update() {
        int direction = player.getDirection();
        Block block = player.getSurroundBlocks(direction);
        if (block.getIsSolid()) {
            if (player.willIntersect(block)) {
                if (direction % 2 == 0) {
                    player.setYVel(0);
                } else {
                    player.setXVel(0);
                }
            }
        }
        System.out.print(player.getX() + " " + player.getY() + " ");
        System.out.println(player.getDirection());
        player.updatePosition();
        updateSurroundingBlocks(player);
    }

    public void updateSurroundingBlocks(Entity entity) {
        int x = (int)entity.getX();
        int y = (int)entity.getY();

        int blockX;
        int blockY;

        // update top block
        blockX = x / 20;
        blockY = (((int)y / 20) - 1);
        entity.setSurroundBlocks(0, grid[blockY < 0 ? 0 : blockY][blockX < 0 ? 0 : blockX]);

        // update left block
        blockX = (((int)x / 20) - 1);
        blockY = y / 20;
        entity.setSurroundBlocks(1, grid[blockY < 0 ? 0 : blockY][blockX < 0 ? 0 : blockX]);

        // update bottom block
        blockX = x / 20;
        blockY = (((int)y / 20) + 1);
        entity.setSurroundBlocks(2, grid[blockY < 0 ? 0 : blockY][blockX < 0 ? 0 : blockX]);

        // update right block
        blockX = (((int)x / 20) + 1);
        blockY = y / 20;
        entity.setSurroundBlocks(3, grid[blockY < 0 ? 0 : blockY][blockX < 0 ? 0 : blockX]);
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
