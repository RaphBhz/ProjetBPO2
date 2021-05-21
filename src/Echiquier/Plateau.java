package Echiquier;

import Echec.IPiece;
import joueur.IPlayer;
import piece.*;
import utilitaire.Coords;
import utilitaire.PaireCoords;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class Plateau {
    public static final int MIN = 1;
    public static final int MAX = 8;

    private IPlayer joueurs[] = new IPlayer[2];

    private ArrayList<IPiece> pieces = new ArrayList<>();
    private int gagnant = -1;
    private int nbTour = 0;

    public Plateau(IPlayer joueur1, IPlayer joueur2) {
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;


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
            nbTour++;
        }
        else
            System.out.println("rien");
    }

    /**
     * Permet de jouer un coup
     * @return Une string du déplacement effectué ou bien une erreur
     */
    public PaireCoords play(){

        PaireCoords paireCoords = joueurs[nbTour%2].play(this);

        while (!this.canCoordsBePlayed(paireCoords))
            paireCoords = joueurs[nbTour%2].play(this);

        if (this.isCaseOccupee(paireCoords.getCoordsFin()))
            pieces.remove(getPieceAtCoords(paireCoords.getCoordsFin()));

        this.getPieceAtCoords(paireCoords.getCoordsDepart()).setPos(paireCoords.getCoordsFin());
        return paireCoords;
    }

    private boolean canCoordsBePlayed(PaireCoords paireCoords) {
        System.out.println(paireCoords.getCoordsDepart());

        if (!isCaseOccupee(paireCoords.getCoordsDepart())) { // S'il n'y a pas de pièce aux premières coords précisées
            System.out.println("canCoordsBePlayed Erreur 1");
            return false;
        }
        if (getPieceAtCoords(paireCoords.getCoordsDepart()).getCouleur() != joueurs[nbTour % 2].getCouleur()) { // Si la première pièce précisée n'est pas de la couleur du joueur
            System.out.println("canCoordsBePlayed Erreur 2");
            return false;
        }

        if (!canPiecePlayCoords(paireCoords)) { // toute la logique de la pièce se fait ici
            System.out.println("canCoordsBePlayed Erreur 3");
            return false;
        }
        if (isCaseOccupee(paireCoords.getCoordsFin())) // Si la case d'arrivée possède une pièce, vérifier qu'elle n'est pas de la couleur du joueur
            return getPieceAtCoords(paireCoords.getCoordsFin()).getCouleur() != joueurs[nbTour % 2].getCouleur();

        return true;

    }

    public boolean canPiecePlayCoords(PaireCoords paireCoords){
        IPiece piece = getPieceAtCoords(paireCoords.getCoordsDepart());
        return piece.peutAllerEn(paireCoords.getCoordsFin(), this);

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

    public int getNbTour(){
        return this.nbTour;
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

    public void removePiece(IPiece piece){
        this.pieces.remove(piece);
    }

    public PaireCoords getOneCoupPossible(Couleur couleur){
        Random random = new Random();
        ArrayList<PaireCoords> allCoups = getAllCoupPossible(couleur);
        return allCoups.get(random.nextInt(allCoups.size()));
    }

    private ArrayList<PaireCoords> getAllCoupPossible(Couleur couleur){
        ArrayList<PaireCoords> tabCoordsPossibles = new ArrayList<>();
        for (IPiece piece : pieces) {
            if (piece.getCouleur() == couleur)
                tabCoordsPossibles.addAll(getAllCoupFromOnePiece(piece));
        }

        return tabCoordsPossibles;
    }

    private ArrayList<PaireCoords> getAllCoupFromOnePiece(IPiece piece){
        ArrayList<PaireCoords> tabCoords = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            for (int j = MIN; j <= MAX; j++) {
                if (piece.peutAllerEn(new Coords(i,j), this))
                    tabCoords.add(new PaireCoords(new Coords(piece.getCoords()), new Coords(i,j)));

            }

        }
        return tabCoords;
    }
}
