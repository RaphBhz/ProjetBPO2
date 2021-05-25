package joueur;

import echec.IJoueur;
import echiquier.Couleur;

/**
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 19/05/2021
 */
public abstract class Player implements IJoueur {
    /**
     * La couleur du joueur
     */
    private Couleur couleur;

    /**
     * Constructeur du joueur
     * @param couleur La couleur du joueur
     */
    public Player(Couleur couleur){
        this.couleur = couleur;
    }

    @Override
    public Couleur getCouleur(){
        return this.couleur;
    }

}
