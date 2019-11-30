import java.util.ArrayList;

import Pieces.Piece;

public class Board {
	ArrayList<Piece> captureBlack= new ArrayList<Piece>();
	ArrayList<Piece> captureWhite= new ArrayList<Piece>();
	public Board() {

	}

	public void fillBoard(Piece table[][]){
		
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
				table[i][j] =new Pieces.NullPiece(null, null, i, j);
				table[2][j]= new Pieces.Pawn("PW","white", 2, j);
				table[6][j]= new Pieces.Pawn("PB","black", 6, j);
		}
		
	}
	
	table[0][0] = new Pieces.Lance("LW" ,"white", 0, 0);
	table[0][1] = new Pieces.Knight("CW" ,"white",0 ,1);
	table[0][2] = new Pieces.Silver("SW" ,"white",0 ,2);
	table[0][3] = new Pieces.Gold("GW" ,"white",0 ,3);
	table[0][4] = new Pieces.King("KW" ,"white",0 ,4);
	table[0][5] = new Pieces.Gold("GW" ,"white",0 ,5);
	table[0][6] = new Pieces.Silver("SW" ,"white",0 ,6);
	table[0][7] = new Pieces.Knight("CW" ,"white",0 ,7);
	table[0][8] = new Pieces.Lance("LW" ,"white",0 ,8);
	table[1][1] = new Pieces.Rook("RW" ,"white",1 ,1);
	table[1][7] = new Pieces.Bishop("BW" ,"white",1 ,7);
	
	table[8][0] = new Pieces.Lance("LB" ,"black",8 ,0);
	table[8][1] = new Pieces.Knight("CB" ,"black",8 ,1);
	table[8][2] = new Pieces.Silver("SB" ,"black",8 ,2);
	table[8][3] = new Pieces.Gold("GB" ,"black",8 ,3);
	table[8][4] = new Pieces.King("KB" ,"black",8 ,4);
	table[8][5] = new Pieces.Gold("GB" ,"black",8 ,5);
	table[8][6] = new Pieces.Silver("SB" ,"black",8 ,6);
	table[8][7] = new Pieces.Knight("CB" ,"black",8 ,7);
	table[8][8] = new Pieces.Lance("LB" ,"black",8 ,8);
	table[7][1] = new Pieces.Bishop("BB" ,"black",7 ,1);
	table[7][7] = new Pieces.Rook("RB" ,"black",7 ,7);
	
}

	
	public void PrintBoard(Piece table[][]) {
	System.out.print(" ");

	for (int i = 0; i < 9; i++) {
		System.out.print("  " + i+ " ");
		
	}
	System.out.println();
	for (int i = 0; i < table.length; i++) {
		System.out.print(i+"|");
		for (int j = 0; j < table.length; j++) {
			if(table[i][j].getPromoted()==true) {
			System.out.print(table[i][j].getPiece()+ "|");}
			else System.out.print(table[i][j].getPiece()+ " |");
			
		}
		System.out.println("");
		
	}
	printCapture();
	
	}
	public void initCapture() {
		for(int i=0;i<38;i++) {
			captureBlack.add(null);
		}
	}
	  public void fillCapture(Piece pieceCapture) {
			if(pieceCapture.getColor()=="white") {
			for (int i = 0; i < captureBlack.size(); i++) {
				if(captureBlack.get(i)==null) {
					captureBlack.add(pieceCapture);
				}
				
			}}
		}
	public void printCapture() {
		System.out.println("---------------");
		System.out.println("Capture Pieces:");
		System.out.print("9|");
		for (int i = 0; i < captureBlack.size(); i++) {
			if(captureBlack.get(i)!=null) {
				System.out.print(captureBlack.get(i).getPiece()+ " |");
				
			}
			
		}
		System.out.println();
	}
}
