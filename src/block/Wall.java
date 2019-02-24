package block;

import entity.Entity;
import entity.player.DefaultPlayer;
import entity.player.SuperPlayer;
import entity.enemy.DefaultEnemy;

import java.awt.Color;

public class Wall extends Block {

    public static final Color colour = Color.BLUE;

    public Wall() {
        super();
    }

    public Wall(int x, int y, int width, int height) {
        super(x, y, width,  height, colour);
    }

    public void collide(DefaultPlayer player) {
        player.setNextDirection(Entity.STOP);
    }

    public void collide(SuperPlayer player) { player.setNextDirection(Entity.STOP); }

    public void collide(DefaultEnemy enemy) { enemy.setNextDirection(Entity.STOP); }
}
