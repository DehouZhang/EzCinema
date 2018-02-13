package comp3350.ezcinema.objects;

import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Created by Dow on 12/02/2018.
 */
public class TheaterTest {

    private Theater theater1, theater2, theater3;
    private Comparator<Theater> theaterNameComp;
    private Comparator<Theater> theaterAddressComp;

    @Before
    public void setUp() throws Exception{
        theater1 = new Theater("1", "cineplex", "a road");
        theater2 = new Theater("2", "IMAX", "a different road");
        theater3 = theater1;
        theaterNameComp = Theater.TheaterNameComparator;
        theaterAddressComp = Theater.TheaterAddressComparator;
    }
    @Test
    public void testGetMethods() throws Exception {
        assertEquals("cineplex", theater1.getTheaterName());
        assertEquals("a road", theater1.getTheaterAddress());
    }

    @Test
    public void testCompares() throws Exception{

        assertTrue( theaterNameComp.compare(theater1, theater2) < 0);
        assertTrue( theaterNameComp.compare(theater1, theater3) == 0);
        assertTrue( theaterNameComp.compare(theater2, theater1) > 0);

        assertTrue( theaterAddressComp.compare(theater1, theater2) > 0);
        assertTrue( theaterAddressComp.compare(theater1, theater3) == 0);
        assertTrue( theaterAddressComp.compare(theater2, theater1) < 0);
    }

}