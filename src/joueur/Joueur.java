package joueur;

import utilitaire.Coords;
import Echiquier.Plateau;
import exception.InputNotRightException;
import piece.Couleur;
import piece.Roi;
import utilitaire.PaireCoords;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Joueur extends Player{

    public Joueur(Couleur couleur){
        super(couleur);
    }

    @Override
    public PaireCoords play(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        while (!validateInput(s)) {
            System.out.println("Input invalide");
            s = sc.nextLine();
        }
        return stringToCoords(s);
    }

    public boolean canPlay(Roi roi, Plateau pl){
        return roi.canMove(pl);
    }

    private PaireCoords stringToCoords(String input){

        Coords firstCoords = new Coords(Integer.parseInt(String.valueOf(input.charAt(0))),Character.getNumericValue(Character.toLowerCase(input.charAt(1) - 48)));
        Coords secondCoords = new Coords(Integer.parseInt(String.valueOf(input.charAt(3))),Character.getNumericValue(Character.toLowerCase(input.charAt(4) - 48)));
        return new PaireCoords(firstCoords, secondCoords);
    }

    private boolean validateInput(String input) {
        String s = "[1-8][a-h] [1-8][a-h]";
        return Pattern.matches(s, input);
    }

}
