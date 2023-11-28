package org.felipeGuimaraes.project.chess.pieces;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Position;
import org.felipeGuimaraes.project.chess.ChessPiece;
import org.felipeGuimaraes.project.chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        var aux = new Position(0,0);

        //NE
        aux.setValue(position.getRow() - 1,position.getColumn() + 1);

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setValue(aux.getRow() - 1, aux.getColumn() + 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //NW
        aux.setValue(position.getRow() - 1,position.getColumn() - 1);

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setValue(aux.getRow() - 1, aux.getColumn() - 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //SE
        aux.setValue(position.getRow() + 1,position.getColumn() + 1);

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setValue(aux.getRow() + 1, aux.getColumn() + 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //SW
        aux.setValue(position.getRow() + 1,position.getColumn() - 1);

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setValue(aux.getRow() + 1, aux.getColumn() - 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        return mat;
    }
}
