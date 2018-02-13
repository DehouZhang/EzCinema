package comp3350.ezcinema.objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dow on 12/02/2018.
 */
public class MovieTest {
    private Movie movie1, movie2, movie3;

    @Before
    public void setUp() throws Exception {
        movie1 = new Movie("1", "SuperBad", "3 teens try to have a party", "Comedy", 10.0);
        movie2 = movie;
        movie3 = new Movie("2", "Amovie", "Exciting things happen", "Action", 1.0);
    }
    @Test
    public void testGetMethods() throws Exception {
        assertEquals("1", movie1.getMovieID());
        assertEquals("SuperBad", movie1.getMovieName());
        assertEquals("3 teens try to have a party", movie1.getMovieDescription());
        assertEquals(10.0, movie1.getMovieRating(), 0);
        assertEquals("Comedy", movie1.getGenre());
    }

    @Test
    public void testCompares() throws Exception{
        int result = movieNameComparator(movie1, movie3);
        assertTrue( result > 0);
    }

}