package fr.iutvalence.sajidepeyronnet.sokoban;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public class Case {
    public static final char WALL = '#';
    public static final char PLAYER = '1';
    public static final char FLOOR = ' ';
    public static final char BOX = '¤';
    public static final char FINISH = '°';
    
    
    
	/** TODO. */
    protected char skin;

    /**
     * TODO.
     *
     * @param string   TODO
     * @param Position TODO
     */
    public Case(char skin) {
    	this.skin = skin;
    }
    
    /* get skin */
    
    public char getSkin()
    {
    	return this.skin;
    }
    
    
    @Override
    public String toString() {
    	return String.valueOf(skin);
    }
}
