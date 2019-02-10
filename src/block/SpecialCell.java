package block;

import entity.player.DefaultPlayer;

import java.awt.*;

public class SpecialCell extends Cell {
    private static final Color powerColour[] = {Color.ORANGE};
    private int power;

    public SpecialCell() {
        super();
        power = 0;
    }

    public SpecialCell(int x, int y, int width, int height, boolean isEaten, int power) {
        super(x, y, width, height, isEaten);
        this.setColour(powerColour[power]);
        this.power = power;
    }

    public void collide(DefaultPlayer player) {
        if (!getIsEaten()) {
            setIsEaten(true);
            player.incrementScore(999);
        }
        player.setDirection(player.getNextDirection());
    }
}
