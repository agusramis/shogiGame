package Pieces;

public class King extends Piece{

	public King(String s, String color) {
		super(s, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Boolean validMove(int x,int y, int newX, int newY,Piece[][] table,String color,Boolean promoted) {
		if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
			return true;}
		else {
			System.out.println("Invalid King Move");
			return false;
		}
		}
}
