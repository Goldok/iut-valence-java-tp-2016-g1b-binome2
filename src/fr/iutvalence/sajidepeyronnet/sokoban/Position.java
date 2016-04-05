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

    
    
    public Position(int x0, int y0)
    {
    	this.x=x0;
    	this.y=y0;
    	
    }
    
    /* Méthode création NouvellePosition */ 
    
    public Position PositionZ() 
    {
    	this.y=y--;
    	return PositionZ(); 			
    }
    
    public Position PositionS() 
    {
    	this.y=y++;
    	return PositionS(); 			
    }
    
    public Position PositionD() 
    {
    	this.x=x++;
    	return PositionD();
    }
    
    public Position PositionQ() 
    {
    	this.x=x--;
    	return PositionQ(); 			
    }
    
    
    
    
    
    // TODO getter without return type?
    /** TODO. */
    public int getX() {
        return x;
    }

    // TODO getter without return type?
    /** TODO. */
    public int getY() {
        return y;
    }
    
}
