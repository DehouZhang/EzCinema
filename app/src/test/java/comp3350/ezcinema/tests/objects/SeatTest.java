package comp3350.ezcinema.tests.objects;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import comp3350.ezcinema.objects.Seat;

public class SeatTest extends TestCase
{
    private Seat goodSeat, noMovie, noTheater, noShowTime, noInput;

    @Before
    public void setUp() throws Exception
    {
        goodSeat = new Seat("agoodmovie", "atheater","10:00");
        noMovie = new Seat(null, "atheater", "10:00");
        noTheater = new Seat( "amovie", null, "10:00");
        noShowTime = new Seat("amovie", "atheater", null);
        noInput = new Seat(null,null,null);
    }

    public void testGetMethods()
    {
        assertEquals("agoodmovie", goodSeat.getMovieName());
        assertEquals("atheater", goodSeat.getTheaterName());
        assertEquals("10:00", goodSeat.getShowtime());
        assertEquals(new int[5][5].length, goodSeat.getTable().length);

        assertNull(noMovie.getMovieName());
        assertNull(noMovie.getTheaterName());
        assertNull(noMovie.getShowtime());
        assertEquals(0, noMovie.getTable().length);

        assertNull(noTheater.getMovieName());
        assertNull(noTheater.getTheaterName());
        assertNull(noTheater.getShowtime());
        assertEquals(0, noTheater.getTable().length);

        assertNull(noShowTime.getMovieName());
        assertNull(noShowTime.getTheaterName());
        assertNull(noShowTime.getShowtime());
        assertEquals(0, noShowTime.getTable().length);

        assertNull(noInput.getMovieName());
        assertNull(noInput.getTheaterName());
        assertNull(noInput.getShowtime());
        assertEquals(0, noInput.getTable().length);
    }
}
