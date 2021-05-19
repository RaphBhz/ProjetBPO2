package Echiquier;

import joueur.Joueur;
import piece.Couleur;

/**
 * @author LE GAL Florian
 * @date 10/05/2021
 */
public class FabriquePlateau {
    public static Plateau createPlateau(String choice){
        switch (choice){
            case "1":
                return new Plateau(new Joueur(Couleur.BLANC), new Joueur(Couleur.NOIR));
            default:
                return new Plateau(new Joueur(Couleur.BLANC), new Joueur(Couleur.NOIR));
        }

    }
}
