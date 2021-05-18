package Joueur;

import Echiquier.Coords;
import Echiquier.Plateau;
import piece.Couleur;
import piece.Roi;

import java.util.ArrayList;
import java.util.regex.Pattern;

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

    public ArrayList<Coords> setInputIntoCoords(String input){
        if(validateInput(input)) {
            System.out.println("blablabla");
            return stringToCoords(input);
        }
        else{
            System.out.println("INVALID INPUT");
            return null;
        }
    }

    public boolean validateInput(String input) {
        String s = "[1-8][a-h] [1-8][a-h]";
        return Pattern.matches(s, input);
    }

    private static ArrayList<Coords> stringToCoords(String input){
        int oldColumn = Character.toUpperCase(input.charAt(1) - 64);
        int newColumn = Character.toUpperCase(input.charAt(4) - 64);
        ArrayList<Coords> pairOfCoords = new ArrayList<>();
        pairOfCoords.add(new Coords(input.charAt(0), oldColumn));
        pairOfCoords.add(new Coords(input.charAt(4), newColumn));
        return pairOfCoords;
    }
}
