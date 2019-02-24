package block;

import entity.player.DefaultPlayer;
import entity.player.SuperPlayer;
import entity.enemy.DefaultEnemy;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class SpecialCell extends Cell {
    private static final Color powerColour[] = {Color.ORANGE, Color.GREEN};
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
        player.setDirection(player.getNextDirection());
        if (!isEaten()) {
            switch (power) {
                case 0:
                    player.incrementScore(999);
                    break;
                case 1:
                    player.getWrapper().setPlayer(new SuperPlayer(player));
                    break;
            }
            setEaten(true, powerColour[power]);
        }
        Timer timer = new Timer("Respawn");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                power = ThreadLocalRandom.current().nextInt(0, powerColour.length);
                setEaten(false, powerColour[power]);
            }
        }, 3000);
    }

    public void collide(SuperPlayer player) {
        player.setDirection(player.getNextDirection());
        if (!isEaten()) {
            switch (power) {
                case 0:
                    player.incrementScore(999);
                    break;
                case 1:
                    player.getWrapper().setPlayer(new SuperPlayer(player));
                    break;
            }
            setEaten(true, powerColour[power]);
        }
        Timer timer = new Timer("Respawn");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                power = ThreadLocalRandom.current().nextInt(0, powerColour.length);
                setEaten(false, powerColour[power]);
            }
        }, 3000);
    }

    public void collide(DefaultEnemy enemy) {
        enemy.setDirection(enemy.getNextDirection());
    }
}
