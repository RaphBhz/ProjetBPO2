package Echiquier;

/**
 * @author LE GAL Florian
 * @date 10/05/2021
 */
public class FabriquePlateau {
    public static Plateau createPlateau(String choice){
        switch (choice){
            case "1":
                return new Plateau();
            default:
                return new Plateau();
        }

    }
}
