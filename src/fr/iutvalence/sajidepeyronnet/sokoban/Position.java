package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Position {
    /** TODO. */
    protected int x;
    /** TODO. */
    protected int y;

    /** TODO. */
    public Position(int x0, int y0) {
        this.x = x0;
        this.y = y0;
    }

    /** TODO. */
    public int getX() {
        return x;
    }

    /** TODO. */
    public int getY() {
        return y;
    }
    /* Méthode création NouvellePosition */

    // TODO All these methods are wrong!
    public Position PositionZ() {
        this.y = y--;
        return PositionZ();
    }

    public Position PositionS() {
        this.y = y++;
        return PositionS();
    }

    public Position PositionD() {
        this.x = x++;
        return PositionD();
    }

    public Position PositionQ() {
        this.x = x--;
        return PositionQ();
    }

}
