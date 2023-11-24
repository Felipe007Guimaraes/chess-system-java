package org.felipeGuimaraes.project.chess;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Piece;
import org.felipeGuimaraes.project.boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }
}
