package entity.player;

import block.Block;

import java.awt.Color;

public class DefaultPlayer extends Player {
    public DefaultPlayer() {
        super();
    }

    public DefaultPlayer(PlayerWrapper wrapper, int x, int y, int width, int height, Color colour, int score, int lifeCount, boolean isAlive) {
        super(wrapper, x, y, width, height, colour, score, lifeCount, isAlive);
    }

    public DefaultPlayer(DefaultPlayer player) {
        super(player);
    }

    public void collide(Block block) {
        block.collide(this);
    }
}
