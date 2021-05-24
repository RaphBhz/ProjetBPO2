package utilitaire;

/**
 * @author LE GAL Florian
 * @date 19/05/2021
 */
public class PaireCoords {
    private Coords coordsDepart, coordsFin;

    public PaireCoords(Coords coords, Coords coords2){
        this.coordsDepart = coords;
        this.coordsFin = coords2;
    }

    public Coords getCoordsDepart() {
        return coordsDepart;
    }

    public Coords getCoordsFin() {
        return coordsFin;
    }
}
