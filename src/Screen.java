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
    private PlayerWrapper playerWrapper;

    public Screen() {
        super();
        grid = new Block[25][25];
        playerWrapper = new PlayerWrapper();
        playerWrapper.setPlayer(new DefaultPlayer(playerWrapper, 20, 20, DIM, DIM, Color.YELLOW, 0, 3, true));
        setFocusable(true);
        setBackground(Color.BLACK);
        setOpaque(true);
        addKeyListener(new KeyListen());
        init();
    }

    /**
     * Populates this screen.
     */
    public void init() {
        for (int y = 0; y < 25; ++y) {
            for (int x = 0; x < 25; ++x) {
                /*
                if (x == 0 || x == 24 || y == 0 || y == 24) {
                    grid[y][x] = new Wall(x * DIM, y * DIM, DIM, DIM);
                } else if ((x % 2 == 0) && (y % 2 == 0)) {
                    grid[y][x] = new Wall(x * DIM, y * DIM, DIM, DIM);
                } else {
                    grid[y][x] = new Empty(x * DIM, y * DIM, DIM, DIM);
                }
                */
                if (x == 0 || x == 24 || y == 0 || y == 24) {
                    grid[y][x] = new Wall(x * DIM, y * DIM, DIM, DIM);
                } else {
                    grid[y][x] = new Cell(x * DIM + (DIM / 2), y * DIM + (DIM / 2), DIM / 4, DIM / 4, false);
                }
            }
        }
        grid[10][10] = new Wall(200, 200, DIM, DIM);
        grid[11][10] = new Wall(200, 220, DIM, DIM);
        grid[12][10] = new Wall(200, 240, DIM, DIM);
        grid[5][5] = new SpecialCell(110, 110, 5, 5, false, 0);
        updateSurroundingBlocks(playerWrapper.getPlayer());
    }

    public void tick() {
        update();
        repaint();
    }

    public void update() {
        if (playerWrapper.getNextDirection() == Entity.STOP) return;
        if (((playerWrapper.getX() % DIM) == 0) && ((playerWrapper.getY() % DIM) == 0)) {
            // check if next move is valid when the player is at an intersection
            updateSurroundingBlocks(playerWrapper.getPlayer());
            int direction = playerWrapper.getNextDirection();
            Block block = playerWrapper.getSurroundBlocks(direction);
            playerWrapper.collide(block);
        } else {
            if (playerWrapper.getNextDirection() % 2 == playerWrapper.getDirection() % 2) {
                playerWrapper.setDirection(playerWrapper.getNextDirection());
            }
        }
        System.out.println(playerWrapper.getX() + " " + playerWrapper.getY() + " " + playerWrapper.getDirection() + " " + playerWrapper.getScore());
        playerWrapper.updatePosition();
    }

    public void updateSurroundingBlocks(Entity entity) {
        int x = (int)entity.getX();
        int y = (int)entity.getY();

        int blockX;
        int blockY;

        // update top block
        blockX = x / DIM;
        blockY = ((y / DIM) - 1);
        entity.setSurroundBlocks(0, grid[blockY < 0 ? 0 : blockY][blockX < 0 ? 0 : blockX]);

        // update left block
        blockX = ((x / DIM) - 1);
        blockY = y / DIM;
        entity.setSurroundBlocks(1, grid[blockY < 0 ? 0 : blockY][blockX < 0 ? 0 : blockX]);

        // update bottom block
        blockX = x / DIM;
        blockY = ((y / DIM) + 1);
        entity.setSurroundBlocks(2, grid[blockY < 0 ? 0 : blockY][blockX < 0 ? 0 : blockX]);

        // update right block
        blockX = ((x / DIM) + 1);
        blockY = y / DIM;
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
        g2d.setColor(playerWrapper.getPlayer().getColour());
        g2d.fill(playerWrapper.getPlayer());
    }

    private class KeyListen implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                playerWrapper.setNextDirection(Entity.UP);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                playerWrapper.setNextDirection(Entity.LEFT);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playerWrapper.setNextDirection(Entity.DOWN);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                playerWrapper.setNextDirection(Entity.RIGHT);
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
