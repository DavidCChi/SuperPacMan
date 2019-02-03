package entity.player;

import block.Block;
import entity.player.Player;

import java.awt.Color;

public class DefaultPlayer extends Player {
    public DefaultPlayer() {
        super();
    }

    public DefaultPlayer(int x, int y, int width, int height, Color colour, int lifeCount, boolean isAlive) {
        super(x, y, width, height, colour, lifeCount, isAlive);
    }

    public void collide(Block block) {
        block.collide(this);
    }
}
