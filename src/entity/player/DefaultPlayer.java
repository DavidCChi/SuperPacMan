package entity.player;

import entity.player.Player;

import java.awt.Color;

public class DefaultPlayer extends Player {
    public DefaultPlayer() {
        super();
    }

    public DefaultPlayer(int x, int y, int width, int height, Color colour, int lifeCount, boolean isAlive) {
        super(x, y, width, height, colour, lifeCount, isAlive);
    }
}
