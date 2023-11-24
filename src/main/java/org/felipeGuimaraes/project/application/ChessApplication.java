package org.felipeGuimaraes.project.application;

import org.felipeGuimaraes.project.chess.ChessMatch;
import org.felipeGuimaraes.project.chess.ChessPiece;
import org.felipeGuimaraes.project.chess.ChessPosition;
import org.felipeGuimaraes.project.exceptions.ChessException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChessApplication {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();


        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possiblesMoves = chessMatch.possiblesMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possiblesMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
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