package org.felipeGuimaraes.project.Chess;

import org.felipeGuimaraes.project.Boardgame.Board;
import org.felipeGuimaraes.project.Boardgame.Piece;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return color;
    }
}
