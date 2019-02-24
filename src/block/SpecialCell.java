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

    public SpecialCell(int x, int y, int width, int height, boolean eaten, int power) {
        super(x, y, width, height, eaten);
        this.setColour(powerColour[power]);
        this.power = power;
    }

    public void collide(DefaultPlayer player) {
        if (!isEaten()) {
            setEaten(true, powerColour[power]);
            player.incrementScore(999);
        }
        player.setDirection(player.getNextDirection());
        player.getWrapper().setPlayer(new DefaultPlayer(player));
        Timer timer = new Timer("Respawn");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                setEaten(false, powerColour[power]);
            }
        }, 3000);
    }

    public void collide(DefaultEnemy enemy) {
        enemy.setDirection(enemy.getNextDirection());
    }
}
