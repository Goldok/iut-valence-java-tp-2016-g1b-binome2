package fr.iutvalence.sajidepeyronnet.sokoban;

/** TODO. */
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

    /** TODO. */
    Direction(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

    /** TODO. */
    public int dX() {
        return dX;
    }

    /** TODO. */
    public int dY() {
        return dY;
    }
}
