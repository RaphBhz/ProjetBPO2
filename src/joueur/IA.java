package joueur;

import Echiquier.Plateau;
import piece.Couleur;
import utilitaire.PaireCoords;

/**
 * @author LE GAL Florian
 * @date 10/05/2021
 */
public class IA extends Player{

    public IA(Couleur couleur){
        super(couleur);
    }

    @Override
    public PaireCoords play(Plateau pl) {
        return pl.getOneCoupPossible(this.getCouleur());
    }
}
