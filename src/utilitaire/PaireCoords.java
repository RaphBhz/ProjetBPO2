package utilitaire;

/**
 * Classe utilitaire permettant de représenter une paire de coordonnées plus facilement.
 * Elle permet de représenter un coup. Un objet de cette classe est imuable
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 19/05/2021
 */
public class PaireCoords {
    /**
     * Les deux coordonnées d'un coup
     */
    private Coords coordsDepart, coordsFin;

    /**
     * Constructeur de la classe
     * @param coordsDepart Les coordonnées de départ d'un coup
     * @param coordsFin Les coordonnées d'arrivée d'un coup
     */
    public PaireCoords(Coords coordsDepart, Coords coordsFin){
        this.coordsDepart = coordsDepart;
        this.coordsFin = coordsFin;
    }

    /**
     * Getter permettant de récupérer les coordonnées de départ d'un coup
     * @return Les coordonnées de départ d'un coup
     */
    public Coords getCoordsDepart() {
        return coordsDepart;
    }

    /**
     * Getter permettant de récupérer les coordonnées d'arrivée d'un coup
     * @return Les coordonnées d'arrivée d'un coup
     */
    public Coords getCoordsFin() {
        return coordsFin;
    }
}
