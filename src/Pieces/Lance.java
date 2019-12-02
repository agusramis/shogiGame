package Pieces;

public class Lance extends Piece{

	public Lance(String s, String color) {
		super(s, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Boolean validMove(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if(promoted==true) {
			if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
				if((color=="white") && ((newX-x)==-1)) {
					if(newY!=y) {
						System.out.println("Invalid Promoted Lance Move");
					return false;}
					
				}else if((color=="black") && ((newX-x)==1)) {
					if(newY!=y) {
						System.out.println("Invalid Promoted Lance Move");
					return false;}
					
				}
				return true;
				
			}else {
				System.out.println("Invalid Promoted Lance Move");
				return false;}
		}
		
		
		if(color=="white") {
		if((newX-x>0)&& (Math.abs(y-newY)==0)) {
			for(int i=x+1;i<newX;i++) {
				if((table[i][y].getPiece()!="  ")) {
					 System.out.println("There is a piece before");
					 return false;
				 }
			
		}return true;
		}else {
			System.out.println("Invalid Lance Move");
			return false;}
		
		
		}else if(color=="black") {
			
		}
		if((x-newX>0)&& (Math.abs(y-newY)==0)) {
			for(int i=x- 1;i>newX;i--) {
				
				if((table[i][y].getPiece()!="  ")&&(table[i][y].getColor()==color)) {
					 System.out.println("There is a piece before");
					 return false;
				 }
			
		}return true;
		}else {
			System.out.println("Invalid Lance Move");
			return false;}
		
	}
}
