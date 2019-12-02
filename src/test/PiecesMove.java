package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Pieces.Piece;

class PiecesMove {
	Piece piece = new Pieces.NullPiece(null,null);
	Piece[][] table = new Piece[9][9];
	String color= "";
	Boolean promoted= false;
	
	@Test
	void MoveTestPeon() {
		piece = new Pieces.Pawn("PW", "white");
		color="white";
		Boolean result = piece.validMove(5, 0, 6, 0, table, color, promoted);
		assertTrue(result);
		
	}
	@Test
	void MoveTestGold() {
		piece = new Pieces.Gold("GW", "white");
		color="white";
		Boolean result = piece.validMove(2, 0, 3, 0, table, color, promoted);
		assertTrue(result);
		
	}
	@Test
	void MoveTestKing() {
		piece = new Pieces.King("PW", "white");
		color="white";
		Boolean result = piece.validMove(4, 0, 3, 0, table, color, promoted);
		assertTrue(result);
		
	}
	@Test
	void MoveTestKnight() {
		piece = new Pieces.Knight("CW", "white");
		color="white";
		Boolean result = piece.validMove(2, 0, 4, 1, table, color, promoted);
		assertTrue(result);
		
	}
	@Test
	void MoveTestBishop() {
		piece = new Pieces.Bishop("BW", "white");
		color="white";
		Boolean result = piece.validMove(2, 1, 3, 2, table, color, promoted);
		assertTrue(result);
		
	}
	@Test
	void MoveTestRook() {
		piece = new Pieces.Rook("RB", "black");
		color="black";
		promoted=false;
		Boolean result = piece.validMove(3, 1, 4, 1, table, color, promoted);
		assertTrue(result);
		
	}
	@Test
	void MoveTestPeonPromoted() {
		piece = new Pieces.Pawn("PW", "white");
		color="white";
		promoted=true;
		Boolean result = piece.validMove(2, 0, 1, 0, table, color, promoted);
		assertTrue(result);
		
	}
}
