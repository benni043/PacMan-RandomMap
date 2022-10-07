package maze;

import main.Main;
import maze.CellPoint.Point;
import maze.direction.Direction;

import java.util.ArrayList;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class RandomMaze {

    private final Cell[][] maze = new Cell[Main.X_COUNT][Main.Y_COUNT];
    private Direction beforeDirection = Direction.right;

    public void createMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = new Cell(true, true);
            }
        }
    }

    public void createSpawn(int spawnWidth, int spawnHeight) {
        for (int i = 0; i < spawnWidth; i++) {
            for (int j = 0; j < spawnHeight; j++) {
                if(i >= (spawnWidth-5)/2 && i <= ((spawnWidth-5)/2)+4 && j >= (spawnWidth-5)/2 && j <= ((spawnWidth-5)/2)+4) {
                    maze[i][j].setUpperWall(false);
                    maze[i][j].setRightWall(false);
                }

                if(j == (spawnWidth-5)/2 && i >= (spawnWidth-5)/2 && i <= ((spawnWidth-5)/2)+4) {
                    maze[i][j].setUpperWall(true);
                }
                if(i == ((spawnWidth-5)/2)+4 && j >= (spawnWidth-5)/2 && j <= ((spawnWidth-5)/2)+4) {
                    maze[i][j].setRightWall(true);
                }

            }
        }
    }

    public void createRandomMaze(int x, int y, boolean hasUpperWall, boolean hasRightWall) {
        if (maze[x][y] == null) {
            maze[x][y] = new Cell(hasUpperWall, hasRightWall);
        } else {
            maze[x][y].maySetUpperWall(hasUpperWall);
            maze[x][y].maySetRightWall(hasRightWall);
        }

        ArrayList<Point> validCellCords = new ArrayList<>();

        if (isValid(x + 1, y)) validCellCords.add(new Point(x + 1, y, Direction.right));
        if (isValid(x - 1, y)) validCellCords.add(new Point(x - 1, y, Direction.left));
        if (isValid(x, y + 1)) validCellCords.add(new Point(x, y + 1, Direction.bottom));
        if (isValid(x, y - 1)) validCellCords.add(new Point(x, y - 1, Direction.top));

        if (validCellCords.size() == 0) return;

        Point point = percentChance(Main.percent, validCellCords);

        switch (point.direction()) {
            case top -> {
                beforeDirection = Direction.top;

                createRandomMaze(point.x(), point.y(), true, true);
                createRandomMaze(x, y, false, true);
            }
            case bottom -> {
                beforeDirection = Direction.bottom;

                createRandomMaze(point.x(), point.y(), false, true);
                createRandomMaze(x, y, true, true);
            }
            case left -> {
                beforeDirection = Direction.left;

                createRandomMaze(point.x(), point.y(), true, false);
                createRandomMaze(x, y, true, true);
            }
            case right -> {
                beforeDirection = Direction.right;

                createRandomMaze(point.x(), point.y(), true, true);
                createRandomMaze(x, y, true, false);
            }
        }

    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) return false;

        return maze[x][y] == null;
    }

    private Point percentChance(int percent, ArrayList<Point> validCellCords) {
        Point point = validCellCords.get((int) (Math.random() * validCellCords.size()));
        for (int i = 0; i < validCellCords.size(); i++) {
            if (validCellCords.get(i).direction().equals(beforeDirection)) {
                int randNum = (int) (Math.random() * 100);

                if (randNum <= percent) {
                    point = validCellCords.get(i);
                } else {
                    point = validCellCords.get((int) (Math.random() * validCellCords.size()));
                }
            }
        }
        return point;
    }

    public void deleteWallInLinePercent(int percent) {
        int randNum;

        for (Cell[] cells : maze) {
            for (int j = 0; j < maze[j].length - 1; j++) {
                randNum = (int) (Math.random() * 100);
                if (randNum <= percent) {
                    cells[j].deleteRightWall();
                    cells[j].deleteUpperWall();
                }
            }
        }

    }

    public Cell[][] getMaze() {
        return maze;
    }
}