package joueur;

import echiquier.Plateau;
import echiquier.Couleur;
import utilitaire.PaireCoords;

/**
 * Cette classe représente un joueur robot
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 10/05/2021
 */

public class IA extends Player{

    /**
     * Constructeur de l'IA
     * @param couleur la couleur de l'IA
     */
    public IA(Couleur couleur){
        super(couleur);
    }

    @Override
    public PaireCoords play(Plateau pl) {
        PaireCoords coup = pl.getOneCoupPossible(this.getCouleur());
        while(coup == null)
            coup = pl.getOneCoupPossible(this.getCouleur());
        return coup;
    }
}
