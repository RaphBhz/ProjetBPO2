package application;


import echiquier.FabriquePlateau;
import echiquier.Plateau;

import java.util.Scanner;

/**
 * Le main du programme
 * @author LE GAL Florian, BEN FRAJ Ayoub, BOUCHEZ Raphaël
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

        Plateau pl = FabriquePlateau.createPlateau(sc.nextLine());
        System.out.println(pl);
        System.out.println("Pour jouer un coup : Coordonnées de départ suivie des Coordonnées d'arrivée");
        System.out.println("Exemple : 2E 3E");


        while (!pl.gagnantExistant()) {
            pl.play();
            //System.out.println("Pièce déplacée en " + paireCoords.getCoordsFin()); // peut-être utiliser les exceptions et donc faire un try catch
            System.out.println(pl);
            //break;
        }

    }
}