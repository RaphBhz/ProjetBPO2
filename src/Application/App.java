package Application;

import Echiquier.Coords;
import Echiquier.FabriquePlateau;
import Echiquier.Plateau;
import Joueur.Joueur;
import piece.Couleur;
import piece.Roi;

import java.util.Scanner;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du mode de jeu: ");
        System.out.println("1- Joueur contre joueur");
        System.out.println("2- Joueur contre IA");
        System.out.println("3- IA contre IA");
        System.out.println("Défaut: IA contre IA");

        Plateau pl = FabriquePlateau.createPlateau(sc.next());
        Joueur joueur = new Joueur(Couleur.NOIR);
        System.out.println(joueur.setCoordsWithInput());

        System.out.println("wassup bitch");
        System.out.println(pl);
        pl.bouger(new Coords(1,5), new Coords(2, 5));
        //Roi roi = new Roi(new Coords(1,1));
        //roi.setPos(new Coords(2,2));
        //System.out.println(roi.getCoords().getColonne()+ "" + roi.getCoords().getLigne());
        System.out.println(pl);
        System.out.println("bye bitch");
        while (!pl.gagnantExistant())
            break;
    }
}