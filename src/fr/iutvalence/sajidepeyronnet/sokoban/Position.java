package fr.iutvalence.sajidepeyronnet.sokoban;

import java.util.Objects;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
class Position {
    /**  x position. */
    private final int x;
    /**  y position */
    private final int y;

    /** we creat a Position. 
     * @param x0 the x
     * @param y0 the y*/
    Position(int x0, int y0) {
        this.x = x0;
        this.y = y0;
    }

    /** get X.
     * @return x */
    int x() {
        return x;
    }

    /** get Y
     * @return y. */
    int y() {
        return y;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { return true; }
        if ((obj == null) || (getClass() != obj.getClass())) { return false; }
        final Position position = (Position) obj;
        return (x == position.x) && (y == position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ')';
    }

    /**
     * @param d a direction
     * @return new position
     */
    Position translate(Direction d) {
        return new Position(x + d.dX(), y + d.dY());
    }


}
