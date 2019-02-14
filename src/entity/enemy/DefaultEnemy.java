package entity.enemy;

import block.Block;

import java.awt.Color;

public class DefaultEnemy extends Enemy {

    public DefaultEnemy() {
        super();
    }

    public DefaultEnemy(EnemyWrapper wrapper, int x, int y, int width, int height, Color colour, boolean isAlive) {
        super(wrapper, x, y, width, height, colour, isAlive);
    }

    public void collide(Block block) {
        block.collide(this);
    }
}
