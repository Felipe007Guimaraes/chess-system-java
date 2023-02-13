package org.felipeGuimaraes.project.boardgame;

public class Board {
    private int columns;
    private int rows;
    private Piece [][] pieces;

    public Board (int columns, int rows){
        this.columns = columns;
        this.rows = rows;
        pieces = new Piece[columns][rows];
    }

    public int getColumns(){
        return columns;
    }

    public void setColumns(int columns){
        this.columns = columns;
    }

    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public Piece piece(int columns, int rows){
        return pieces [rows][columns];
    }

    public Piece piece(Position position){
        return pieces [position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
