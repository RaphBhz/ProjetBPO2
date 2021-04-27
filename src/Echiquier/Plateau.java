package Echiquier;

import piece.Piece;

import java.util.ArrayList;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class Plateau {
    private static final int MIN = 1;
    private static final int MAX = 8;

    private ArrayList<Piece> piecesBlanches = new ArrayList<>();
    private ArrayList<Piece> piecesNoires = new ArrayList<>();

    private Piece getPieceAtCoords(int colonne, int ligne){

        for(Piece p : piecesBlanches)
            if (p.isPieceInCoords(colonne, ligne))
                return p;

        for(Piece p : piecesNoires)
            if (p.isPieceInCoords(colonne, ligne))
                return p;

        return null;
    }

    private boolean isCaseOccupee(int colonne, int ligne){

        return getPieceAtCoords(colonne, ligne) != null;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append("    a   b   c   d   e   f   g   h\n");
        for (int i = MAX-1; i>=0; i--){
            sB.append("   --- --- --- --- --- --- --- ---\n");
            for(int j = 0; j<MAX; j++){
                if (j == 0) {
                    sB.append(i + 1).append(" ");
                    sB.append("| ");
                }
                else
                    sB.append(" ");

                if (isCaseOccupee(i,j))
                    sB.append(getPieceAtCoords(i,j));
                else
                    sB.append(" ");

                sB.append(" |");
                if (j == MAX-1)
                    sB.append(" ").append(i+1);
            }
            sB.append("\n");
        }
        sB.append("   --- --- --- --- --- --- --- ---\n");
        sB.append("    a   b   c   d   e   f   g   h\n");
        return sB.toString();
    }
}
