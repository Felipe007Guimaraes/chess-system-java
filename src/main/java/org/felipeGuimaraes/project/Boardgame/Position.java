package org.felipeGuimaraes.project.Boardgame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {
    private int column;
    private int row;

    @Override
    public String toString() {
        return row+", "+column;
    }
}
