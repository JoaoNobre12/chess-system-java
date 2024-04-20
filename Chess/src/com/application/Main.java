package com.application;

import com.chess.ChessException;
import com.chess.ChessMatch;
import com.chess.ChessPiece;
import com.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);

		while (true){
			try{
				UI.clearScreen();
				UI.printMatch(chessMatch);
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
	}
}
