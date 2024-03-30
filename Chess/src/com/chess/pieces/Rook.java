package com.chess.pieces;

import com.boardgame.Board;
import com.chess.ChessPiece;
import com.chess.enums.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }
}
