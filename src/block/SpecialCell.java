package block;

import entity.enemy.DefaultEnemy;
import entity.player.DefaultPlayer;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

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
            setIsEaten(true, powerColour[power]);
            player.incrementScore(999);
        }
        player.setDirection(player.getNextDirection());
        player.getWrapper().setPlayer(new DefaultPlayer(player));
        Timer timer = new Timer("Respawn");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setIsEaten(false, powerColour[power]);
            }
        }, 3000);
    }

    public void collide(DefaultEnemy enemy) {
        enemy.setDirection(enemy.getNextDirection());
    }
}
