package Pieces;

public class Gold extends Piece{

	public Gold(String s, String color) {
		super(s, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean validMove(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
			if((color=="white") && ((newX-x)==-1)) {
				if(newY!=y) {
					System.out.println("Invalid Gold Move");
				return false;}
				
			}else if((color=="black") && ((newX-x)==1)) {
				if(newY!=y) {
					System.out.println("Invalid Gold Move");
				return false;}
				
			}
			return true;
			
		}else {
			System.out.println("Invalid Gold Move");
			return false;}
	}
	
	
	
	
	
	
	
	
	
	@Override
	public Boolean validMoveSinMensajes(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
			if((color=="white") && ((newX-x)==-1)) {
				if(newY!=y) {
				return false;}
				
			}else if((color=="black") && ((newX-x)==1)) {
				if(newY!=y) {
				return false;}
				
			}
			return true;
			
		}else {
			return false;}
	}
}
