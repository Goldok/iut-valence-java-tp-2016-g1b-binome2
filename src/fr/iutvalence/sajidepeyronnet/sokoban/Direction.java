package fr.iutvalence.sajidepeyronnet.sokoban;

/** Enumeration of mooves that can have the player */
enum Direction {
 
    HAUT(0, -1), /** we move 1 on x position. */
    BAS(0, +1), /** we add 1 on x position. */
    GAUCHE(-1, 0), /** we move 1 on y position */
    DROITE(1, 0), /** we add 1 on y position */
    NULL(0, 0);

    /**  */
    int dX;
    /** TODO. */
    int dY;

    /** Constructor of direction with values at x and y of the direction 
     * @param dx the dx
     * @param dy the dy
     * */
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
