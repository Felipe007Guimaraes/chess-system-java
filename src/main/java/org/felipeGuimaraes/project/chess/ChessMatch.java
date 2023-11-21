package org.felipeGuimaraes.project.chess;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.chess.pieces.King;
import org.felipeGuimaraes.project.chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch (){
        board = new Board(8, 8);
        InitialSetup();
    }

    public ChessPiece [][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j< board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
    }

    private void InitialSetup(){
        placeNewPiece('a',1,new Rook(board,Color.WHITE));
        placeNewPiece('a',8,new Rook(board,Color.BLACK));
        placeNewPiece('e',8,new King(board,Color.BLACK));
        placeNewPiece('e',1,new King(board,Color.WHITE));
    }
}
