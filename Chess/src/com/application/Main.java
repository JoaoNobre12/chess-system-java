package com.application;

import com.boardgame.Board;
import com.boardgame.Position;

public class Main {
	public static void main(String[] args) {
		Position pos = new Position(3, 6);
		Board board = new Board(8, 8);
		
		System.out.println(pos);
	}
}
