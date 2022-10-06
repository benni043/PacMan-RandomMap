package canvas;

import events.KeyListener;
import main.Main;
import maze.Cell;
import player.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Draw extends JLabel {

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        Cell[][] maze = Main.getRandomMaze().getMaze();

        float i = (float) Main.WIDTH / Main.getRandomMaze().getMaze().length;

        for (int x = 0; x < Main.getRandomMaze().getMaze().length; x++) {
            for (int y = 0; y < Main.getRandomMaze().getMaze()[x].length; y++) {

                if (maze[x][y].hasUpperWall()) {
                    graphics2D.drawLine((int) (x * i), (int) (y * i), (int) (x * i + i), (int) (y * i));
                }
                if (maze[x][y].hasRightWall()) {
                    graphics2D.drawLine((int) (x * i + i), (int) (y * i), (int) (x * i + i), (int) (y * i + i));
                }

            }
        }

        Player player = Main.getPlayer();

        //player
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawOval(Main.getPlayer().getX(), Main.getPlayer().getY(), Main.getPlayer().PLAYER_WIDTH, Main.getPlayer().PLAYER_HEIGHT);
        graphics2D.fillOval(Main.getPlayer().getX(), Main.getPlayer().getY(), Main.getPlayer().PLAYER_WIDTH, Main.getPlayer().PLAYER_HEIGHT);

        //player movement check

        if (KeyListener.isWPressed()) {
            if (player.getY() - 40 >= 0 && !maze[player.getX() / 40][player.getY() / 40].hasUpperWall()) {
                player.setY(player.getY() - 40);
            }
        }
        if (KeyListener.isSPressed()) {
            if (player.getY() + 40 <= 600 && !maze[player.getX() / 40][player.getY() / 40 + 1].hasUpperWall()) {
                player.setY(player.getY() + 40);
            }
        }
        if (KeyListener.isAPressed()) {
            if (player.getX() - 40 >= 0 && !maze[player.getX() / 40 - 1][player.getY() / 40].hasRightWall()) {
                player.setX(player.getX() - 40);
            }
        }
        if (KeyListener.isDPressed()) {
            if (player.getX() + 40 <= 600 && !maze[player.getX() / 40][player.getY() / 40].hasRightWall()) {
                player.setX(player.getX() + 40);
            }
        }

    }
}
