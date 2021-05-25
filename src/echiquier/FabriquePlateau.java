package echiquier;

import joueur.IA;
import joueur.Joueur;

/**
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
 * @date 10/05/2021
 */
public class FabriquePlateau {
    /**
     * Fabrique de plateau avec ses joueurs
     * @param choice "1" = Joueur contre Joueur | "2" = Joueur contre IA | "*" IA contre IA
     * @return Un plateau avec ses joueurs
     */
    public static Plateau createPlateau(String choice){
        switch (choice){
            case "1":
                return new Plateau(new Joueur(Couleur.BLANC), new Joueur(Couleur.NOIR));

            case "2":
                return new Plateau(new Joueur(Couleur.BLANC), new IA(Couleur.NOIR));

            default:
                return new Plateau(new IA(Couleur.BLANC), new IA(Couleur.NOIR));
        }

    }
}
