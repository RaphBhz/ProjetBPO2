package joueur;

import piece.Couleur;

/**
 * @author LE GAL Florian
 * @date 19/05/2021
 */
public abstract class Player implements IPlayer{

    Couleur couleur;

    public Player(Couleur couleur){
        this.couleur = couleur;
    }

    public Couleur getCouleur(){
        return this.couleur;
    }

}
