package org.felipeGuimaraes.project.Application;

import org.felipeGuimaraes.project.Boardgame.Position;
import org.felipeGuimaraes.project.Chess.ChessMatch;
import org.felipeGuimaraes.project.Chess.ChessPiece;

public class ChessApplication {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}