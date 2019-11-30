package Pieces;

public class Knight extends Piece{

	public Knight(String s, String color, int x, int y) {
		super(s, color, x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Boolean validMove(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if(promoted==true) {
			if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
				if((color=="white") && ((newX-x)==-1)) {
					if(newY!=y) {
						System.out.println("Invalid Promoted Knight Move");
					return false;}
					
				}else if((color=="black") && ((newX-x)==1)) {
					if(newY!=y) {
						System.out.println("Invalid Promoted Knight Move");
					return false;}
					
				}
				return true;
				
			}else {
				System.out.println("Invalid Promoted Knight Move");
				return false;}
		}
	
		
		
		if(color=="white") {
			if((newX-x==2)&&(Math.abs(y-newY)==1)) {
				return true;
				
			}
			
		}else if(color=="black") {
			if((x-newX==2)&&(Math.abs(y-newY)==1)) {
				return true;
				
			}
			
		}
		System.out.println("Invalid Knight Move");
		return false;
	}
}
