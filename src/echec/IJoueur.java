package echec;

import echiquier.Plateau;
import echiquier.Couleur;
import utilitaire.PaireCoords;

/**
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 19/05/2021
 */
public interface IJoueur {

    /**
     * Permet de récupérer la couleur du joueur
     * @return La couleur du joueur
     */
    Couleur getCouleur();

    /**
     * Permet de récupérer le coup d'un joueur. Ce coup n'est pas forcément valide.
     * @param pl La plateau sur lequel le joueur joue
     * @return Les coordonnées du coup que le joueur souhaite jouer
     */
    PaireCoords play(Plateau pl);

}
