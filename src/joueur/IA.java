package joueur;

import echiquier.Plateau;
import piece.Couleur;
import utilitaire.PaireCoords;

/**
 * Cette classe représente un joueur robot
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 10/05/2021
 */

public class IA extends Player{

    public IA(Couleur couleur){
        super(couleur);
    }

    @Override
    public PaireCoords play(Plateau pl) {
        System.out.println("je rentre ici débug");
        PaireCoords coup = pl.getOneCoupPossible(this.getCouleur());
        while(coup == null)
            coup = pl.getOneCoupPossible(this.getCouleur());
        return coup;
    }
}
