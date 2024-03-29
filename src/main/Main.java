package main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Pieces.King;
import Pieces.Piece;

public class Main {
	public static  String currentPlayer ="white";
	public static Boolean salir = true;
	public static void main(String[] args) {
		Main main = new Main();
		main.Game();
		
		
		
	}
public void Game() {
	Board board = new Board();
	Scanner input = new Scanner(System.in);
	Piece table[][] = new Piece [9][9];
	Main main = new Main();
	
	board.fillBoard(table);
	board.initCaptureBlack();
	board.initCaptureWhite();
	
	 while (salir) {
		 Boolean jaque =false;
		
		board.PrintBoard(table,currentPlayer);
		if(main.jaque(board, table,currentPlayer)) {
			System.out.print("Your King is in jaque ");
			jaque=true;
		}
		System.out.print(currentPlayer+" turn ");
		System.out.println("From (row col):");
		Move move = new Move();
		String posicionInicial= input.nextLine();
		
		a:try {
		if(posicionInicial.contains(" ")) {
			Piece selectedPiece=null;
			String[] position = posicionInicial.trim().split(" ");
			int x = Integer.parseInt(position[0]);
			int y = Integer.parseInt(position[1]);
			if(x==9) {
				selectedPiece = board.ReInsertCapture(y, currentPlayer);
			if(selectedPiece==null) {
				break a;
			}	
			}
			
			else {		
				if(table[x][y].getPiece()=="  ") {
			System.out.println("There are no pieces here!");
				break a;
			}else
				selectedPiece = table[x][y];}
			
			
			
			if(selectedPiece.getColor()!=currentPlayer) {
				System.out.println("That's not your piece");
				break a;
			}
			move.isPromote(table, selectedPiece);
			System.out.println("You select "+selectedPiece.getPiece());
			System.out.println("NewPostion (row col):");
			String posicionNueva= input.nextLine();
			if(posicionNueva.contains(" ")) {
				
				String[] positionNueva = posicionNueva.trim().split(" ");
				int newX = Integer.parseInt(positionNueva[0]);
				int newY = Integer.parseInt(positionNueva[1]);
				
				if(x==9) {
					if(move.ReInsert(selectedPiece,x, y, newX, newY, table, currentPlayer,board, jaque)) {
						board.CaptureRemove(y, currentPlayer);
						if(currentPlayer=="white") {
							currentPlayer="black";
						}else {currentPlayer="white";}
					}
				}else {
				if(move.MoveOn(selectedPiece,x, y, newX, newY, table, currentPlayer,board,jaque)) {
				
					if(currentPlayer=="white") {
						currentPlayer="black";
					}else {currentPlayer="white";}
					
				}}
				
			
				
				
			}	
		}else {
			System.out.println("Please try again");
		} }catch(Exception e) {
			
			System.out.println("Please try again" );
		}
		
	}
		
	}public void killKing(Piece p) {
		if(p.getColor()=="white") {
			System.out.println("Black Wins" );
			salir=false;
		}else {System.out.println("White Wins" );
		salir=false;}
	}


	public boolean jaque( Board board, Piece[][] table,String player) {
		int newX=0;
		int newY=0;
		
		if(player =="white") {
		for(int i =0;i<9;i++) {
			for(int j=0;j<9;j++) {
			if(table[i][j].getPiece()=="KW") {
				newX=i;
				newY=j;
			}}}
		
		for(int i =0;i<9;i++) {
			for(int j=0;j<9;j++) {
				try{
					if((table[i][j].getColor()!="white")&&(table[i][j].getPiece()!="  ")) {
					if(table[i][j].validMoveSinMensajes(i, j, newX, newY, table, table[i][j].getColor(), table[i][j].getPromoted())) {
					return true;
				}}				
			}catch(Exception e) {
				
			}}}}
		else {
			for(int i =0;i<9;i++) {
			for(int j=0;j<9;j++) {
			if(table[i][j].getPiece()=="KB") {
				newX=i;
				newY=j;
			}}}
		
		for(int i =0;i<9;i++) {
			for(int j=0;j<9;j++) {
				try{
					if((table[i][j].getColor()!="black")&&(table[i][j].getPiece()!="  ")) {
					if(table[i][j].validMoveSinMensajes(i, j, newX, newY, table, table[i][j].getColor(), table[i][j].getPromoted())) {
				
					return true;
				}}				
			}catch(Exception e) {
				
			}}}
			
		}
			
		
		return false;
		
	}

}
