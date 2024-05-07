package com.application;

import com.chess.ChessException;
import com.chess.ChessMatch;
import com.chess.ChessPiece;
import com.chess.ChessPosition;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.getCheckMate()){
			try{
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(new Scanner(System.in));

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

				if (capturedPiece != null)
					captured.add(capturedPiece);

				if (chessMatch.getPromoted() != null){
					String piece = "";
					do {
						System.out.println("Type the piece you want to promote: (Q, R, B, N)");
						piece = sc.nextLine();
					}
					while (!piece.equals("Q") && !piece.equals("R") && !piece.equals("B") &&
							!piece.equals("N"));
					chessMatch.replacePromotedPiece(piece);
				}
			}
			catch (ChessException | InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (Exception e){
				System.out.println(e.getMessage());
				break;
			}
		}

		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
