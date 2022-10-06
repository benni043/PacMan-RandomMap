package maze;

/**
 * Created 29.09.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Cell {

    private boolean upperWall;
    private boolean rightWall;

    public Cell(boolean upperWall, boolean rightWall) {
        this.upperWall = upperWall;
        this.rightWall = rightWall;
    }

    public void maySetUpperWall(boolean upperWall) {
        if(this.upperWall) {
           this.upperWall = upperWall;
        }
    }

    public void maySetRightWall(boolean rightWall) {
        if(this.rightWall) {
            this.rightWall = rightWall;
        }
    }

    public void deleteUpperWall() {
        this.upperWall = false;
    }

    public void deleteRightWall() {
        this.rightWall = false;
    }

    public boolean hasUpperWall() {
        return upperWall;
    }

    public boolean hasRightWall() {
        return rightWall;
    }

}