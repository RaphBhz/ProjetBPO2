package echiquier;

import echec.IPiece;
import echec.IJoueur;
import utilitaire.Coords;
import utilitaire.PaireCoords;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant un échiquier
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 27/04/2021
 */
public class Plateau {
    public static final int MIN = 1;
    public static final int MAX = 8;

    private IJoueur joueurs[] = new IJoueur[2];

    private ArrayList<IPiece> pieces = new ArrayList<>();
    private int gagnant = -1;
    private int nbTour = 0;

    /**
     * Constructeur du plateau
     * @param joueur1 Le joueur blanc
     * @param joueur2 Le joueur noir
     */
    public Plateau(IJoueur joueur1, IJoueur joueur2) {
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;

        for (TypesPieces type : TypesPieces.values())
            addAllPiecesFromType(type);
    }

    /**
     * Permet d'ajouter toutes les pièces au plateau
     * @param type Le type de la pièce
     */
    private void addAllPiecesFromType(TypesPieces type){
        if (type == TypesPieces.ROI) {
            pieces.add(FabriquePiece.createPiece(Couleur.BLANC, TypesPieces.ROI, new Coords(1,5)));
            pieces.add(FabriquePiece.createPiece(Couleur.NOIR, TypesPieces.ROI, new Coords(8, 4)));
            return;
        }

        for(int i = 0; i<type.getNbPiece(); i++) {
            addPieceAtFreeCoords(type, Couleur.BLANC);
            addPieceAtFreeCoords(type, Couleur.NOIR);
        }
    }

    /**
     * Ajoute une pièce à une coordonnée libre et qui ne met pas en échec les rois
     * @param type Le type de la pièce
     * @param couleur La couleur de la pièce
     */
    private void addPieceAtFreeCoords(TypesPieces type, Couleur couleur){
        Random rdm = new Random();
        int x, y;
        IPiece piece;
        boolean checked = true;

        while(checked){
            x = rdm.nextInt(MAX) + 1;
            y = rdm.nextInt(MAX) + 1;
            if(isCaseOccupee(new Coords(x,y)))
                continue;

            piece = FabriquePiece.createPiece(couleur, type, new Coords(x,y));
            pieces.add(piece);

            if(isKingChecked(Couleur.NOIR) || isKingChecked(Couleur.BLANC)){
                pieces.remove(piece);
                continue;
            }

            checked = false;

        }

    }

    /**
     * Permet de récupérer une pièce aux coordonnées données
     * @param coords les coordonnées de la case pour laquelle on cherche la pièce
     * @return La pièce aux coordonnées données ou null s'il n'y a pas de pièce aux coordonnées données
     */
    private IPiece getPieceAtCoords(Coords coords) {

        for (IPiece p : pieces)
            if (p.isPieceInCoords(coords))
                return p;
        return null;
    }

    /**
     * Détermine si une case de l'échiquier possède une pièce
     * @param coords les coordonnées de la case pour laquelle on veut savoir s'il y a une pièce
     * @return true s'il y a une pièce sur la case, false dans le cas contraire
     */
    public boolean isCaseOccupee(Coords coords) {

        return getPieceAtCoords(coords) != null;
    }

    /**
     * Permet de jouer un coup
     * @return Les coordonnées du coup joué
     */
    public PaireCoords play(){

        PaireCoords paireCoords = joueurs[nbTour%2].play(this);

        while (!this.canCoordsBePlayed(paireCoords)) {
            paireCoords = joueurs[nbTour % 2].play(this);
        }

        if (this.isCaseOccupee(paireCoords.getCoordsFin())) {
            pieces.remove(getPieceAtCoords(paireCoords.getCoordsFin()));
        }

        this.getPieceAtCoords(paireCoords.getCoordsDepart()).setPos(paireCoords.getCoordsFin());
        this.nbTour++;

        this.isGameFinished();


        return paireCoords;
    }

    /**
     * Détermine si le roi du tour suivant est en échec et maths et donc si la partie est finie
     */
    private void isGameFinished(){
        if (isKingCheckedAndMate(joueurs[nbTour % 2 ].getCouleur())) {
            System.out.println("ECHEC ET MAT");
            this.gagnant = nbTour+1 % 2;
        }
        if (isGameTied()) {
            this.gagnant = -2;
        }

    }

    /**
     * Permet de détecter l'égalité
     * @return true si égalite, false dans le cas contraire
     */
    private boolean isGameTied(){

        if(!isKingChecked(joueurs[nbTour%2].getCouleur()) && getAllCoupFromOnePiece(getKing(joueurs[nbTour%2].getCouleur())).size() == 0) {
            for(int i = 0; i < pieces.size(); i++) {
                if(!(getAllCoupFromOnePiece(pieces.get(i)).size() == 0)){
                    return false;
                }
            }
            System.out.println("PAT");
            return true;
        }

        for(IPiece p : pieces)
            if(!p.craintEchec())
                return false;

        return true;
    }

    /**
     * Permet de savoir si le roi est en echec et maths
     * @param couleur La couleur du roi à check
     * @return true si le roi est échec et maths, false dans le cas contraire
     */
    private boolean isKingCheckedAndMate(Couleur couleur){
        IPiece roi = getKing(couleur);
        if (roi == null)
            return true;

        return isKingChecked(couleur) && getAllCoupFromOnePiece(roi).size() == 0;
    }

    /**
     * Détermine si le roi est en échec
     * @param couleur La couleur du roi à check
     * @return true si le roi est en position d'échec, false dans le cas contraire
     */
    private boolean isKingChecked(Couleur couleur){
        IPiece roi = getKing(couleur);
        if (roi == null)
            return true;

        for (IPiece piece : pieces) {
            if (piece.getCouleur() == couleur)
                continue;

            if (piece.peutAllerEn(roi.getCoords(), this))
                return true;
        }

        return false;

    }

    /**
     * Récupère le roi en fonction de la couleur
     * @param couleur la couleur du roi
     * @return le roi de la couleur ou null si le roi n'a pas été trouvé
     */
    private IPiece getKing(Couleur couleur){
        for (IPiece piece : pieces) {
            if (piece.getCouleur() != couleur)
                continue;

            if (piece.craintEchec())
                return piece;
        }
        return null;
    }

    /**
     * Détermine si le coup précisé à travers la paire de coordonnées est jouable
     * @param paireCoords Les coordonnées du coup
     * @return true si le coup est jouable, false dans le cas contraire
     */
    private boolean canCoordsBePlayed(PaireCoords paireCoords) {
        if (!isCaseOccupee(paireCoords.getCoordsDepart())) { // S'il n'y a pas de pièce aux premières coords précisées
            return false;
        }
        if (getPieceAtCoords(paireCoords.getCoordsDepart()).getCouleur() != joueurs[nbTour % 2].getCouleur()) { // Si la première pièce précisée n'est pas de la couleur du joueur
            return false;
        }

        if (!getPieceAtCoords(paireCoords.getCoordsDepart()).peutAllerEn(paireCoords.getCoordsFin(), this)) { // toute la logique de la pièce se fait ici
            return false;
        }



        if (isCaseOccupee(paireCoords.getCoordsFin())) {// Si la case d'arrivée possède une pièce, vérifier qu'elle n'est pas de la couleur du joueur
            if (getPieceAtCoords(paireCoords.getCoordsFin()).getCouleur() == joueurs[nbTour % 2].getCouleur()){
                return false;
            }
        }


        return !simulateToCheckForEchec(paireCoords, getPieceAtCoords(paireCoords.getCoordsDepart()));
    }


    /**
     * Simule le coup afin de déterminer si le roi du joueur n'est pas mis en échec par le coup qu'il veut jouer
     * @param paireCoords Les coordonnées du coup
     * @param pieceDeplacee La pièce du coup du joueur
     * @return true si le coup met le roi en échec, false dans le cas contraire
     */
    private boolean simulateToCheckForEchec(PaireCoords paireCoords, IPiece pieceDeplacee){
        IPiece pieceDeleted = null;
        boolean echec = false;

        if (isCaseOccupee(paireCoords.getCoordsFin())) {
            pieceDeleted = getPieceAtCoords(paireCoords.getCoordsFin());
            pieces.remove(pieceDeleted);
        }

        pieceDeplacee.setPos(paireCoords.getCoordsFin());

        if (isKingChecked(joueurs[nbTour%2].getCouleur()))
            echec = true;

        pieceDeplacee.setPos(paireCoords.getCoordsDepart());

        if (pieceDeleted != null)
            pieces.add(pieceDeleted);


        return echec;
    }

    /**
     * Retourne la string du gagnant
     * @return la string du gagnant
     */
    public String gagnantToString(){
        if (this.gagnant == -2)
            return "Egalité, aucun gagnant";
        return "Le gagnant est " + joueurs[this.gagnant%2].getCouleur().toString();
    }

    /**
     * Permet de récupérer l'échiquier avec ses pièces
     * @return L'échiquier sous forme d'une string
     */
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

    /**
     * Détermine si la partie est finie ou non
     * @return true si la partie est finie, false dans le cas contraire
     */
    public boolean gagnantExistant() {
        return gagnant != -1;
    }

    /**
     * Récupère aléatoirement un coup possible pour un certain joueur
     * @param couleur La couleur du joueur pour lequel on veut trouver un coup possible
     * @return Un coup possible ou null s'il n'y en a aucun
     */
    public PaireCoords getOneCoupPossible(Couleur couleur){
        Random random = new Random();
        ArrayList<PaireCoords> allCoups = getAllCoupPossible(couleur);
        if(allCoups.size() == 0)
            return null;

        System.out.println(this);

        return allCoups.get(random.nextInt(allCoups.size()));
    }

    /**
     * Permet de récupérer tous les coups possibles d'un joueur
     * @param couleur La couleur du joueur pour lequel on veut trouver un coup possible
     * @return Une array list de tous les coups possibles
     */
    private ArrayList<PaireCoords> getAllCoupPossible(Couleur couleur){
        ArrayList<PaireCoords> tabCoordsPossibles = new ArrayList<>();
        for (int i = 0; i < pieces.size() - 1; i++){
            if (pieces.get(i).getCouleur() == couleur)
                tabCoordsPossibles.addAll(getAllCoupFromOnePiece(pieces.get(i)));
        }

        return tabCoordsPossibles;
    }

    /**
     * Permet de récupérer tous les coups possibles d'une pièce
     * @param piece La pièce pour laquelle on cherche tous les coups possibles
     * @return Une array list de tous les coups possibles de la pièce
     */
    private ArrayList<PaireCoords> getAllCoupFromOnePiece(IPiece piece){
        ArrayList<PaireCoords> tabCoords = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            for (int j = MIN; j <= MAX; j++) {
                if (canCoordsBePlayed(new PaireCoords(piece.getCoords(), new Coords(i,j))))
                        tabCoords.add(new PaireCoords(new Coords(piece.getCoords()), new Coords(i, j)));
            }
        }
        return tabCoords;
    }
}
