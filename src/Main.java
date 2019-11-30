import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Pieces.Piece;

public class Main {
	public static  String currentPlayer ="white";
	
	public static void main(String[] args) {
		Main main = new Main();
		main.Game();
		
		
		
	}
public void Game() {
	Board board = new Board();
	
	Scanner input = new Scanner(System.in);
	Piece table[][] = new Piece [9][9];
	Boolean salir = true;
	board.fillBoard(table);
	board.initCapture();
	while (salir) {
		
		board.PrintBoard(table);
		System.out.print(currentPlayer+" turn ");
		System.out.println("From (row col):");
		Move move = new Move();
		String posicionInicial= input.nextLine();
		
		try {
		if(posicionInicial.contains(" ")) {
			String[] position = posicionInicial.trim().split(" ");
			int x = Integer.parseInt(position[0]);
			int y = Integer.parseInt(position[1]);
			Piece selectedPiece = table[x][y];
			move.isPromote(table, selectedPiece);
			System.out.println("You select "+selectedPiece.getPiece());
			System.out.println("NewPostion (row col):");
			String posicionNueva= input.nextLine();
			if(posicionNueva.contains(" ")) {
				
				String[] positionNueva = posicionNueva.trim().split(" ");
				int newX = Integer.parseInt(positionNueva[0]);
				int newY = Integer.parseInt(positionNueva[1]);
				move.MoveOn(selectedPiece,x, y, newX, newY, table, currentPlayer);
				if(currentPlayer=="white") {
					currentPlayer="black";
				}else {currentPlayer="white";}
				
				
			}	
		}else {
			System.out.println("Please try again");
		} }catch(Exception e) {
			
			System.out.println("Please try again" );
		}
		
	}
		
	}

	

}
