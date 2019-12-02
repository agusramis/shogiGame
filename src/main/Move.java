package main;
import java.util.Scanner;

import Pieces.Piece;

public class Move {
	public Move() {
	}

	public Boolean MoveOn(Piece selectedPiece, int x, int y, int newX, int newY, Piece[][] table, String player,
			Board capture, Boolean jaque) {
		if((selectedPiece.getPiece()!="PW")&&(selectedPiece.getPiece()!="PB")&&(selectedPiece.getPiece()!="LB")&&(selectedPiece).getPiece()!="LW")
			{		Promote(table, selectedPiece);}
			
		
		if (selectedPiece.validMove(x, y, newX, newY, table, selectedPiece.getColor(), selectedPiece.getPromoted())) {
			if (table[newX][newY].getColor() != selectedPiece.getColor()) {

				table[x][y] = new Pieces.NullPiece(null, null);
				if (table[newX][newY].getPiece() != "  ") {
					if((table[newX][newY].getPiece()=="KW")||(table[newX][newY].getPiece()=="KB")) {
						Main main = new Main();
						main.killKing(table[newX][newY]);
						return false;
					}
					capture.fillCapture(table[newX][newY]);
				}
				if(jaque) {
					Main main= new Main();
					if(main.jaque(capture, table, player)) {
						table[x][y]= selectedPiece;
						return false;
					}else table[newX][newY] = selectedPiece;;
				}
				Main main = new Main();
				
				table[newX][newY] = selectedPiece;
				if(main.jaque(capture, table, player)) {
					
					table[newX][newY] = new Pieces.NullPiece(null, null);
					table[x][y]= selectedPiece;
					System.out.println("You can´t Move Here because you will be in jaque ");
					return false;
				}
				Promote(table, selectedPiece);

				return true;
			} else {

				System.out.println("You can´t eat your own piece");
				return false;
			}
		} else {

			return false;
		}

	}

	public Boolean ReInsert(Piece selectedPiece, int x, int y, int newX, int newY, Piece[][] table, String player,
			Board board, Boolean jaque) {
		if (player == "white") {
			if (table[newX][newY].getPiece() == "  ") {
				if (selectedPiece.getPiece() == "PW") {
					for (int i = 0; i < 9; i++) {

						if (table[i][newY].getPiece() == "PW") {
							System.out.println("There is another PW in this col ");
							return false;
						}
						if(table[newX][newY]==table[8][i]) {
							System.out.println("You can´t put PW in this row ");
							return false;
						}
					}
					if(jaque) {
						Main main= new Main();
						if(main.jaque(board, table, player)) {
							System.out.println("Your King is under atack ");
						return false;
						}else table[newX][newY] = selectedPiece;
						return true;
					}else 
					table[newX][newY] = selectedPiece;
					return true;
				}
				if(selectedPiece.getPiece() == "CW") {
					for (int i = 0; i < 9; i++) {
					if((table[newX][newY]==table[8][i])||(table[newX][newY]==table[7][i])) {
					System.out.println("You can´t put CW in this row ");
					return false;}
				}}
				if(selectedPiece.getPiece() == "LW"){for (int i = 0; i < 9; i++) {
					if((table[newX][newY]==table[8][i])) {
					System.out.println("You can´t put LW in this row ");
					return false;}
				}}if(jaque) {
					Main main= new Main();
					if(main.jaque(board, table, player)) {
						System.out.println("Your King is under atack ");
					return false;
					}else table[newX][newY] = selectedPiece; return true;
				}
				table[newX][newY] = selectedPiece;
				return true;
			}System.out.println("There is a piece in this position ");
			return false;
		} else if (player == "black") {
			if (table[newX][newY].getPiece() == "  ") {
				if (selectedPiece.getPiece() == "PB") {
					for (int i = 0; i < 9; i++) {

						if (table[i][newY].getPiece() == "PB") {
							System.out.println("There is another PB in this col ");
							return false;
						}
						if(table[newX][newY]==table[0][i]) {
							System.out.println("You can´t put PW in this row ");
							return false;
						}
					}if(jaque) {
						Main main= new Main();
						if(main.jaque(board, table, player)) {
							System.out.println("Your King is under atack ");
						return false;
						}else table[newX][newY] = selectedPiece; return true;
					}
					table[newX][newY] = selectedPiece;
					return true;
				}
				if(selectedPiece.getPiece() == "LB") {
					for (int i = 0; i < 9; i++) {
					if(table[newX][newY]==table[0][i]) {
					System.out.println("You can´t put LB in this row ");
					return false;}
				}}
				if(selectedPiece.getPiece() == "CB") {
					for (int i = 0; i < 9; i++) {
						if((table[newX][newY]==table[0][i])||(table[newX][newY]==table[1][i])) {
						System.out.println("You can´t put CB in this row ");
						return false;}
					}
					
				}if(jaque) {
					Main main= new Main();
					if(main.jaque(board, table, player)) {
						
					return false;
					}else table[newX][newY] = selectedPiece; return true;
				}
				table[newX][newY] = selectedPiece;
				return true;
			}System.out.println("There is a piece in this position ");
			return false;
		}
		return false;

	}

	public void Promote(Piece[][] table, Piece piece) {
		if ((isPromote(table, piece)) && (piece.getPromoted() == false)) {
			Scanner input = new Scanner(System.in);
			int response = 0;
			boolean loop = true;
			while (loop) {	
				System.out.println("Do you want to promote your piece " + piece.getPiece() + " ?");
				System.out.println("1:YES, 2:NO");
				if (!input.hasNextInt() || !input.hasNext()) {
					System.out.println("Oops! ");
					input.nextLine();
				} else {
					response = input.nextInt();
					if (response <= 2 && response >= 1) {
						if (response == 1) {
							piece.setPromoted(true);
							loop = false;
						} else
							loop = false;
					}

					else {
						System.out.println("Only accept 1 or 2");
						input.nextLine();
					}
				}
			}

		}
	}

	public Boolean isPromote(Piece[][] table, Piece piece) {
		String color = piece.getColor();

		if ((color == "black") && ((piece.getPiece() != "KB") && (piece.getPiece() != "GB"))) {
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table.length; j++) {
					if (piece == table[0][j] || piece == table[1][j] || piece == table[2][j]) {
						if((piece.getPiece()=="BB"||piece.getPiece()=="LB")&&piece==table[0][j]) {
							piece.setPromoted(true);
							return false;
							
						}
						if((piece.getPiece()=="CB")&&(piece==table[1][j]||piece==table[0][j])) {
							piece.setPromoted(true);
							return false;
						}
						return true;
					}
				}
			}
		} else if ((color == "white") && ((piece.getPiece() != "KW") && (piece.getPiece() != "GW"))) {
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table.length; j++) {
					if (piece == table[6][j] || piece == table[7][j] || piece == table[8][j]) {
						if((piece.getPiece()=="BW"||piece.getPiece()=="LW")&&piece==table[8][j]) {
							piece.setPromoted(true);
							return false;
							
						}	if((piece.getPiece()=="CW")&&(piece==table[1][j]||piece==table[0][j])) {
							piece.setPromoted(true);
							return false;
						}
						
						return true;
					}
				}
			}
		}
		return false;
	}
}
