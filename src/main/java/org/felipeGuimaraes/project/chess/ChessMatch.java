package org.felipeGuimaraes.project.chess;

import org.felipeGuimaraes.project.boardgame.Board;
import org.felipeGuimaraes.project.boardgame.Piece;
import org.felipeGuimaraes.project.boardgame.Position;
import org.felipeGuimaraes.project.chess.pieces.King;
import org.felipeGuimaraes.project.chess.pieces.Rook;
import org.felipeGuimaraes.project.exceptions.ChessException;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;

    public ChessMatch (){
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        InitialSetup();
    }

    public Color getCurrentPlayer(){
       return currentPlayer;
    }

    public int getTurn(){
        return turn;
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

    public boolean[][] possiblesMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
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
        if(currentPlayer!=((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("The chosen piece is not yours");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    public void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMoves(target)) {
            throw new ChessException("The chosen piece can't move target position");
        }
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK:Color.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column,row).toPosition());
    }

    private void InitialSetup(){
        placeNewPiece('a',1,new Rook(board,Color.WHITE));
        placeNewPiece('h',1,new Rook(board,Color.WHITE));
        placeNewPiece('e',1,new King(board,Color.WHITE));

        placeNewPiece('a',8,new Rook(board,Color.BLACK));
        placeNewPiece('h',8,new Rook(board,Color.BLACK));
        placeNewPiece('e',8,new King(board,Color.BLACK));
    }
}
