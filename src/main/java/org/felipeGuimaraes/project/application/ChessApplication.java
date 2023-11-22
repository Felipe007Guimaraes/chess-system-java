package org.felipeGuimaraes.project.application;

import org.felipeGuimaraes.project.chess.ChessMatch;
import org.felipeGuimaraes.project.chess.ChessPiece;
import org.felipeGuimaraes.project.chess.ChessPosition;
import org.felipeGuimaraes.project.exceptions.ChessException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessApplication {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}