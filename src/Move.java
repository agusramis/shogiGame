import java.util.Scanner;

import Pieces.Piece;

public class Move {
	public Move() {
	}

	public Piece MoveOn(Piece selectedPiece, int x, int y, int newX, int newY, Piece[][] table, String player) {

		if (isPromote(table, selectedPiece)) {
			System.out.println("Do you want to promote your piece " + selectedPiece.getPiece() + " ?");
		}
		if (selectedPiece.validMove(x, y, newX, newY, table, selectedPiece.getColor(), selectedPiece.getPromoted())) {
			if (table[newX][newY].getColor() != selectedPiece.getColor()) {
				if(table[x][y]!=null) {
					Board capture = new Board();
					capture.fillCapture(table[x][y]);
				}
				table[x][y] = new Pieces.NullPiece(null, " ", x, y);
				
				table[newX][newY] = selectedPiece;
				Promote(table, selectedPiece);

				return selectedPiece;
			} else {

				System.out.println("You can´t eat your own piece");
				return selectedPiece;
			}
		} else {

			return selectedPiece;
		}

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
							piece.setPiece(piece.getPiece() + "+");
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
		
		if ((color == "black") && ((piece.getPiece()!="KB")&&(piece.getPiece()!="GB"))) {
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table.length; j++) {
					if (piece == table[0][j] || piece == table[1][j] || piece == table[2][j]) {
						return true;
					}
				}
			}
		}
		else if ((color == "white") && ((piece.getPiece()!="KW")&&(piece.getPiece()!="GW"))) {
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table.length; j++) {
					if (piece == table[6][j] || piece == table[7][j] || piece == table[8][j]) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
