package entity.player;

import block.Block;

import entity.enemy.Enemy;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class SuperPlayer extends Player {
    public SuperPlayer() {
        super();
    }

    public SuperPlayer(PlayerWrapper wrapper, int x, int y, int width, int height, Color colour, boolean alive, int score, int lifeCount) {
        super(wrapper, x, y, width, height, colour, alive, score, lifeCount);
    }

    public SuperPlayer(Player player) {
        super(player);
        setColour(Color.CYAN);
        //TODO fix respawn logic (reset all respawn timers when transforming to a new object)
        Timer timer = new Timer("Respawn DefaultPlayer");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getWrapper().setPlayer(new DefaultPlayer(getWrapper().getPlayer()));
            }
        }, 10000);
    }

    public void collide(Block block) {
        block.collide(this);
    }

    public void collide(Enemy enemy) {
        incrementScore(100);
        enemy.setAlive(false);
        enemy.respawn(60, 60);
    }
}
