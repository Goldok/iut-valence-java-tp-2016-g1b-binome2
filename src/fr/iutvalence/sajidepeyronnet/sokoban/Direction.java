package fr.iutvalence.sajidepeyronnet.sokoban;

/** Enumeration of mooves that can have the player */
enum Direction {
    /** TODO. */
    HAUT(0, -1), /** TODO. */
    BAS(0, +1), /** TODO. */
    GAUCHE(-1, 0), /** TODO. */
    DROITE(1, 0), /** TODO. */
    NULL(0, 0);

    /** TODO. */
    int dX;
    /** TODO. */
    int dY;

    /** Constructor of direction with values at x and y of the direction */
    Direction(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

    /** Return the value at x of the direction. */
    public int dX() {
        return dX;
    }

    /** Return the value at y of the direction. */
    public int dY() {
        return dY;
    }
}
