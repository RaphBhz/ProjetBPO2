package Joueur;

import Echiquier.Plateau;
import piece.Couleur;
import piece.Roi;

import java.sql.SQLOutput;

public class Joueur {
    private Couleur couleur;

    public Joueur(Couleur couleur){
        this.couleur = couleur;
    }

    public Couleur getCouleur(){
        return this.couleur;
    }

    private boolean canPlay(Roi roi, Plateau pl){
        if(roi.canMove(pl)){
            return true;
        }
        return false;
    }

    public boolean aPerdu(Roi roi, Plateau pl){
        if(!this.canPlay(roi, pl)){
            return true;
        }
        return false;
    }

}
