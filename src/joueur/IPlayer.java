package joueur;

import piece.Couleur;
import utilitaire.PaireCoords;

/**
 * @author LE GAL Florian
 * @date 19/05/2021
 */
public interface IPlayer {


    Couleur getCouleur();

    PaireCoords play();

}
