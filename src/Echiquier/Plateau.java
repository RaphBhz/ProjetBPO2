package Echiquier;

import Echec.IPiece;
import piece.*;

import java.util.ArrayList;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class Plateau {
    private static final int MIN = 1;
    private static final int MAX = 8;

    private ArrayList<IPiece> piecesBlanches = new ArrayList<>();
    private ArrayList<IPiece> piecesNoires = new ArrayList<>();

    public Plateau(){
        piecesBlanches.add(new Roi(5, 1) {
        });
        piecesNoires.add(new Roi(4, 8) {
        });
    }

    private IPiece getPieceAtCoords(int colonne, int ligne){

        for(IPiece p : piecesBlanches)
            if (p.isPieceInCoords(colonne, ligne))
                return p;

        for(IPiece p : piecesNoires)
            if (p.isPieceInCoords(colonne, ligne))
                return p;

        return null;
    }

    private boolean isCaseOccupee(int colonne, int ligne){

        return getPieceAtCoords(colonne, ligne) != null;
    }

    public void bouger(String s, int colonne, int ligne){
        for (IPiece p : piecesBlanches) {
            if (p.toString().equals(s) && p.peutAllerEn(colonne, ligne))
                p.move(colonne, ligne);
        }
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

                if (isCaseOccupee(j+1,i+1))
                    sB.append(getPieceAtCoords(j+1,i+1));
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
