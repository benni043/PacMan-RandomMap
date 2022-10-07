package main;

import canvas.Canvas;
import maze.RandomMaze;
import player.Player;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Main {

    private static RandomMaze randomMaze;

    private static Player player;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    public static final int X_COUNT = 15;
    public static final int Y_COUNT = 15;

    public static final int percent = 1;

    public static void main(String[] args) {
        player = new Player(5,5);

        randomMaze = new RandomMaze();
//        randomMaze.createRandomMaze(0, 0, true, true);

        randomMaze.createRandomMaze(0,0, true, true);
        randomMaze.createSpawn(15, 15);

        Canvas canvas = new Canvas();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                canvas.getDraw().repaint();
            }
        }, 0, 1000 / 25);
    }

    public static RandomMaze getRandomMaze() {
        return randomMaze;
    }

    public static Player getPlayer() {
        return player;
    }
}
