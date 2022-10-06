package events;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private static boolean isWPressed = false;
    private static boolean isSPressed = false;
    private static boolean isAPressed = false;
    private static boolean isDPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            isWPressed = true;
        }
        if (e.getKeyChar() == 's') {
            isSPressed = true;
        }
        if (e.getKeyChar() == 'a') {
            isAPressed = true;
        }
        if (e.getKeyChar() == 'd') {
            isDPressed = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            isWPressed = false;
        }
        if (e.getKeyChar() == 's') {
            isSPressed = false;
        }
        if (e.getKeyChar() == 'a') {
            isAPressed = false;
        }
        if (e.getKeyChar() == 'd') {
            isDPressed = false;
        }
    }

    public static boolean isWPressed() {
        return isWPressed;
    }

    public static void setIsWPressed(boolean isWPressed) {
        KeyListener.isWPressed = isWPressed;
    }

    public static boolean isSPressed() {
        return isSPressed;
    }

    public static void setIsSPressed(boolean isSPressed) {
        KeyListener.isSPressed = isSPressed;
    }

    public static boolean isAPressed() {
        return isAPressed;
    }

    public static void setIsAPressed(boolean isAPressed) {
        KeyListener.isAPressed = isAPressed;
    }

    public static boolean isDPressed() {
        return isDPressed;
    }

    public static void setIsDPressed(boolean isDPressed) {
        KeyListener.isDPressed = isDPressed;
    }
}
