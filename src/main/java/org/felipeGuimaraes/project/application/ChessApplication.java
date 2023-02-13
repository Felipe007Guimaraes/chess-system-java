package org.felipeGuimaraes.project.application;

import org.felipeGuimaraes.project.chess.ChessMatch;

public class ChessApplication {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}