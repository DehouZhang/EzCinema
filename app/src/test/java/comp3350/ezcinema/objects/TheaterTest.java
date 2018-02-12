package comp3350.ezcinema.objects;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dow on 12/02/2018.
 */
public class TheaterTest {

    private Theater theater = new Theater("1", "cineplex", "a road");
    @Test
    public void getTheaterName() throws Exception {
        assertEquals("cineplex", theater.getTheaterName());
    }

    @Test
    public void getTheaterAddress() throws Exception {
        assertEquals("a road", theater.getTheaterAddress());
    }

}