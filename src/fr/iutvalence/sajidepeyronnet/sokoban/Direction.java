package fr.iutvalence.sajidepeyronnet.sokoban;

public enum Direction {
	HAUT(0,-1),
	BAS(0,+1),
	GAUCHE(-1,0),
	DROITE(1,0),
	NULL(0,0);
	
	int dX;
	int dY;
	
	Direction(int dX, int dY)
	{
		
		this.dX=dX;
		this.dY=dY;
	}
	
	public int dX()
	{
		return this.dX;
	}
	
	public int dY()
	{
		return this.dY;
	}

	}
