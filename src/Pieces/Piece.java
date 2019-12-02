package Pieces;


public abstract class Piece {
	private String piece;
	private String color;
	private Boolean promoted;
	
	public Piece(String s, String color) {
		this.piece= s;
		this.color = color;
		this.promoted= false;
	}
    public Boolean validMove( int x, int y, int newX, int newY, Piece[][] table, String color, Boolean promoted) {
		return null;
	}
    public Boolean validMoveSinMensajes( int x, int y, int newX, int newY, Piece[][] table, String color, Boolean promoted) {
		return null;
	}
  
	public String getPiece() {
		if(piece==null) {
			return "  ";
		}
		if(promoted) {
			return piece+"+";
		}
		return piece;
	}
	
	public void changeColor(Piece pieceCapture) {
		if(pieceCapture.getColor()=="white") {
		pieceCapture.setColor("black");
		}else if(pieceCapture.getColor()=="black") 
		{ pieceCapture.setColor("white");}
		
		String NameBefore=pieceCapture.getPiece();
		
		switch(NameBefore) {
		case "BW":
			pieceCapture.setPiece("BB");
			break;
		case "LW":
			pieceCapture.setPiece("LB");
			break;
		case "CW":
			pieceCapture.setPiece("CB");
			break;
		case "SW":
			pieceCapture.setPiece("SB");
			break;
		case "GW":
			pieceCapture.setPiece("GB");
			break;
		case "RW":
			pieceCapture.setPiece("RB");
			break;
		case "PW":
			pieceCapture.setPiece("PB");
			break;
		case "BB":
			pieceCapture.setPiece("BW");
			break;
		case "LB":
			pieceCapture.setPiece("LW");
			break;
		case "CB":
			pieceCapture.setPiece("CW");
			break;
		case "SB":
			pieceCapture.setPiece("SW");
			break;
		case "GB":
			pieceCapture.setPiece("GW");
			break;
		case "RB":
			pieceCapture.setPiece("RW");
			break;
		case "PB":
			pieceCapture.setPiece("PW");
			break;
		
		
		}
	}
	public void setPiece (String NewPiece) {
		this.piece = NewPiece;
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
