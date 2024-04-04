package com.chess;

import com.boardgame.Board;
import com.boardgame.Position;
import com.chess.enums.Color;
import com.chess.pieces.King;
import com.chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    // TODO create exception for board bigger than 26
    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i=0; i< board.getRows(); i++){
            for(int j=0; j< board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }

        return mat;
    }

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,1));
        board.placePiece(new King(board, Color.WHITE), new Position(0,4));

    }
}
