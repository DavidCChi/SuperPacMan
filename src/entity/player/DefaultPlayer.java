package entity.player;

import block.Block;

import entity.enemy.Enemy;

import java.awt.Color;

public class DefaultPlayer extends Player {
    public DefaultPlayer() {
        super();
    }

    public DefaultPlayer(PlayerWrapper wrapper, int x, int y, int width, int height, Color colour, boolean alive, int score, int lifeCount) {
        super(wrapper, x, y, width, height, colour, alive, score, lifeCount);
    }

    public DefaultPlayer(Player player) {
        super(player);
    }

    public void collide(Block block) {
        block.collide(this);
    }

    public void collide(Enemy enemy) {
        setLifeCount(getLifeCount() - 1);
        setAlive(false);
        if (getLifeCount() > 0) {
            respawn(20, 20);
        }
    }
}
