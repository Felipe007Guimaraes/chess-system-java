package org.felipeGuimaraes.project.chess.pieces;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Position;
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

    private boolean canMove (Position position){
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        var aux = new Position(0,0);
        //above
        aux.setValue(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //below
        aux.setValue(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //left
        aux.setValue(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //right
        aux.setValue(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //NW
        aux.setValue(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //NE
        aux.setValue(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //SW
        aux.setValue(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //SE
        aux.setValue(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(aux) && canMove(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }



        return mat;
    }
}
