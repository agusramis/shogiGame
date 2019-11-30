package Pieces;

public class Rook extends Piece{

	public Rook(String s, String color, int x, int y) {
		super(s, color, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean validMove(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if(promoted==true) {
			if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
				
				return true;
			}
		}
		
		if((Math.abs(x-newX)!=0) && (Math.abs(y-newY)==0)) {
		 for(int i=1;i<Math.abs(x-newX);i++) {
			 if (x>newX) {
				 if((table[x-i][y].getPiece()!=null)&&(table[x-i][y].getColor()==color)) {
					 System.out.println("You can´t eat your own Piece");
					 return false;
				 }
				 
			 }else {
				 if((table[x+i][y].getPiece()!=null)&&(table[x+i][y].getColor()==color)) {
			 
				 System.out.println("You can´t eat your own Piece");
				 return false;}
				 
			 }
		 }return true;
	 }
	 else if((Math.abs(x-newX)==0) && (Math.abs(y-newY)!=0)) {
		 for(int i=0;i<Math.abs(y-newY);i++) {
			 if (y>newY) {
				 if((table[x][y-i].getPiece()!=null)&&(table[x-i][y].getColor()==color)) {
					 System.out.println("You can´t eat your own Piece");
					 return false;
				 }
				 
			 }else {
				 if((table[x][y+i].getPiece()!=null)&&(table[x+i][y].getColor()==color)) {
			 
				 System.out.println("You can´t eat your own Piece");
				 return false;}
				 
			 }
			 
		 }
	 }
	 System.out.println("Invalid Rook Move");
	 return false;
 }
}
