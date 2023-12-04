package org.felipeGuimaraes.project.chess.pieces;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Position;
import org.felipeGuimaraes.project.chess.ChessPiece;
import org.felipeGuimaraes.project.chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        var aux = new Position(0,0);

        //below
        aux.setValue(position.getRow() + 1,position.getColumn());

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setRow(aux.getRow() + 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //above
        aux.setValue(position.getRow() - 1,position.getColumn());

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setRow(aux.getRow() - 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //left
        aux.setValue(position.getRow(),position.getColumn() - 1);

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setColumn(aux.getColumn() - 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

        //right
        aux.setValue(position.getRow(),position.getColumn() + 1);

        while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
            aux.setColumn(aux.getColumn() + 1);
        }
        if(getBoard().positionExists(aux) && isThereOpponentPiece(aux)){
            mat[aux.getRow()][aux.getColumn()] = true;
        }

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
