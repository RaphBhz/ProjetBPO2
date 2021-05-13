package piece;

import Echiquier.Coords;
import Echiquier.Plateau;

public class Tour extends Piece{

    public Tour(Coords coords, Couleur couleur){
        super(coords, couleur);
    }

    private boolean coupLegal(Coords coords, Plateau pl) {
        return false;
    }

    @Override
    public boolean peutAllerEn(Coords newCoords, Plateau pl) {

        if (!this.coupLegal(newCoords, pl))
            return false;

        Coords currentCoords =  this.getCoords();
        // check si déplacement est vertical
        if (currentCoords.getColonne() == newCoords.getColonne() &&
            currentCoords.getLigne() != newCoords.getLigne()) {
            if (currentCoords.getLigne() > newCoords.getLigne())
                return checkAllCoordsUnder(currentCoords.getLigne(), newCoords.getLigne(), pl);
            else
                return checkAllCoordsUpper(currentCoords.getLigne(), newCoords.getLigne(), pl);
        }
        else if ((currentCoords.getColonne() != newCoords.getColonne() &&
                currentCoords.getLigne() == newCoords.getLigne())) {

            if (currentCoords.getColonne() > newCoords.getColonne())
                return checkAllCoordsRight(currentCoords.getColonne(), newCoords.getColonne(), pl);
            else
                return checkAllCoordsLeft(currentCoords.getColonne(), newCoords.getColonne(), pl);
        }
        else
            return false;
    }

    private boolean checkAllCoordsUnder(int debut, int fin, Plateau pl){
        for (int i = debut - 1; i>=fin; i--){
            if(pl.isCaseOccupee(new Coords(this.getCoords().getLigne(),i )))
                return i == fin &&
                        pl.getPieceAtCoords(new Coords(this.getCoords().getLigne(), i)).getCouleur() != this.getCouleur();
        }
        return true;
    }

    private boolean checkAllCoordsLeft(int debut, int fin, Plateau pl){
        for (int i = debut - 1; i>=fin; i--){
            if(pl.isCaseOccupee(new Coords(i, this.getCoords().getColonne())))
                return i == fin &&
                        pl.getPieceAtCoords(new Coords(this.getCoords().getColonne(), i)).getCouleur() != this.getCouleur();
        }
        return true;
    }

    private boolean checkAllCoordsUpper(int debut, int fin, Plateau pl){
        for (int i = debut + 1; i<=fin; i++){
            if(pl.isCaseOccupee(new Coords(this.getCoords().getLigne(),i )))
                return i == fin &&
                        pl.getPieceAtCoords(new Coords(this.getCoords().getLigne(), i)).getCouleur() != this.getCouleur();
        }
        return true;
    }

    private boolean checkAllCoordsRight(int debut, int fin, Plateau pl){
        for (int i = debut + 1; i<=fin; i++){
            if(pl.isCaseOccupee(new Coords(i, this.getCoords().getColonne())))
                return i == fin &&
                        pl.getPieceAtCoords(new Coords(this.getCoords().getColonne(), i)).getCouleur() != this.getCouleur();
        }
        return true;
    }

    @Override
    public boolean menace(Coords coords) {
        return false;
    }

    @Override
    public String toString() {
        return isBlack() ? "t" : "T";
    }
}
