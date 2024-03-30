package com.application;

import com.chess.ChessPiece;

public class UI {
    private UI(){}
    public static void printBoard(ChessPiece[][] chessPieces){
        int rowsNumber = chessPieces.length;
        int columnsNumber = chessPieces[0].length;

        for(int i = 0; i<rowsNumber; i++){
            System.out.printf(" %d ",((rowsNumber) - i));
            for (int j = 0; j<columnsNumber; j++){
                printPiece(chessPieces[i][j]);
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

    private static void printPiece(ChessPiece piece){
        if (piece == null){
            System.out.print('-');
        }
        else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }
}
