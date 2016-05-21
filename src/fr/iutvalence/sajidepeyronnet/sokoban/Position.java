package fr.iutvalence.sajidepeyronnet.sokoban;

import java.util.Objects;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
class Position {
    /** TODO. */
    private final int x;
    /** TODO. */
    private final int y;

    /** TODO. */
    Position(int x0, int y0) {
        this.x = x0;
        this.y = y0;
    }

    /** TODO. */
    int x() {
        return x;
    }

    /** TODO. */
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
     * TODO.
     *
     * @param d TODO
     *

     * @return TODO
     */
    Position translate(Direction d) {
        return new Position(x + d.dX(), y + d.dY());
    }


}
