package Application;

import Echec.IPiece;
import Echiquier.Coords;
import Echiquier.FabriquePlateau;
import Echiquier.Plateau;
import Joueur.Joueur;
import piece.Couleur;
import piece.Piece;
import piece.Roi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class App {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Choix du mode de jeu: ");
        System.out.println("1- Joueur contre joueur");
        System.out.println("2- Joueur contre IA");
        System.out.println("3- IA contre IA");
        System.out.println("Défaut: IA contre IA");

        Plateau pl = FabriquePlateau.createPlateau(sc1.next());

        Joueur joueur = new Joueur(Couleur.NOIR);

        // INPUT : oldCoords newCoords
        Scanner sc2 = new Scanner(System.in);
        String input = sc2.next();
        ArrayList<Coords> oldAndNewCoords = joueur.setInputIntoCoords(input);
        IPiece pieceAtCoords;
        if(oldAndNewCoords != null) { // Si y a une pièce sur la destination
            pieceAtCoords = pl.getPieceAtCoords(oldAndNewCoords.get(0)); // On identifie la pièce
            if (pieceAtCoords != null) { // Si les coordonnées sont correctes

                //ici il faudra vérifier si il s'agit d'une attaque ou d'une erreur

                pl.removePiece(pieceAtCoords); // on efface la pièce qui se fait attaquée
                pl.getPieceAtCoords(oldAndNewCoords.get(0)).setPos(oldAndNewCoords.get(0)); // on met la pièce qui bouge à sa place
            } else {
                pl.getPieceAtCoords(oldAndNewCoords.get(0)).setPos(oldAndNewCoords.get(0)); // sinon on met la pièce aux coordonnées choisies
            }
        }

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