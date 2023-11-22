package org.felipeGuimaraes.project.chess.pieces;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.chess.ChessPiece;
import org.felipeGuimaraes.project.chess.Color;

public class King extends ChessPiece {

    public King (Board board, Color color){
        super(board,color);
    }

    @Override
    public String toString(){
        return "K";
    }
}
