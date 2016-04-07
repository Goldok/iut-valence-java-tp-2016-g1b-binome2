package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Case {
    /** TODO. */
    public static final char WALL   = '#';
    /** TODO. */
    public static final char PLAYER = '1';
    /** TODO. */
    public static final char FLOOR  = ' ';
    /** TODO. */
    public static final char BOX    = '¤';
    /** TODO. */
    public static final char FINISH = '°';

    /** TODO. */
    protected char skin;

    /**
     * TODO.
     *
     * @param skin TODO
     */
    public Case(char skin) {
        this.skin = skin;
    }

    /** TODO. */
    public char getSkin() {
        return this.skin;
    }

    @Override
    public String toString() {
        return String.valueOf(skin);
    }
}
