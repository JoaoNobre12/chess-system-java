package com.chess.enums;

public enum Color {
    BLACK(0x000000),
    WHITE(0xFFFFFF);

    private final int hexCode;

    Color(int hexCode){
        this.hexCode = hexCode;
    }

    public int getColor(){
        return hexCode;
    }
}
