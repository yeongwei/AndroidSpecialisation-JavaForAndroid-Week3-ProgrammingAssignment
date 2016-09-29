package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;

    private int mSwing = CLOSED;

    public boolean setSwing(int direction) {
        if (isValid(direction)) {
            mSwing = direction;
            return true;
        } else
            return false;
    }

    public int getSwingDirection() {
        return mSwing;
    }

    public boolean open(int direction) {
        if (isIn(direction) || isOut(direction)) {
            return setSwing(direction);
        } else
            return false;
    }

    public void close() {
        setSwing(CLOSED);
    }

    public int thru(int count) {
        if (isIn(mSwing))
            return count;
        else if (isOut(mSwing))
            return -1 * count;
        else
            return 0;
    }

    public String toString() {
        if (isIn(mSwing))
            return "This gate is open and swings to enter the pen only";
        else if (isOut(mSwing))
            return "This gate is open and swings to exit the pen only";
        else if (isClosed(mSwing))
            return "This gate is closed";
        else
            return "This gate has an invalid swing direction";
    }

    private static boolean isIn(int direction) {
        if (direction == IN)
            return true;
        else
            return false;
    }

    private static boolean isOut(int direction) {
        if (direction == OUT)
            return true;
        else
            return false;
    }

    private static boolean isClosed(int direction) {
        if (direction == CLOSED)
            return true;
        else
            return false;
    }

    private static boolean isValid(int direction) {
        if (isIn(direction) || isOut(direction) || isClosed(direction))
            return true;
        else
            return false;
    }
}
