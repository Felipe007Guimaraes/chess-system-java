package org.felipeGuimaraes.project.chess.pieces;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Position;
import org.felipeGuimaraes.project.chess.ChessPiece;
import org.felipeGuimaraes.project.chess.Color;

public class Knight extends ChessPiece {

    public Knight (Board board, Color color){
        super(board,color);
    }

    @Override
    public String toString(){
        return "N";
    }

    private boolean canMove (Position position){
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        var aux = new Position(0,0);

        aux.setValue(position.getRow() - 1, position.getColumn() - 2);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValue(position.getRow() - 2, position.getColumn() - 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValue(position.getRow() - 2, position.getColumn() + 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValue(position.getRow() - 1, position.getColumn() + 2);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValue(position.getRow() + 1, position.getColumn() + 2);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValue(position.getRow() + 2, position.getColumn() + 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValue(position.getRow() + 2, position.getColumn() - 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        aux.setValue(position.getRow() + 1, position.getColumn() - 2);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        return mat;
    }
}
