package main;
import java.util.ArrayList;

import Pieces.Piece;

public class Board {
	private ArrayList<Piece> captureBlack = new ArrayList<Piece>();
	private ArrayList<Piece> captureWhite = new ArrayList<Piece>();
	public Board() {

	}

	public void fillBoard(Piece table[][]){
		
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
				table[i][j] =new Pieces.NullPiece(null, null);
				table[2][j]= new Pieces.Pawn("PW","white");
				table[6][j]= new Pieces.Pawn("PB","black");
		}
		
	}
	
	table[0][0] = new Pieces.Lance("LW" ,"white");
	table[0][1] = new Pieces.Knight("CW" ,"white");
	table[0][2] = new Pieces.Silver("SW" ,"white");
	table[0][3] = new Pieces.Gold("GW" ,"white");
	table[0][4] = new Pieces.King("KW" ,"white");
	table[0][5] = new Pieces.Gold("GW" ,"white");
	table[0][6] = new Pieces.Silver("SW" ,"white");
	table[0][7] = new Pieces.Knight("CW" ,"white");
	table[0][8] = new Pieces.Lance("LW" ,"white");
	table[1][1] = new Pieces.Rook("RW" ,"white");
	table[1][7] = new Pieces.Bishop("BW" ,"white");
	
	table[8][0] = new Pieces.Lance("LB" ,"black");
	table[8][1] = new Pieces.Knight("CB" ,"black");
	table[8][2] = new Pieces.Silver("SB" ,"black");
	table[8][3] = new Pieces.Gold("GB" ,"black");
	table[8][4] = new Pieces.King("KB" ,"black");
	table[8][5] = new Pieces.Gold("GB" ,"black");
	table[8][6] = new Pieces.Silver("SB" ,"black");
	table[8][7] = new Pieces.Knight("CB" ,"black");
	table[8][8] = new Pieces.Lance("LB" ,"black");
	table[7][1] = new Pieces.Bishop("BB" ,"black");
	table[7][7] = new Pieces.Rook("RB" ,"black");
	
}

	
	public void PrintBoard(Piece table[][], String Player) {
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
	printCapture(Player);
	
	}
	public void initCaptureBlack() {
		for(int i=0;i<20;i++) {
			captureBlack.add(i, new Pieces.NullPiece(null,null));
		}
	}
	public void initCaptureWhite() {
		for(int i=0;i<20;i++) {	

			captureWhite.add(i, new Pieces.NullPiece(null,null));
		}
	}
	public Piece ReInsertCapture(int select, String player) {
		if(player =="black") {
		for (int i = 0; i < 20; i++) {
			
			if(captureBlack.get(i)==captureBlack.get(select)&&(captureBlack.get(i).getPiece()!="  ")) {
				Piece selected = captureBlack.get(i);
				return selected;
				
				
			}}	
				System.out.println("Try again");
				return null;
		}else if(player=="white") {
			for (int i = 0; i < 20; i++) {
				if(captureWhite.get(i)==captureWhite.get(select)&&(captureWhite.get(i).getPiece()!="  ")) {
					Piece selected =captureWhite.get(select);
					return selected;
					
					
				}
		}System.out.println("Try again");
		return null;}
		else
		
			System.out.println("Try again");
			return null;
		
		
		
	}
	
	public void CaptureRemove( int select,String player) {
		if(player =="black") {
			for (int i = 0; i < 20; i++) {

				if(captureBlack.get(i)==captureBlack.get(select)&&(captureBlack.get(i).getPiece()!="  ")) {
					captureBlack.remove(i);
				}}
			}
		else if(player=="white") {
				for (int i = 0; i < 20; i++) {
					if(captureWhite.get(i)==captureWhite.get(select)&&(captureWhite.get(i).getPiece()!="  ")) {
						captureWhite.remove(i);
					}
			}}

	}
	  public void fillCapture(Piece pieceCapture) {
		  if(pieceCapture.getPromoted()==true) {
				pieceCapture.setPromoted(false);
			}
			if(pieceCapture.getColor()=="white") {
				pieceCapture.changeColor(pieceCapture);
			for (int i = 0; i < 20; i++) {
				 System.out.println(captureBlack.get(i).getPiece());
				if(captureBlack.get(i).getPiece()=="  ") {
					
					captureBlack.add(i, pieceCapture);
					
					break;
					
				}}
			}else if(pieceCapture.getColor()=="black") {
				pieceCapture.changeColor(pieceCapture);
			for (int i = 0; i < 20; i++) {
				 System.out.println(captureWhite.get(i).getPiece());
				if(captureWhite.get(i).getPiece()=="  ") {
					
					captureWhite.add(i, pieceCapture);
					
					break;
					
				}}
			}
		}
	public void printCapture(String Player) {
		
		if(Player=="black") {
		System.out.println("---------------");
		System.out.println("Capture Pieces:");
		System.out.print("9: ");
		for (int i = 0; i < captureBlack.size(); i++) {
			
			if(captureBlack.get(i).getPiece()!="  ") {
				System.out.print(i+":"+captureBlack.get(i).getPiece()+" ");
				
			}
			
		}
		System.out.println();
	}else if(Player=="white") {
		System.out.println("---------------");
	System.out.println("Capture Pieces:");
	System.out.print("9: ");
	for (int i = 0; i < captureWhite.size(); i++) {
		
		if(captureWhite.get(i).getPiece()!="  ") {
			System.out.print(i+":"+captureBlack.get(i).getPiece()+" ");
			
		}
		
	}
	System.out.println();}
}}
