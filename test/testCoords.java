import Echiquier.Coords;
import org.junit.jupiter.api.Test;

public class testCoords {

    @Test
    public void testEquals(){
        Coords c1 = new Coords(1,1);
        Coords c2 = new Coords(1,1);
        Coords c3 = new Coords(2,1);
        Coords c4 = new Coords(1,2);
        assert(c1.equals(c2));
        assert(!c1.equals(c3));
        assert(!c1.equals(c4));
        assert(!c3.equals(c4));
    }
}
