package Joueur;

import Echiquier.Coords;
import Echiquier.Plateau;
import piece.Couleur;
import piece.Roi;

import java.sql.SQLOutput;
import java.util.Scanner;

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

    public Coords setCoordsWithInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch(input){
            case "1a":
                return new Coords(1,1);
            case "1b":
                return new Coords(1,2);
            case "1c":
                return new Coords(1,3);
            case "1d":
                return new Coords(1,4);
            case "1e":
                return new Coords(1,5);
            case "1f":
                return new Coords(1,6);
            case "1g":
                return new Coords(1,7);
            case "1h":
                return new Coords(1,8);

            case "2a":
                return new Coords(2,1);
            case "2b":
                return new Coords(2,2);
            case "2c":
                return new Coords(2,3);
            case "2d":
                return new Coords(2,4);
            case "2e":
                return new Coords(2,5);
            case "2f":
                return new Coords(2,6);
            case "2g":
                return new Coords(2,7);
            case "2h":
                return new Coords(2,8);

            case "3a":
                return new Coords(3,1);
            case "3b":
                return new Coords(3,2);
            case "3c":
                return new Coords(3,3);
            case "3d":
                return new Coords(3,4);
            case "3e":
                return new Coords(3,5);
            case "3f":
                return new Coords(3,6);
            case "3g":
                return new Coords(3,7);
            case "3h":
                return new Coords(3,8);

            case "4a":
                return new Coords(4,1);
            case "4b":
                return new Coords(4,2);
            case "4c":
                return new Coords(4,3);
            case "4d":
                return new Coords(4,4);
            case "4e":
                return new Coords(4,5);
            case "4f":
                return new Coords(4,6);
            case "4g":
                return new Coords(4,7);
            case "4h":
                return new Coords(4,8);

            case "5a":
                return new Coords(5,1);
            case "5b":
                return new Coords(5,2);
            case "5c":
                return new Coords(5,3);
            case "5d":
                return new Coords(5,4);
            case "5e":
                return new Coords(5,5);
            case "5f":
                return new Coords(5,6);
            case "5g":
                return new Coords(5,7);
            case "5h":
                return new Coords(5,8);

            case "6a":
                return new Coords(6,1);
            case "6b":
                return new Coords(6,2);
            case "6c":
                return new Coords(6,3);
            case "6d":
                return new Coords(6,4);
            case "6e":
                return new Coords(6,5);
            case "6f":
                return new Coords(6,6);
            case "6g":
                return new Coords(6,7);
            case "6h":
                return new Coords(6,8);

            case "7a":
                return new Coords(7,1);
            case "7b":
                return new Coords(7,2);
            case "7c":
                return new Coords(7,3);
            case "7d":
                return new Coords(7,4);
            case "7e":
                return new Coords(7,5);
            case "7f":
                return new Coords(7,6);
            case "7g":
                return new Coords(7,7);
            case "7h":
                return new Coords(7,8);

            case "8a":
                return new Coords(8,1);
            case "8b":
                return new Coords(8,2);
            case "8c":
                return new Coords(8,3);
            case "8d":
                return new Coords(8,4);
            case "8e":
                return new Coords(8,5);
            case "8f":
                return new Coords(8,6);
            case "8g":
                return new Coords(8,7);
            case "8h":
                return new Coords(8,8);
            default:
                System.out.println("INVALID INPUT");
        }
        return null;
    }
}
