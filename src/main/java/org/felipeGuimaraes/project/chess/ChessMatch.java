package org.felipeGuimaraes.project.chess;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Piece;
import org.felipeGuimaraes.project.boardgame.Position;
import org.felipeGuimaraes.project.chess.pieces.King;
import org.felipeGuimaraes.project.chess.pieces.Rook;
import org.felipeGuimaraes.project.exceptions.ChessException;

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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece)capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
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
