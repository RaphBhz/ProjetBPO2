package Joueur;

import piece.Couleur;

public class Joueur {
    private Couleur couleur;

    public Joueur(Couleur couleur){
        this.couleur = couleur;
    }

    public Couleur getCouleur(){
        return this.couleur;
    }

}
