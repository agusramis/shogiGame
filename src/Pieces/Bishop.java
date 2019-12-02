package Pieces;

public class Bishop extends Piece{

	public Bishop(String s, String color) {
		super(s, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Boolean validMove(int x,int y, int newX, int newY,Piece[][] table,String color ,Boolean promoted) {
	
		if(promoted==true) {
			//Cuatro nuevos movimientos x=1, y=0; x=0 y=1; x=-1 y=0;y=-1 x =0 
			if((Math.abs(x-newX)<=1)&&(Math.abs(y-newY)<=1)) {
			
			return true;
		}}

		
		if(Math.abs(x-newX)== Math.abs(y-newY)) {
		 //Veo hacia adonde apunta
		int dX = newX > x ? 1 : -1;
		int dY = newY > y ? 1 : -1;
		 for(int i =1; i<Math.abs(y-newY);i++) {
			 if((table[x+dX*i][y+dY*i].getPiece()!="  ")) {
			System.out.println("There is a piece Before"); 
			 return false;
		 }
			 }return true;
		 
	 }else {
		System.out.println("Invalid Bishop Move");
	 return false;}
	
}}
