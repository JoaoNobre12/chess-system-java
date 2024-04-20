package com.application;

import com.chess.ChessMatch;
import com.chess.ChessPiece;
import com.chess.ChessPosition;
import com.chess.enums.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private UI(){}

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printMatch(ChessMatch chessMatch){
        printBoard(chessMatch.getPieces());
        System.out.println("\nTurn: " + chessMatch.getTurn());
        System.out.println("Waiting player: "+chessMatch.getCurrentPlayer());

    }
    public static ChessPosition readChessPosition(Scanner sc){
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(Character.toString(s.charAt(1)));
            return new ChessPosition(column, row);
        }
        catch (RuntimeException e){
            throw new InputMismatchException("Error while instantiating ChessPosition: a1 to h8 only.");
        }
    }

    public static void printBoard(ChessPiece[][] chessPieces){
        int rowsNumber = chessPieces.length;
        int columnsNumber = chessPieces[0].length;

        for(int i = 0; i<rowsNumber; i++){
            System.out.printf(" %d ",((rowsNumber) - i));
            for (int j = 0; j<columnsNumber; j++){
                printPiece(chessPieces[i][j], false);
            }
            System.out.println();
        }
        char ch = 'a';
        int charIndex = 0;
        System.out.print("   ");
        do {
            System.out.printf("%c ", ch);
            ch++;
            charIndex++;
        }while (charIndex < columnsNumber);
    }

    public static void printBoard(ChessPiece[][] chessPieces, boolean[][] possibleMoves){
        int rowsNumber = chessPieces.length;
        int columnsNumber = chessPieces[0].length;

        for(int i = 0; i<rowsNumber; i++){
            System.out.printf(" %d ",((rowsNumber) - i));
            for (int j = 0; j<columnsNumber; j++){
                printPiece(chessPieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        char ch = 'a';
        int charIndex = 0;
        System.out.print("   ");
        do {
            System.out.printf("%c ", ch);
            ch++;
            charIndex++;
        }while (charIndex < columnsNumber);
    }

    private static void printPiece(ChessPiece piece, boolean bg) {
        if(bg){
            System.out.print(ANSI_BLACK_BACKGROUND);
        }

        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
}
