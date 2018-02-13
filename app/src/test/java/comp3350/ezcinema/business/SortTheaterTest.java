package comp3350.ezcinema.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import comp3350.ezcinema.objects.Theater;


/**
 * Created by 74 on 2/12/2018.
 */
public class SortTheaterTest {
    private Theater theater1, theater2, theater3;
    private ArrayList<Theater> theater, sorted;
    private SortTheater sortedTheater;

    @Before
    public void setUp() throws Exception {
        theater1 = new Theater("1", "C Theater", "123 Fake Street");
        theater2 = new Theater("2", "B Theater", "234 Other Street");
        theater3 = new Theater("3", "A Theater", "345 Last Street");

        theater = new ArrayList<Theater>();
        sortedTheater = new SortTheater();

        theater.add(theater1);
        theater.add(theater2);
        theater.add(theater3);
    }

    @Test
    public void sortByName() throws Exception {

        sorted = (ArrayList<Theater>) sortedTheater.sortByName(theater);

        assertEquals("A Theater", (sorted.get(0)).getTheaterName());
    }

    @Test
    public void sortByAddress() throws Exception {

        sorted = (ArrayList<Theater>) sortedTheater.sortByAddress(theater);

        assertEquals("123 Fake Street", (sorted.get(0)).getTheaterAddress());
    }

}