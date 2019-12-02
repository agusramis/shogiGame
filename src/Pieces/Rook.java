package Pieces;

public class Rook extends Piece{

	public Rook(String s, String color) {
		super(s, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean validMove(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if(promoted==true) {
			if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
				
				return true;
			}
		}
		if((x!=newX) && (y!=newY)) {
			 System.out.println("Invalid Rook Move");
			return false;
		}
		
		if((x-newX>0)) {
		 for(int i=x-1;i>newX;i--) {
			 
				 if((table[i][y].getPiece()!="  ")) {
					 System.out.println("There is a piece before");
					 return false;
				 }
				 
			 } return true;}
		if((x-newX<0)) {
			for(int i = x + 1;i<newX;i++){
				 if((table[i][y].getPiece()!="  ")) {
			 
				 System.out.println("There is a piece before");
				 return false;}
				 
			 }		 return true;}

	
	 
		 if(y-newY>0) {
		 for(int i=y-1;i>newY;i--) {
				 if((table[x][i].getPiece()!="  ")) {
					 System.out.println("There is a Piece Before");
					 return false;
				 
				 
			 }}return true;}
		 if(y-newY<0) {
			 for(int i=y+1;i<newY;i++) {
				 if((table[x][i].getPiece()!="  ")) {
			 
				 System.out.println("There is a Piece Before");
				 return false;}
				 
			 }return true;}
			 
		 
	 
	 System.out.println("Invalid Rook Move");
	 return false;
 }
	@Override
	public Boolean validMoveSinMensajes(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if(promoted==true) {
			if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
				
				return true;
			}
		}
		
		if((x!=newX) && (y!=newY)) {
			
			return false;
		}
		
		if((x-newX>0)) {
		 for(int i=x-1;i>newX;i--) {
			 
				 if((table[i][y].getPiece()!="  ")) {
					
					 return false;
				 }
				 
			 } return true;}
		if((x-newX<0)) {
			for(int i = x + 1;i<newX;i++){
				 if((table[i][y].getPiece()!="  ")) {
			 
				
				 return false;}
				 
			 }		 return true;}

	
	 
		 if(y-newY>0) {
		 for(int i=y-1;i>newY;i--) {
				 if((table[x][i].getPiece()!="  ")) {
					
					 return false;
				 
				 
			 }}return true;}
		 if(y-newY<0) {
			 for(int i=y+1;i<newY;i++) {
				 if((table[x][i].getPiece()!="  ")) {
			 
			
				 return false;}
				 
			 }return true;}
			 
		 
	 
	 
	 return false;
}
}
