package Application;

import Echiquier.Plateau;

/**
 * @author LE GAL Florian
 * @date 27/04/2021
 */
public class App {
    public static void main(String[] args) {
        System.out.println("wassup bitch");
        Plateau pl = new Plateau();
        System.out.println(pl);
        pl.bouger("R", 5, 2);
        System.out.println(pl);
        System.out.println("bye bitch");
    }
}
