package joueur;

import utilitaire.Coords;
import echiquier.Plateau;
import echiquier.Couleur;
import utilitaire.PaireCoords;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Joueur extends Player{

    /**
     * Constructeur du joueur
     * @param couleur la couleur du joueur
     */
    public Joueur(Couleur couleur){
        super(couleur);
    }

    @Override
    public PaireCoords play(Plateau pl){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        while (!validateInput(s.toLowerCase(Locale.ROOT))) {
            System.out.println("Input invalide");
            s = sc.nextLine();
        }
        return stringToCoords(s.toLowerCase(Locale.ROOT));
    }

    /**
     * Permet de transformer l'input du joueur en coordonnées
     * @param input La string contenant l'input du joueur
     * @return Les coordonnées du coup
     */
    private PaireCoords stringToCoords(String input){

        Coords firstCoords = new Coords(Integer.parseInt(String.valueOf(input.charAt(0))),Character.getNumericValue(Character.toLowerCase(input.charAt(1) - 48)));
        Coords secondCoords = new Coords(Integer.parseInt(String.valueOf(input.charAt(3))),Character.getNumericValue(Character.toLowerCase(input.charAt(4) - 48)));
        return new PaireCoords(firstCoords, secondCoords);
    }

    /**
     * Détermine si l'input du joueur est correct
     * @param input L'input du joueur sous forme d'une string
     * @return true si l'input est bon, false dans le cas contraire
     */
    private boolean validateInput(String input) {
        String s = "[1-8][a-h] [1-8][a-h]";
        return Pattern.matches(s, input);
    }

}
