package block;

import entity.enemy.DefaultEnemy;
import entity.player.DefaultPlayer;

import java.awt.*;

public class Cell extends Block {

    private boolean isEaten;

    public Cell() {
        super();
        isEaten = false;
    }

    public Cell(int x, int y, int width, int height, boolean isEaten) {
        super(x, y, width,  height, isEaten ? Color.BLACK : Color.WHITE);
    }

    /* accessors */
    public boolean getIsEaten() {
        return isEaten;
    }

    /* mutators */
    public void setIsEaten(boolean isEaten) {
        this.isEaten = isEaten;
        if (isEaten) {
            setColour(Color.BLACK);
        } else {
            setColour(Color.WHITE);
        }
    }

    public void collide(DefaultPlayer player) {
        if (!isEaten) {
            setIsEaten(true);
            player.incrementScore(1);
        }
        player.setDirection(player.getNextDirection());
    }

    public void collide(DefaultEnemy enemy) {
        enemy.setDirection(enemy.getNextDirection());
    }
}
