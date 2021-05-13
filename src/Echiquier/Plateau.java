package Echiquier;

import Echec.IPiece;
import piece.*;

import java.util.ArrayList;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class Plateau {
    public static final int MIN = 1;
    public static final int MAX = 8;

    private ArrayList<IPiece> pieces = new ArrayList<>();
    private int gagnant = -1;
    private int compteur = 0;

    public Plateau() {

        pieces.add(PieceFactory.createPiece(Couleur.BLANC, TypesPieces.ROI, new Coords(1,5)));
        pieces.add(PieceFactory.createPiece(Couleur.NOIR, TypesPieces.ROI, new Coords(8, 4)));

    }

    public IPiece getPieceAtCoords(Coords coords) {

        for (IPiece p : pieces)
            if (p.isPieceInCoords(coords))
                return p;
        return null;
    }

    public boolean isCaseOccupee(Coords coords) {

        return getPieceAtCoords(coords) != null;
    }

    public void bouger(Coords oldCoords, Coords newCoords) {

        IPiece piece = this.getPieceAtCoords(oldCoords);
        if (piece == null)
            System.out.println("Impossible de trouver la pièce aux coords " + oldCoords);
        else if (piece.peutAllerEn(newCoords, this)){
            piece.setPos(newCoords);
            compteur++;
        }
        else
            System.out.println("rien");
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append("    a   b   c   d   e   f   g   h\n");
        Coords coords;
        for (int i = MAX - 1; i >= 0; i--) {
            sB.append("   --- --- --- --- --- --- --- ---\n");
            for (int j = 0; j < MAX; j++) {
                if (j == 0) {
                    sB.append(i + 1).append(" ");
                    sB.append("| ");
                } else
                    sB.append(" ");
                coords = new Coords(i + 1, j + 1);
                if (isCaseOccupee(coords))
                    sB.append(getPieceAtCoords(coords));
                else
                    sB.append(" ");

                sB.append(" |");
                if (j == MAX - 1)
                    sB.append(" ").append(i + 1);
            }
            sB.append("\n");
        }
        sB.append("   --- --- --- --- --- --- --- ---\n");
        sB.append("    a   b   c   d   e   f   g   h\n");
        return sB.toString();
    }

    public boolean gagnantExistant() {
        return gagnant != -1;
    }

    public boolean isCaseSafe(Coords coords, Couleur couleur){
        for (IPiece p : pieces) {
            if(p.getCouleur() != couleur && p.menace(coords))
                return false;
        }
        return true;
    }

}
