package org.felipeGuimaraes.project.chess;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Position;
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

    private void InitialSetup(){
        board.placePiece(new Rook(board,Color.WHITE),new Position(2,1));
        board.placePiece(new King(board,Color.BLACK),new Position(0,4));
        board.placePiece(new King(board,Color.WHITE),new Position(7,4));
    }
}
