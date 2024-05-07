package com.chess;

import com.boardgame.Position;

public class ChessPosition {
    private int row;
    private char column;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8)
            throw new ChessException("Error while instantiating ChessPosition: a1 to h8 only.");
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + this.column + this.row;
    }
}
