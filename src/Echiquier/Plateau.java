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

    private int gagnant = -1;

    public Plateau(){
        piecesBlanches.add(new Roi(new Coords(5,1)) {
        });
        piecesNoires.add(new Roi(new Coords(4,8)) {
        });
    }

    private IPiece getPieceAtCoords(Coords coords){

        for(IPiece p : piecesBlanches)
            if (p.isPieceInCoords(coords))
                return p;

        for(IPiece p : piecesNoires)
            if (p.isPieceInCoords(coords))
                return p;

        return null;
    }

    private boolean isCaseOccupee(Coords coords){

        return getPieceAtCoords(coords) != null;
    }

    public void bouger(String s, Coords coords){
        for (IPiece p : piecesBlanches) {
            if (p.toString().equals(s) && p.peutAllerEn(coords))
                p.setPos(coords);
            return;
            }
       for (IPiece p : piecesNoires) {
           if (p.toString().equals(s) && p.peutAllerEn(coords)){
               p.setPos(coords);
            return;
           }
       }
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append("    a   b   c   d   e   f   g   h\n");
        Coords coords;
        for (int i = MAX-1; i>=0; i--){
            sB.append("   --- --- --- --- --- --- --- ---\n");
            for(int j = 0; j<MAX; j++){
                if (j == 0) {
                    sB.append(i + 1).append(" ");
                    sB.append("| ");
                }
                else
                    sB.append(" ");
                coords = new Coords(j+1,i+1);
                if (isCaseOccupee(coords))
                    sB.append(getPieceAtCoords(coords));
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
    public boolean gagnantExistant(){
        return gagnant != -1;
    }
}
