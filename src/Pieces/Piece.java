package Pieces;


public abstract class Piece {
	private String piece;
	private String color;
	private int positionX;
	private int positionY;
	private Boolean promoted;
	
	public Piece(String s, String color, int x, int y) {
		this.piece= s;
		this.color = color;
		this.positionX = x ;
		this.positionY = y;
		this.promoted= false;
	}
    public Boolean validMove( int x, int y, int newX, int newY, Piece[][] table, String color, Boolean promoted) {
		return null;
	}
  
	public String getPiece() {
		if(piece==null) {
			return "  ";
		}
		return piece;
	}
	public void setPiece (String NewPiece) {
		this.piece = NewPiece;
	}

	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}


	public Boolean getPromoted() {
		return promoted;
	}
	public void setPromoted(Boolean promoted) {
		this.promoted = promoted;
	}
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
}
