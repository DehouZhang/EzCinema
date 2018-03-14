package comp3350.ezcinema.tests.business;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.util.ArrayList;

import comp3350.ezcinema.application.Main;
import comp3350.ezcinema.business.AccessTheater;
import comp3350.ezcinema.objects.Theater;
import comp3350.ezcinema.business.SortTheater;


public class SortTheaterTest extends TestCase{
    private AccessTheater accessor;
    private ArrayList theaters, sorted;
    private String [] namesOrder;
    private Theater theater;

    public void setUp() throws Exception {
        Main.startUp();
        accessor = new AccessTheater();
        theaters = new ArrayList<Theater>();
        sorted = new ArrayList<Theater>();
        accessor.getTheaters(theaters);

        namesOrder = new String[]{"Cinema City Northgate", "Cineplex Odeon McGillivray Cinemas", "Famous Players Kildonan Place Cinemas", "Scotiabank Theatre Winnipeg", "SilverCity St.Vital Cinemas"};
    }


    public void testSortByName() throws Exception {

        sorted = (ArrayList<Theater>) SortTheater.sortByName(null);

        assertNull(sorted);

        sorted = (ArrayList<Theater>) SortTheater.sortByName(theaters);

        assertNotNull(sorted);

        for(int n = 0; n < sorted.size(); n++){

            theater = (Theater) sorted.get(n);

            assertEquals(namesOrder[n], theater.getTheaterName());
        }

    }


}