package block;

import entity.enemy.DefaultEnemy;
import entity.player.DefaultPlayer;

import java.awt.*;

public class Cell extends Block {

    private boolean eaten;

    public Cell() {
        super();
        eaten = false;
    }

    public Cell(int x, int y, int width, int height, boolean eaten) {
        super(x, y, width,  height, eaten ? Color.BLACK : Color.WHITE);
    }

    /* accessors */
    public boolean isEaten() {
        return eaten;
    }

    /* mutators */
    public void setEaten(boolean eaten, Color colour) {
        this.eaten = eaten;
        if (eaten) {
            setColour(Color.BLACK);
        } else {
            setColour(colour);
        }
    }

    public void collide(DefaultPlayer player) {
        if (!eaten) {
            setEaten(true, Color.WHITE);
            player.incrementScore(1);
        }
        player.setDirection(player.getNextDirection());
    }

    public void collide(DefaultEnemy enemy) {
        enemy.setDirection(enemy.getNextDirection());
    }
}
