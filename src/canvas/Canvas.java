package canvas;

import events.KeyListener;
import main.Main;


import javax.swing.*;
import java.awt.*;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Canvas {

    Draw draw;

    public Canvas() {
        JFrame jFrame = new JFrame("Sudoku Solver");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.requestFocus();

        draw = new Draw();
        draw.setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
        draw.setVisible(true);

        jFrame.addKeyListener(new KeyListener());

        jFrame.add(draw);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public Draw getDraw() {
        return draw;
    }
}
