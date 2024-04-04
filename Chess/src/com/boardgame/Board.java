package com.boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1){
			throw new BoardException("Error while creating board: there must be at least one line or column.");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}
	
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column){
		if(Boolean.FALSE.equals(positionExists(row, column)))
			throw new BoardException("Position not on the Board.");

		return pieces[row][column];
	}

	public Piece piece(Position position){
		if(Boolean.FALSE.equals(positionExists(position)))
			throw new BoardException("Position not on the Board.");
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position){
		if (Boolean.TRUE.equals(thereIsAPiece(position)))
			throw new BoardException("There is already a piece in position ("+position+")");

		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private Boolean positionExists(int row, int column){
		return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
	}
	public Boolean positionExists(Position position){
		return positionExists(position.getRow(), position.getColumn());
	}

	public Boolean thereIsAPiece(Position position){
		if(Boolean.FALSE.equals(positionExists(position)))
			throw new BoardException("Position not on the Board.");
		return piece(position) != null;
	}
}
